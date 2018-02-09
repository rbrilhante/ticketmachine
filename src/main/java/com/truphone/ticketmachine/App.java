package com.truphone.ticketmachine;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.truphone.ticketmachine.entities.TrainStationResult;
import com.truphone.ticketmachine.service.ITicketMachineService;
import com.truphone.ticketmachine.service.TicketMachineService;

public class App 
{
    public static void main( String[] args )
    {
        ITicketMachineService ticketMachineService = new TicketMachineService();
        
        final BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

        while(true) {
            System.out.print("Please type a station name (type 'QUIT' to exit): ");
            try {
                String querySearch = input.readLine();
                
                if(querySearch.equalsIgnoreCase("QUIT")){
                    System.exit(0);
                }
                
                TrainStationResult trainStationResult = ticketMachineService.getTrainStationsAndNextCharacters(querySearch);
                System.out.print(trainStationResult.toString());
            } catch (IOException ioe) {
                System.exit(1);
            }
        }
    }
}
