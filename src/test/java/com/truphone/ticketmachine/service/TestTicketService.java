package com.truphone.ticketmachine.service;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.truphone.ticketmachine.entities.TrainStation;
import com.truphone.ticketmachine.entities.TrainStationResult;
import com.truphone.ticketmachine.repository.IStationsRepository;

public class TestTicketService {
    
    @Test
    public void testNoStations(){
        TicketMachineService ticketMachineService = new TicketMachineService();
        IStationsRepository stationRepo = ticketMachineService.getStationsRepo();
        stationRepo.setTrainStations(new ArrayList<>());
        
        TrainStationResult trainStationResult = ticketMachineService.getTrainStationsAndNextCharacters("DART");
        assert(trainStationResult.getStations().isEmpty());
        assert(trainStationResult.getNextChararcters().isEmpty());
    }
    
    @Test
    public void testNullStations(){
        TicketMachineService ticketMachineService = new TicketMachineService();
        IStationsRepository stationRepo = ticketMachineService.getStationsRepo();
        stationRepo.setTrainStations(null);
        
        TrainStationResult trainStationResult = ticketMachineService.getTrainStationsAndNextCharacters("DART");
        assert(trainStationResult.getStations().isEmpty());
        assert(trainStationResult.getNextChararcters().isEmpty());
    }
    
    @Test
    public void testNoQuery(){
        TicketMachineService ticketMachineService = new TicketMachineService();
        IStationsRepository stationRepo = ticketMachineService.getStationsRepo();
        List<TrainStation> trainStations = new ArrayList<>();
        TrainStation dartford = new TrainStation("DARTFORD");
        TrainStation liverpool = new TrainStation("LIVERPOOL");
        trainStations.add(dartford);
        trainStations.add(liverpool);
        stationRepo.setTrainStations(trainStations);
        
        TrainStationResult trainStationResult = ticketMachineService.getTrainStationsAndNextCharacters("");
        assert(trainStationResult.getStations().contains(dartford));
        assert(trainStationResult.getStations().contains(liverpool));
        assert(trainStationResult.getNextChararcters().contains('D'));
        assert(trainStationResult.getNextChararcters().contains('L'));
    }
    
    @Test
    public void testNonExistentStation(){
        TicketMachineService ticketMachineService = new TicketMachineService();
        IStationsRepository stationRepo = ticketMachineService.getStationsRepo();
        List<TrainStation> trainStations = new ArrayList<>();
        TrainStation dartford = new TrainStation("DARTFORD");
        TrainStation liverpool = new TrainStation("LIVERPOOL");
        trainStations.add(dartford);
        trainStations.add(liverpool);
        stationRepo.setTrainStations(trainStations);
        
        TrainStationResult trainStationResult = ticketMachineService.getTrainStationsAndNextCharacters("TOWER");
        assert(trainStationResult.getStations().isEmpty());
        assert(trainStationResult.getNextChararcters().isEmpty());
    }
    
    @Test
    public void testQueryWhiteSpace(){
        TicketMachineService ticketMachineService = new TicketMachineService();
        IStationsRepository stationRepo = ticketMachineService.getStationsRepo();
        List<TrainStation> trainStations = new ArrayList<>();
        TrainStation dartford = new TrainStation("DARTFORD");
        TrainStation liverpool = new TrainStation("LIVERPOOL");
        TrainStation liverpoolLimeStreet = new TrainStation("LIVERPOOL LIME STREET");
        trainStations.add(dartford);
        trainStations.add(liverpool);
        trainStations.add(liverpoolLimeStreet);
        stationRepo.setTrainStations(trainStations);
        
        TrainStationResult trainStationResult = ticketMachineService.getTrainStationsAndNextCharacters("LIVERPOOL");
        assert(!trainStationResult.getStations().contains(dartford));
        assert(trainStationResult.getStations().contains(liverpool));
        assert(trainStationResult.getStations().contains(liverpoolLimeStreet));
        assert(trainStationResult.getNextChararcters().size() == 1);
        assert(trainStationResult.getNextChararcters().contains(' '));
    }
    
    @Test
    public void testExistingStation(){
        TicketMachineService ticketMachineService = new TicketMachineService();
        IStationsRepository stationRepo = ticketMachineService.getStationsRepo();
        List<TrainStation> trainStations = new ArrayList<>();
        TrainStation dartford = new TrainStation("DARTFORD");
        TrainStation liverpool = new TrainStation("LIVERPOOL");
        TrainStation darthmouth = new TrainStation("DARTMOUTH");
        trainStations.add(dartford);
        trainStations.add(liverpool);
        trainStations.add(darthmouth);
        stationRepo.setTrainStations(trainStations);
        
        TrainStationResult trainStationResult = ticketMachineService.getTrainStationsAndNextCharacters("DART");
        assert(!trainStationResult.getStations().contains(liverpool));
        assert(trainStationResult.getStations().contains(dartford));
        assert(trainStationResult.getStations().contains(darthmouth));
        assert(trainStationResult.getNextChararcters().size() == 2);
        assert(trainStationResult.getNextChararcters().contains('F'));
        assert(trainStationResult.getNextChararcters().contains('M'));
    }

}
