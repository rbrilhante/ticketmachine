package com.truphone.ticketmachine.properties;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

public class StationsProperties {

    public static List<String> getStations(){
        InputStream input = StationsProperties.class.getClassLoader().getResourceAsStream("train_stations.properties");
        Properties prop = new Properties();
        try {
            prop.load(input);
            String stations = prop.getProperty("train.stations");
            if(stations != null){
                return Arrays.asList(stations.split(","));
            }
            
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }
}
