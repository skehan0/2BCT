public class Fish extends Animal
{
    boolean hasFins;
    boolean swims;
    boolean hasGills;

    /**
     * Constructor for objects of class Fish
     */
    public Fish()
    {
        super();
        eats = "shrimp";
        colour = "gold";
        hasFins = true;
        swims = true;
        hasGills = true;
    }

    @Override
    public void move(int distance){
        System.out.printf("I swim %d metres \n", distance);
    }
    
    public boolean hasFins(){
        return hasFins;
    }
    
    /**
     * 'getter' method for the hasFeathers field
     */
    public boolean hasGills(){
        return hasGills;
    }
   
    public boolean swims(){
        return swims;
    }
}
