package main.java.parkinglot.gate;

import main.java.parkinglot.lot.ParkingLot;
import main.java.parkinglot.pricing.PricingStrategy;

public class ExitGate {
    private String gateId;
    private ParkingLot lot;
    private PricingStrategy pricingStrategy;

    public ExitGate(String gateId, ParkingLot lot, PricingStrategy pricingStrategy) {
        this.gateId = gateId;
        this.lot = lot;
        this.pricingStrategy = pricingStrategy;
    }

    public double processExit(String ticketId) {
        return lot.exitVehicle(ticketId, pricingStrategy);
    }
}
