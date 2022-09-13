import components.Doors;
import components.Engine;
import components.EngineType;
import components.Tyres;
import org.junit.Before;
import org.junit.Test;
import vehicles.Car;
import vehicles.ElectricCar;
import vehicles.HybridCar;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class Mvp {
    
    Car car;
    ElectricCar eCar;
    HybridCar hCar;
    Doors doors;
    Engine gEngine;
    Engine eEngine;
    Engine hEngine;
    Tyres tyres;
    Customer customer;
    Dealership dealership;
    
    @Before
    public void before() {
        tyres = new Tyres(4);
        gEngine = new Engine(EngineType.GAS);
        eEngine = new Engine(EngineType.ELECTRIC);
        hEngine = new Engine(EngineType.HYBRID);
        doors = new Doors(5);
        customer = new Customer(500);
        dealership = new Dealership(1000);
        car = new Car(100, "red", gEngine, tyres, doors);
        eCar = new ElectricCar(200, "blue", eEngine, tyres, doors);
        hCar = new HybridCar(150, "green", hEngine, tyres, doors);
    }

    @Test
    public void hasComponents() {
        assertEquals(4, tyres.getTyres());
        assertEquals(5, doors.getDoors());
        assertEquals(500, customer.getMoney());
        assertEquals(gEngine, car.getEngine());
        assertEquals(200, eCar.getPrice());
        assertEquals(1000, dealership.getTill());
    }

    @Test
    public void canBuyCar() {
        customer.buyCar(car);
        assertEquals(1, customer.getCars().size());
    }

    @Test
    public void canAddToStock() {
        dealership.addToStock(car);
        assertEquals(1, dealership.getStock().size());
    }

    @Test
    public void dealershipCanBuyCar(){
        dealership.buyVehicle(car);
        assertEquals(1, dealership.getStock().size());
    }

    @Test
    public void dealershipCanSellToCustomer() {
        dealership.addToStock(car);
        dealership.sellToCustomer(car, customer);
        assertEquals(1100, dealership.getTill());
    }

    @Test
    public void carCanAddDamage() {
        car.addDamage(10);
        assertEquals(10, car.getDamage());
    }

    @Test
    public void sellDamagedCar() {
        car.addDamage(10);
        dealership.addToStock(car);
        dealership.sellToCustomer(car, customer);
        assertEquals(1090, dealership.getTill());
    }

    @Test
    public void canFixCar() {
        car.addDamage(10);
        dealership.repairCar(car);
        assertEquals(0, car.getDamage());
        assertEquals(990, dealership.getTill());
    }

    @Test
    public void canHoldMoreThan1OfTheSameCar() {
        dealership.addToStock(car);
        dealership.addToStock(car);
        int stock = dealership.getStock().get(car.getEngineType());
        assertEquals(2, stock);
    }





}
