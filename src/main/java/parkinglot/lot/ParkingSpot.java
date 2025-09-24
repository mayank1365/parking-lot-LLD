package main.java.parkinglot.lot;

import main.java.parkinglot.vehicle.Vehicle;

public class ParkingSpot {
    private String spotId;
    private Vehicle vehicle;
    private boolean electricChargers;

    public ParkingSpot(String spotId, boolean electricChargers) {
        this.spotId = spotId;
        this.electricChargers = electricChargers;
    }

    public boolean isAvailable() {
        return vehicle == null;
    }

    public void assignVehicle(Vehicle v) {
        this.vehicle = v;
    }

    public void removeVehicle() {
        this.vehicle = null;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }
}
