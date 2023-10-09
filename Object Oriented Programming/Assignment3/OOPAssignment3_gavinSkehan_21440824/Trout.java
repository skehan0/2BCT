public class Trout extends Fish
{
    boolean hasSpikes;
    boolean isEdible;
    boolean swimsUpriverToLayEggs;

    /**
     * Constructor for objects of class Trout
     */
    public Trout(String name)
    {
        super(); // calls constructor of the superclass fish
        this.name = name;
        eats = "insects";
        colour = "brown";
        hasSpikes = true;
        isEdible = true;
        swimsUpriverToLayEggs = true;
    }
    
    public boolean hasSpikes(){
        return hasSpikes;
    }
    
    public boolean isEdible(){
        return isEdible;
    }
    
    public boolean swimsUpriverToLayEggs(){
        return swimsUpriverToLayEggs;
    }
    
     @Override
    public String toString(){
       String str ="";
        str+= "Trout; ";
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
        str+= "Gills: ";
        str+= hasGills();
        str+= "; ";
        str+= "Fins: ";
        str+= hasFins();
        str+= "; ";
        str+= "Has spikes: ";
        str+= hasSpikes();
        str+= "; ";
        str+= "Swims upriver to lay eggs: ";
        str+= swimsUpriverToLayEggs();
        str+= "; ";
        str+= "Edible: ";
        str+= isEdible();
        str+= "\n\n";
        // TOD0 Your job is to include the fields and attributes inherited 
        //from Bird and Animal in the String representation
        return str;
    }
    @Override
    public boolean equals(Object obj){
        //TODO : You have to define an equals method for this class
         if (obj == null) {
            return false; // immediately return. Method execution goes no further
        }
         if (obj instanceof Trout) { // instanceof checks whether an object is an instance of a specific class
            // Casting the object and checking all the details are the same as the existing object
            Trout trout = (Trout) obj;
            if (this.getName() == trout.getName() && this.getColour() == trout.getColour()) {
                return true;
            }
        }
        return false; //default equals
    }
}
