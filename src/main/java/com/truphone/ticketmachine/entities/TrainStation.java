package com.truphone.ticketmachine.entities;

public class TrainStation {
    
    private String name;

    public TrainStation(String station) {
        this.setName(station);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public Character getNextCharacter(int index){
        return name.charAt(index + 1);
    }
    
    @Override
    public String toString(){
        return name;
    }

    public boolean startsWith(String searchQuery) {
        return this.name.toLowerCase().startsWith(searchQuery.toLowerCase());
    }

}
