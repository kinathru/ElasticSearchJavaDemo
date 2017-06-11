package com.elastic.demo.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by Kinath on 6/11/2017.
 */
public class CommonUtils
{
    public static Properties loadConfigurations()
    {
        InputStream inputStream = null;
        Properties prop = new Properties();

        try
        {
            inputStream = new FileInputStream( "src\\main\\resources\\apiconfig.properties" );
            prop.load( inputStream );

            return prop;
        }
        catch( FileNotFoundException e )
        {
            e.printStackTrace();
        }
        catch( IOException e )
        {
            e.printStackTrace();
        }
        finally
        {
            try
            {
                inputStream.close();
            }
            catch( IOException e )
            {
                e.printStackTrace();
            }
        }

        return null;
    }
}
