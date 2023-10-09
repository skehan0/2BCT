public class Wheel
{
    private String name;
    private double rad;
    private double circ;
    
    public Wheel(String name, double rad)
    {
        this.name = name;
        this.rad = rad;
        circ = (2 * Math.PI) * rad;
    }
    
    public double turn(){
        // cicumference of wheel
        return circ;
    }
    
    public double getRad(){
        // radius of wheel
        return rad;
    }
    
    public String getName(){
        // name of engine
        return name;
    }
}
