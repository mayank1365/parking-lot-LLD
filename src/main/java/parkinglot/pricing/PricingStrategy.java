package main.java.parkinglot.pricing;

import main.java.parkinglot.lot.Ticket;

public interface PricingStrategy {
    double calculateFee(Ticket ticket, long exitTime);
}
