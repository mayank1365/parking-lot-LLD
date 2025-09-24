## Parking Lot UML Diagram

```mermaid
classDiagram
    %% -------------------- Vehicle hierarchy --------------------
    class Vehicle {
        - vehicleNo : String
        + getVehicleNo() : String
        + getType() : String
    }
    class Car {
        + Car(vehicleNo : String)
        + getType() : String
    }
    class Bike {
        + Bike(vehicleNo : String)
        + getType() : String
    }
    class Bus {
        + Bus(vehicleNo : String)
        + getType() : String
    }
    class ElectricCar {
        - wantsCharging : boolean
        + ElectricCar(vehicleNo : String)
        + getType() : String
        + wantsCharging() : boolean
        + setWantsCharging(flag : boolean) : void
    }
    class ElectricVehicle {
        + wantsCharging() : boolean
        + setWantsCharging(flag : boolean) : void
    }

    Vehicle <|-- Car
    Vehicle <|-- Bike
    Vehicle <|-- Bus
    Vehicle <|-- ElectricCar
    ElectricCar ..|> ElectricVehicle

    %% -------------------- Gates --------------------
    class EntryGate {
        - gateId : String
        - lot : ParkingLot
        + generateTicket(vehicle : Vehicle) : Ticket
    }
    class ExitGate {
        - gateId : String
        - lot : ParkingLot
        - pricingStrategy : PricingStrategy
        + processExit(ticketId : String) : double
    }

    %% -------------------- Parking Lot --------------------
    class ParkingLot {
        - spots : List~ParkingSpot~
        - activeTickets : Map~String, Ticket~
        + getAvailableSpots() : List~ParkingSpot~
        + parkVehicle(vehicle : Vehicle) : Ticket
        + exitVehicle(ticketId : String, strategy : PricingStrategy) : double
    }

    class ParkingSpot {
        - spotId : String
        - vehicle : Vehicle
        - electricChargers : boolean
        + isAvailable() : boolean
        + assignVehicle(v : Vehicle) : void
        + removeVehicle() : void
        + getVehicle() : Vehicle
    }

    class Ticket {
        - ticketId : String
        - vehicle : Vehicle
        - entryTime : long
        + getTicketId() : String
        + getVehicle() : Vehicle
        + getEntryTime() : long
    }

    %% -------------------- Pricing --------------------
    class PricingStrategy {
        <<interface>>
        + calculateFee(ticket : Ticket, exitTime : long) : double
    }

    class PerHourPricingStrategy {
        - rates : Map~String, Double~
        - chargingFee : double
        + calculateFee(ticket : Ticket, exitTime : long) : double
    }

    PricingStrategy <|.. PerHourPricingStrategy

    %% -------------------- Relations --------------------
    EntryGate --> ParkingLot
    ExitGate --> ParkingLot
    ExitGate --> PricingStrategy
    ParkingLot --> ParkingSpot
    ParkingLot --> Ticket
    Ticket --> Vehicle
    ParkingSpot --> Vehicle
