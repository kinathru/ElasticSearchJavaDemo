package com.elastic.demo.app;

import com.elastic.demo.movie.MovieResult;
import com.elastic.demo.utils.CommonUtils;
import com.elastic.demo.utils.MovieUtils;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;

import java.net.InetAddress;
import java.net.UnknownHostException;
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
            client.addTransportAddress( new InetSocketTransportAddress( InetAddress.getLocalHost(), 9200 ) );
            ObjectMapper mapper = new ObjectMapper();


            HttpClient httpClient = HttpClientBuilder.create().build();
            Properties properties = CommonUtils.loadConfigurations();
            String apiKey = properties.getProperty( "API_KEY" );

            List<MovieResult> movieResults = MovieUtils.getMovieList( httpClient,mapper, apiKey );
            Map<Integer, String> genreMap = MovieUtils.getGenreMap( httpClient, mapper, apiKey );

            System.out.println("DONE");

        }
        catch( UnknownHostException e )
        {
            e.printStackTrace();
        }
    }
}
