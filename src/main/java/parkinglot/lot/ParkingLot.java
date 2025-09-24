package main.java.parkinglot.lot;

import java.util.*;
import main.java.parkinglot.vehicle.Vehicle;
import main.java.parkinglot.pricing.PricingStrategy;

public class ParkingLot {
    private List<ParkingSpot> spots = new ArrayList<>();
    private Map<String, Ticket> activeTickets = new HashMap<>();

    public ParkingLot() {
        // Add some parking spots
        for (int i = 0; i < 10; i++) {
            spots.add(new ParkingSpot("S" + i, true));
        }
    }

    public List<ParkingSpot> getAvailableSpots() {
        List<ParkingSpot> free = new ArrayList<>();
        for (ParkingSpot spot : spots) {
            if (spot.isAvailable())
                free.add(spot);
        }
        return free;
    }

    public Ticket parkVehicle(Vehicle vehicle) {
        for (ParkingSpot spot : spots) {
            if (spot.isAvailable()) {
                spot.assignVehicle(vehicle);
                Ticket ticket = new Ticket(UUID.randomUUID().toString(), vehicle, System.currentTimeMillis());
                activeTickets.put(ticket.getTicketId(), ticket);
                return ticket;
            }
        }
        return null;
    }

    public double exitVehicle(String ticketId, PricingStrategy strategy) {
        Ticket ticket = activeTickets.remove(ticketId);
        if (ticket == null)
            return 0;

        // Free the spot
        for (ParkingSpot spot : spots) {
            if (spot.getVehicle() == ticket.getVehicle()) {
                spot.removeVehicle();
                break;
            }
        }
        long exitTime = System.currentTimeMillis();
        return strategy.calculateFee(ticket, exitTime);
    }
}
