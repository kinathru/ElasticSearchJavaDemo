package com.elastic.demo.utils;

import com.elastic.demo.movie.Genre;
import com.elastic.demo.movie.GenreResult;
import com.elastic.demo.movie.MovieResult;
import com.elastic.demo.movie.MovieSearchResult;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Kinath on 6/11/2017.
 */
public class MovieUtils
{
    public static List<MovieResult> getMovieList( HttpClient apacheHttpClient, ObjectMapper objectMapper, String apiKey )
    {
        List<MovieResult> movieResultList;
        HttpGet movieSearchRequest = RequestUtils.generateMovieSearchRequest( apiKey, "2015", 1, false, null, -1, -1 );
        HttpResponse movieResponse = null;
        MovieSearchResult movieSearchResult = null;
        movieResultList = new ArrayList<MovieResult>();
        int page = 1;
        int totalPages = -1;

        try
        {
            movieResponse = apacheHttpClient.execute( movieSearchRequest );
            movieSearchResult = objectMapper.readValue( movieResponse.getEntity().getContent(), MovieSearchResult.class );
            totalPages = movieSearchResult.getTotalPages();
            movieResultList.addAll( movieSearchResult.getResults() );
            while( page < totalPages )
            {
                System.out.println( "Processing Page : " + page );
                page++;
                movieSearchRequest = RequestUtils.generateMovieSearchRequest( apiKey, "2015", page, false, null, -1, -1 );
                movieResponse = apacheHttpClient.execute( movieSearchRequest );
                movieSearchResult = objectMapper.readValue( movieResponse.getEntity().getContent(), MovieSearchResult.class );
                movieResultList.addAll( movieSearchResult.getResults() );
            }

            return movieResultList;
        }
        catch( IOException e )
        {
            e.printStackTrace();
        }
        return null;
    }

    public static HashMap<Integer, String> getGenreMap( HttpClient apacheHttpClient, ObjectMapper objectMapper, String apiKey )
    {
        HashMap<Integer, String> genreMap;
        HttpGet genreRequest = RequestUtils.genreSearchRequest( apiKey );
        HttpResponse genreResponse = null;
        GenreResult genreResult = null;
        genreMap = new HashMap<Integer, String>();

        try
        {
            genreResponse = apacheHttpClient.execute( genreRequest );
            genreResult = objectMapper.readValue( genreResponse.getEntity().getContent(), GenreResult.class );
            for( Genre genre : genreResult.getGenres() )
            {
                genreMap.put( genre.getId(), genre.getName() );
            }
            return genreMap;
        }
        catch( IOException e )
        {
            e.printStackTrace();
        }
        return null;
    }
}
