package vehicles;

import components.Doors;
import components.Engine;
import components.Tyres;

public class HybridCar extends Vehicle implements IVehicle{
    public HybridCar(int price, String colour, Engine engine, Tyres tyres, Doors doors) {
        super(price, colour, engine, tyres, doors);
    }
}
