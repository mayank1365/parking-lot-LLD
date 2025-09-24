package main.java.parkinglot.pricing;

import main.java.parkinglot.lot.Ticket;

public class PerHourPricingStrategy implements PricingStrategy {
    private double ratePerHour = 20.0;

    @Override
    public double calculateFee(Ticket ticket, long exitTime) {
        long durationMs = exitTime - ticket.getEntryTime();
        long hours = Math.max(1, durationMs / (1000 * 60 * 60));
        return hours * ratePerHour;
    }
}
