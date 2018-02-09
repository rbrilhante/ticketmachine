package com.truphone.ticketmachine.repository;

import java.util.ArrayList;
import java.util.List;

import com.truphone.ticketmachine.entities.TrainStation;
import com.truphone.ticketmachine.properties.StationsProperties;

public class StationsRepository implements IStationsRepository{
    
    private List<TrainStation> trainStations;

    public StationsRepository() {
        List<String> stations = StationsProperties.getStations();
        this.trainStations = new ArrayList<TrainStation>();
        for(String station : stations){
            TrainStation trainStation = new TrainStation(station);
            this.trainStations.add(trainStation);
        }
    }

    @Override
    public List<TrainStation> getTrainStations() {
        return trainStations;
    }

    @Override
    public void setTrainStations(List<TrainStation> trainStations) {
        this.trainStations = trainStations;
    }
}
