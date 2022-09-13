package vehicles;

import components.Doors;
import components.Engine;
import components.Tyres;

public class Car extends Vehicle implements IVehicle {
    public Car(int price, String colour, Engine engine, Tyres tyres, Doors doors) {
        super(price, colour, engine, tyres, doors);
    }
}
