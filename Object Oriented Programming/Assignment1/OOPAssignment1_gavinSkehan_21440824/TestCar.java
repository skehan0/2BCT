
/**
 * TestCar calls the car, engine, wheel classes.
 *
 * Gavin Skehan
 * 30/09/22
 */
public class TestCar
{
    public static void main(String[] args) {
    Car car = new Car("AUDI R8");
    Engine engine = new Engine("V8", 43);
    car.add(engine);
    Wheel wheel = new Wheel("Michelin15", 15);
    car.add(wheel);
    car.setFuelVol(100);
    System.out.printf("Current fuel: %.2f\n",car.getFuelVol());
    car.drive();
    car.printState();
    car.setFuelVol(50);
    System.out.printf("Current fuel: %.2f\n",car.getFuelVol());
    car.drive();
    car.printState(); 
    }
}