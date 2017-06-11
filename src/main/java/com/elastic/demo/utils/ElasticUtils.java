package com.elastic.demo.utils;

import org.elasticsearch.action.bulk.BulkProcessor;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.client.transport.TransportClient;

/**
 * Created by Kinath on 6/11/2017.
 */
public class ElasticUtils
{
    public  static BulkProcessor getBulkProcessor( TransportClient client)
    {
        BulkProcessor bulkProcessor = BulkProcessor.builder( client, new BulkProcessor.Listener()
        {
            public void beforeBulk( long l, BulkRequest bulkRequest )
            {
                System.out.println("Preparing to inser the index : " + bulkRequest.toString());
            }

            public void afterBulk( long l, BulkRequest bulkRequest, BulkResponse bulkResponse )
            {
                System.out.println("Index inserted sucessfully : " + bulkRequest.toString() + " -- " + bulkResponse.toString());
            }

            public void afterBulk( long l, BulkRequest bulkRequest, Throwable throwable )
            {
                System.out.println("Failed to insert the index : " + throwable.getMessage());
            }
        } ).setBulkActions( 200 ).setConcurrentRequests( 0 ).build();
        return bulkProcessor;
    }
}
