package com.truphone.ticketmachine.service;

import com.truphone.ticketmachine.entities.TrainStationResult;

public interface ITicketMachineService {
    
    public TrainStationResult getTrainStationsAndNextCharacters(String searchQuery);

}
