package main.java.parkinglot.lot;

import main.java.parkinglot.vehicle.Vehicle;

public class Ticket {
    private String ticketId;
    private Vehicle vehicle;
    private long entryTime;

    public Ticket(String ticketId, Vehicle vehicle, long entryTime) {
        this.ticketId = ticketId;
        this.vehicle = vehicle;
        this.entryTime = entryTime;
    }

    public String getTicketId() {
        return ticketId;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public long getEntryTime() {
        return entryTime;
    }
}
