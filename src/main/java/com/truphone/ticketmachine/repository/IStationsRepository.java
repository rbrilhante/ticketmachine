package com.truphone.ticketmachine.repository;

import java.util.List;

import com.truphone.ticketmachine.entities.TrainStation;

public interface IStationsRepository {
    
    public List<TrainStation> getTrainStations();

    void setTrainStations(List<TrainStation> trainStations);

}
