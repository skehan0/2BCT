/*
 * Gavin Skehan
 * 21440824
 * Assignment 3
 * 00/10/22
 */
public abstract class Animal
{
    boolean hasSkin;
    boolean breathes;
    String eats;
    String colour;
    String name;
    String className;
    /**
     * Constructor for objects of class Animal
     */
    public Animal()
    {
        breathes = true; //all the subclasses of Animal inherit this property and value
        hasSkin = true; // all the subclasses of Animal inherit this property and value
        colour = "grey"; //all the subclasses of Animal inherit this property and value
        eats = "food"; //all the subclasses of Animal inherit this property and value
        this.name = name; // returns name of animal
        this.className = this.getClass().getSimpleName(); // returns the class name for the given array
    }
    
    /**
     * move method
     * param int distance - the distance the Animal should move
     * All subclasses inherit this method
     */
    public abstract void move(int distance);
    /**
     * getter method for colour field
     * All subclasses inherit this method
     */
    public String getColour(){
        return colour;
    }
    
    public String getName(){
        return name;
    }
    
    public String getClassName(){
        return className;
    }
    
    public String getEats(){
        return eats;
    }
    
     /**
     * 'getter' method for haSkin field
     * All subclasses inherit this method
     */
    public boolean hasSkin(){
        return hasSkin;
    }
}
