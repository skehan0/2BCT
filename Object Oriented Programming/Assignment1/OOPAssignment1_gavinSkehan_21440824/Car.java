public class Car
{
    private String carName;
    private double distanceTravel;
    private double totalKilo;
    private double fuelVol;
    private Engine engine;
    private Wheel wheel;
    
    public Car(String carName)
    {
        // initialise instance variables
        this.carName = carName;
    }
    
    public void add(Engine engine){
        // add engine
        this.engine = engine;
    }
    
    public void add(Wheel wheel){
        // add wheel
        this.wheel = wheel;
    }
    
    public void setFuelVol(double fuelVol){
        // set fuel level
        this.fuelVol = fuelVol;
    }
    
    public double getFuelVol(){
        // return fuel level
        return fuelVol;
    }
    
    public void drive() {
        double distanceTravel = engine.totalDistanceTravel(wheel, fuelVol);
        this.distanceTravel = distanceTravel;
        totalKilo += distanceTravel;
        fuelVol = 0;
    }

    public void printState(){
        System.out.printf("Configuration: Car Body %s\n", carName);
        System.out.printf("Engine name: %s\n",engine.getName());
        System.out.printf("Engine turns per litre: %.1f\n", engine.getTurnsPl());
        System.out.printf("Engine's turns  count: %.1f\n", engine.getTotalNoTurns());
        System.out.printf("Wheel name: %s\n", wheel.getName());
        System.out.printf("Wheel radius: %.2f cm\n", wheel.getRad());
        System.out.printf("Wheel circumference (distance per turn): %.2f cm\n",
        wheel.turn());
        System.out.printf("Distance this trip: %.2f\n", distanceTravel);
        System.out.printf("Total distance travelled: %.2f\n", totalKilo);
        System.out.printf("Current fuel status: %.2f liters\n\n", fuelVol);
    }
}
