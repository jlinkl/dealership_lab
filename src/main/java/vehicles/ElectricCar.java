package vehicles;

import components.Doors;
import components.Engine;
import components.Tyres;

public class ElectricCar extends Vehicle implements IVehicle{
    public ElectricCar(int price, String colour, Engine engine, Tyres tyres, Doors doors) {
        super(price, colour, engine, tyres, doors);
    }
}
