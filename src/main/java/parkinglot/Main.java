package main.java.parkinglot;

import main.java.parkinglot.vehicle.*;
import main.java.parkinglot.gate.*;
import main.java.parkinglot.lot.*;
import main.java.parkinglot.pricing.*;

public class Main {
    public static void main(String[] args) {
        // Create parking lot
        ParkingLot lot = new ParkingLot();

        // Add pricing strategy
        PerHourPricingStrategy pricing = new PerHourPricingStrategy();

        // Gates
        EntryGate entry = new EntryGate("E1", lot);
        ExitGate exit = new ExitGate("X1", lot, pricing);

        // Create vehicle
        main.java.parkinglot.vehicle.Vehicle car = new Car("KA01AB1234");

        // Park vehicle
        Ticket ticket = entry.generateTicket(car);
        System.out.println("Ticket issued: " + ticket.getTicketId());

        // Exit after some time
        double fee = exit.processExit(ticket.getTicketId());
        System.out.println("Fee: " + fee);
    }
}
