package main.java.parkinglot.vehicle;

public abstract class Vehicle {
    protected String vehicleNo;

    public Vehicle(String vehicleNo) {
        this.vehicleNo = vehicleNo;
    }

    public String getVehicleNo() {
        return vehicleNo;
    }

    public abstract String getType();
}
