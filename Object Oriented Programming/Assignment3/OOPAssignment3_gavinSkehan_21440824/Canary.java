public class Canary extends Bird
{
    boolean sing;

    /**
     * Constructor for objects of class Canary
     */
    public Canary(String name)
    {
        super(); // call the constructor of the superclass Bird
        this.name = name;
        colour = "yellow"; // this overrides the value inherited from Bird
        sing = true;
    }
    
    /**
     * Sing method overrides the sing method
     * inherited from superclass Bird
     */
    @Override // good programming practice to use @Override to denote overridden methods
    public void sing(){
        System.out.println("tweet tweet tweet");
    }
    
    public boolean canSing(){
        return sing;
    }
    
    /**
     * toString method returns a String representation of the bird
     * What superclass has Canary inherited this method from? 
     */
    @Override
    public String toString(){
        String str ="";
        str+= "Canary; ";
        str+= "name: ";
        str+= name;
        str+= "; ";
        str+= "eats: ";
        str+= eats;
        str+= "; ";
        str+= "colour: ";
        str+= colour;
        str+= "\n";
        str+= "Skin: ";
        str+= hasSkin();
        str+= "; ";
        str+= "Wings: ";
        str+= hasWings;
        str+= "; ";
        str+= "Feathers: ";
        str+= hasFeathers;
        str+= "; ";
        str+= "Flies: ";
        str+= flies();
        str+= "; ";
        str+= "Can sing: ";
        str+= canSing();
        str+= "\n\n";
        // TOD0 Your job is to include the fields and attributes inherited 
        //from Bird and Animal in the String representation
        return str;
    }
    /**
     * equals method defines how equality is defined between 
     * the instances of the Canary class
     * param Object
     * return true or false depending on whether the input object is 
     * equal to this Canary object
     */
    
    @Override
    public boolean equals(Object obj){
        //TODO : You have to define an equals method for this class
        if (obj == null){ 
            System.out.println("Object given is null");  
            return false; //default equals
    }
    
    if(obj instanceof Canary){ // instanceof checks whether an object is an instance of a specific class
        Canary canary = (Canary) obj;
        if(this.getName() == canary.getName() && this.getColour() == canary.getColour()){
            return true;
        }
    }
    
    return false;
    }
}
