package com.elastic.demo.app;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;

import java.net.InetAddress;
import java.net.UnknownHostException;

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

        }
        catch( UnknownHostException e )
        {
            e.printStackTrace();
        }
    }
}
