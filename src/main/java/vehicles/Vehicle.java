package vehicles;

import components.Doors;
import components.Engine;
import components.EngineType;
import components.Tyres;

public abstract class Vehicle {
    protected int price;
    protected String colour;
    protected Engine engine;
    protected Tyres tyres;
    protected Doors doors;
    protected int damage;

    public Vehicle(int price, String colour, Engine engine, Tyres tyres, Doors doors) {
        this.price = price;
        this.colour = colour;
        this.engine = engine;
        this.tyres = tyres;
        this.doors = doors;
        this.damage = 0;
    }

    public int getPrice() {
        return price;
    }

    public String getColour() {
        return colour;
    }

    public Engine getEngine() {
        return engine;
    }

    public Tyres getTyres() {
        return tyres;
    }

    public Doors getDoors() {
        return doors;
    }

    public int getDamage() {
        return damage;
    }

    public void addDamage(int damage) {
        this.damage += damage;
    }

    public EngineType getEngineType() {
        return this.engine.getEngineType();
    }

    public void clearDamage() {
        this.damage = 0;
    }
}
