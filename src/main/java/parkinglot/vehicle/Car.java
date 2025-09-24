package main.java.parkinglot.vehicle;

public class Car extends Vehicle {
    public Car(String vehicleNo) {
        super(vehicleNo);
    }

    @Override
    public String getType() {
        return "Car";
    }
}
