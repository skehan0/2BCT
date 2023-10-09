
public class Engine
{
    private String name;
    private double turnsPl;
    private double totalNoTurns;

    public Engine(String name, double turnsPl)
    {
        this.name = name;
        this.turnsPl = turnsPl;
    }
    
    public String getName(){
        // engine name
        return name;
    }
    
    public double getTurnsPl(){
        // turns per litre
        return turnsPl;
    }
    
    public double getTotalNoTurns(){
        // engine turns
        return totalNoTurns;
    }
    
    public double totalDistanceTravel(Wheel wheel, double fuelVol){
        // formula to calculate number of turns
        double noTurns = fuelVol * turnsPl;
        totalNoTurns += noTurns;
        return noTurns * wheel.turn();
    }
}
