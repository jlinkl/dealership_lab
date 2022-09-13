import components.EngineType;
import vehicles.IVehicle;

import java.util.HashMap;

public class Dealership {
    private HashMap<EngineType, Integer> stock;
    private int till;

    public Dealership(int till) {
        this.till = till;
        this.stock = new HashMap<>();
    }

    public int getTill() {
        return till;
    }

    public void setTill(int till) {
        this.till = till;
    }

    public void addToStock(IVehicle car) {
        if (stock.containsKey(car.getEngineType())) {
            stock.put(car.getEngineType(), stock.get(car.getEngineType()) + 1);
        } else {
        stock.put(car.getEngineType(), 1);
        }
    }

    public HashMap<EngineType, Integer> getStock() {
        return stock;
    }

    public void buyVehicle(IVehicle car) {
        if (this.till >= car.getPrice()) {
            addToStock(car);
        }
    }

    public void sellToCustomer(IVehicle car, Customer customer) {
        if (stock.containsKey(car.getEngineType())) {
            customer.buyCar(car);
            this.stock.remove(car.getEngineType(), 1);
            this.till += (car.getPrice() - car.getDamage());
        }
    }

    public void repairCar(IVehicle car) {
        this.till -= car.getDamage();
        car.clearDamage();
    }
}
