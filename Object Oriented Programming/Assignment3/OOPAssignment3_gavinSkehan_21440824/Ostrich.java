public class Ostrich extends Bird
{
    // instance variables - replace the example below with your own
    boolean isTall;
    boolean hasLongThinLegs;

    /**
     * Constructor for objects of class Ostrich
     */
    public Ostrich(String name)
    {
        super(); // call the constructor of the superclass Bird
        this.name = name;
        eats = "plants";
        colour = "black";
        flies = false;
        isTall = true;
        hasLongThinLegs = true;
    }

    @Override 
    public boolean flies(){
        return flies;
    }
    
    public boolean isTall(){
        return isTall;
    }
    
    public boolean hasLongThinLegs(){
        return hasLongThinLegs;
    }
    
    /**
     * toString method returns a String representation of the bird
     * What superclass has Canary inherited this method from? 
     */
    @Override
    public String toString(){
         String str ="";
        str+= "Ostrich; ";
        str+= "name: ";
        str+= name;
        str+= "; ";
        str+= "eats: ";
        str+= eats;
        str+= "; ";
        str+= "colour: ";
        str+= colour;
        str+= "; ";
        str+= "\n";
        str+= "Skin: ";
        str+= hasSkin();
        str+= "; ";
        str+= "Wings: ";
        str+= hasWings();
        str+= "; ";
        str+= "Feathers: ";
        str+= hasFeathers();
        str+= "; ";
        str+= "Is Tall: ";
        str+= isTall();
        str+= "; ";
        str+= "Has long thin legs: ";
        str+= hasLongThinLegs();
        str+= "; ";
        str+= "Flies: ";
        str+= flies;
        str+= "\n\n";
        // TOD0 Your job is to include the fields and attributes inherited 
        //from Bird and Animal in the String representation
        return str;
    }
    @Override
    public boolean equals(Object obj){
        //TODO : You have to define an equals method for this class
        if(obj == null){
            System.out.println("Object given is null");
            return false;
        }
        if(obj instanceof Ostrich){ // instanceof checks whether an object is an instance of a specific class
            Ostrich ostrich = (Ostrich) obj;
            if(this.getName() == ostrich.getName() && this.getColour() == ostrich.getColour()){
                return true;
            }
        }
        return false; //default equals
    }
}


