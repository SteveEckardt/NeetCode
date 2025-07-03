/**
 * Problem: NeetCode - Factory Method Pattern  
 * Author: Steve Eckardt  
 * Revision Date: July 2, 2025  
 *
 * An elementary introduction to abstraction, interfaces, polymorphism, 
 * and the factory method design pattern in object-oriented programming.
 */

interface Vehicle {
    String getType();
}

class Car implements Vehicle {
    @Override
    public String getType() {
        return "Car";
    }
}

class Bike implements Vehicle {
    @Override
    public String getType() {
        return "Bike";
    }
}

class Truck implements Vehicle {
    @Override
    public String getType() {
        return "Truck";
    }
}

abstract class VehicleFactory {
    abstract Vehicle createVehicle();
}

class CarFactory extends VehicleFactory {
    @Override
	Vehicle createVehicle(){
		return new Car();
	}
}

class BikeFactory extends VehicleFactory {
    @Override
	Vehicle createVehicle(){
		return new Bike();
	}
}

class TruckFactory extends VehicleFactory {
    @Override
	Vehicle createVehicle(){
		return new Truck();
	}
}
