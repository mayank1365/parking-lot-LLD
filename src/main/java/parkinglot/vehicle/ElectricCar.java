package main.java.parkinglot.vehicle;

public class ElectricCar extends Vehicle implements ElectricVehicle {
    private boolean wantsCharging;

    public ElectricCar(String vehicleNo) {
        super(vehicleNo);
    }

    @Override
    public String getType() {
        return "ElectricCar";
    }

    @Override
    public boolean wantsCharging() {
        return wantsCharging;
    }

    @Override
    public void setWantsCharging(boolean flag) {
        this.wantsCharging = flag;
    }
}
