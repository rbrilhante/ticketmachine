package com.truphone.ticketmachine.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import com.truphone.ticketmachine.entities.TrainStation;
import com.truphone.ticketmachine.entities.TrainStationResult;
import com.truphone.ticketmachine.repository.IStationsRepository;
import com.truphone.ticketmachine.repository.StationsRepository;

public class TicketMachineService implements ITicketMachineService{
    
    IStationsRepository stationsRepo;

    public TicketMachineService(){
        this.stationsRepo = new StationsRepository();
    }
    
    public IStationsRepository getStationsRepo() {
        return stationsRepo;
    }
    
    private List<TrainStation> getTrainStationsByPrefix(String searchQuery){
        List<TrainStation> trainStations = this.stationsRepo.getTrainStations();
        if(trainStations != null){
            return trainStations.stream().filter(station -> station.startsWith(searchQuery)).collect(Collectors.toList());
        }
        return new ArrayList<TrainStation>();
    }
    
    private Set<Character> getNextCharacterByRange(List<TrainStation> stations, int index){
        Set<Character> nextCharacters = new HashSet<>();
        stations.stream().forEach(station -> {
            if(index < station.getName().length())
                nextCharacters.add(station.getName().charAt(index));
        });
        return nextCharacters;
    }
    
    @Override
    public TrainStationResult getTrainStationsAndNextCharacters(String searchQuery){
        TrainStationResult trainStationResult = new TrainStationResult();
        List<TrainStation> stations = getTrainStationsByPrefix(searchQuery);
        Set<Character> nextCharecters = getNextCharacterByRange(stations, searchQuery.length());
        trainStationResult.setStations(stations);
        trainStationResult.setNextChararcters(nextCharecters);
        return trainStationResult;
    }

}
