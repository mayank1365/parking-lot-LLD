package main.java.parkinglot.vehicle;

public class Bike extends Vehicle {
    public Bike(String vehicleNo) {
        super(vehicleNo);
    }

    @Override
    public String getType() {
        return "Bike";
    }
}
