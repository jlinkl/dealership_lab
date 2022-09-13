import vehicles.Car;
import vehicles.IVehicle;
import vehicles.Vehicle;

import java.util.ArrayList;

public class Customer {
    private int money;
    private ArrayList<IVehicle> cars;

    public Customer(int money) {
        this.money = money;
        this.cars = new ArrayList<>();
    }

    public int getMoney() {
        return money;
    }

    public ArrayList<IVehicle> getCars() {
        return cars;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public void buyCar(IVehicle car) {
        int cost = car.getPrice() - car.getDamage();
        if (this.money >= cost)  {
            this.money -= cost;
            this.cars.add(car);
        }
    }


}
