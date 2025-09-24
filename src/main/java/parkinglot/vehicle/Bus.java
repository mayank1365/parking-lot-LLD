package main.java.parkinglot.vehicle;

public class Bus extends Vehicle {
    public Bus(String vehicleNo) {
        super(vehicleNo);
    }

    @Override
    public String getType() {
        return "Bus";
    }
}
