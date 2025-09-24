package main.java.parkinglot.gate;

import main.java.parkinglot.lot.ParkingLot;
import main.java.parkinglot.lot.Ticket;
import main.java.parkinglot.vehicle.Vehicle;

public class EntryGate {
    private String gateId;
    private ParkingLot lot;

    public EntryGate(String gateId, ParkingLot lot) {
        this.gateId = gateId;
        this.lot = lot;
    }

    public Ticket generateTicket(Vehicle vehicle) {
        return lot.parkVehicle(vehicle);
    }
}
