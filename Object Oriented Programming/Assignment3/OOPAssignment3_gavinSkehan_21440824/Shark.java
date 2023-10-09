public class Shark extends Fish
{
    boolean canBite;
    boolean isDangerous;

    /**
     * Constructor for objects of class Shark
     */
    public Shark(String name)
    {
        super(); // calls constructor of the superclass fish
        this.name = name;
        eats = "seals";
        colour = "silver";
        canBite = true;
        isDangerous = true;
    }
    
    public boolean hasFins(){
        return hasFins;
    }
    
    public boolean canBite(){
        return canBite;
    }
    
    public boolean isDangerous(){
        return isDangerous;
    }
    
    @Override
    public String toString(){
         String str ="";
        str+= "Shark; ";
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
        str+= "Swim: ";
        str+= swims();
        str+= "; ";
        str+= "Dangerous: ";
        str+= isDangerous();
        str+= "; ";
        str+= "Can bite: ";
        str+= canBite();
        str+= "\n\n";
        // TOD0 Your job is to include the fields and attributes inherited 
        //from Fish and Animal in the String representation
        return str;
    }
    @Override
    public boolean equals(Object obj){
        if (obj == null) {
            System.out.print("Object given is NULL\n");
            return false;
        }
        if(obj instanceof Shark){ // instanceof checks whether an object is an instance of a specific class
            Shark shark = (Shark) obj;
            if (this.getName() == shark.getName() && this.getColour() == shark.getColour()) {
                return true;
            }
        }   
        return false;
    }
}

