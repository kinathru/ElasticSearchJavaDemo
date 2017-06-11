package com.elastic.demo.app;

import com.elastic.demo.eltypes.Movie;
import com.elastic.demo.movie.MovieResult;
import com.elastic.demo.utils.CommonUtils;
import com.elastic.demo.utils.ElasticUtils;
import com.elastic.demo.utils.MovieUtils;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.elasticsearch.action.bulk.BulkProcessor;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;

/**
 * Created by Kinath on 6/8/2017.
 */
public class Main
{
    public static void main( String[] args )
    {
        Settings settings = Settings.builder().put( "cluster.name", "demo-cluster" ).build();
        TransportClient client = new PreBuiltTransportClient( settings );
        try
        {
            client.addTransportAddress( new InetSocketTransportAddress( InetAddress.getByName( "localhost" ) , 9300 ) );
            ObjectMapper mapper = new ObjectMapper();

            HttpClient httpClient = HttpClientBuilder.create().build();
            Properties properties = CommonUtils.loadConfigurations();
            String apiKey = properties.getProperty( "API_KEY" );

            List<MovieResult> movieResults = MovieUtils.getMovieList( httpClient,mapper, apiKey );
            Map<Integer, String> genreMap = MovieUtils.getGenreMap( httpClient, mapper, apiKey );

            BulkProcessor bulkProcessor = ElasticUtils.getBulkProcessor( client );

            for( MovieResult mr : movieResults )
            {
                List<String> genIds = new ArrayList<String>();
                for( Integer genId : mr.getGenreIds() )
                {
                    genIds.add( genreMap.get( genId ) );
                }

                Movie movie = new Movie( mr.getVoteCount(), mr.getId(), mr.getVideo(), mr.getVoteAverage(), mr.getTitle(), mr.getPopularity(), mr.getOriginalLanguage(), mr.getOriginalTitle(), genIds, mr.getOverview(), mr.getReleaseDate() );

                try
                {
                    byte [] json = mapper.writeValueAsBytes( movie );
                    bulkProcessor.add( new IndexRequest( "moviedb", "movie", String.valueOf( movie.getId() ) ).source(json) );
                }
                catch( JsonProcessingException e )
                {
                    e.printStackTrace();
                }
            }

            bulkProcessor.flush();
            bulkProcessor.close();

            System.out.println("DONE");

        }
        catch( UnknownHostException e )
        {
            e.printStackTrace();
        }
    }
}
