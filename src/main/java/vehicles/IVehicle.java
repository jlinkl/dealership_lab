package vehicles;

import components.Engine;
import components.EngineType;

public interface IVehicle {
    public int getPrice();

    public EngineType getEngineType();

    public int getDamage();

    public void clearDamage();

}
