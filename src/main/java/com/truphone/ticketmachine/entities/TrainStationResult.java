package com.truphone.ticketmachine.entities;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TrainStationResult {

    private List<TrainStation> stations;
    private Set<Character> nextChararcters;
    
    public TrainStationResult(){
        this.stations = new ArrayList<TrainStation>();
        this.nextChararcters = new HashSet<Character>();
    }

    public Set<Character> getNextChararcters() {
        return nextChararcters;
    }

    public void setNextChararcters(Set<Character> nextChararcters) {
        this.nextChararcters = nextChararcters;
    }

    public List<TrainStation> getStations() {
        return stations;
    }

    public void setStations(List<TrainStation> stations) {
        this.stations = stations;
    }
    
    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        
        stringBuilder.append(String.format("Matched stations: %s\n", getStations().toString()));
        stringBuilder.append(String.format("Next characters: %s\n", getNextChararcters().toString()));
        
        return stringBuilder.toString();
    }
}
