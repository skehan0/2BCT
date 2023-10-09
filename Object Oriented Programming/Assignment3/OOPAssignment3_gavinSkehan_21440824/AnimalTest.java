public class AnimalTest
{
    public static void main(String[] args)
    {
        AnimalTest test = new AnimalTest();
        
        test.test1(); // calls test1
        test.test2(); // calls test2
    }
    public void test1(){
        System.out.printf("Q1: Demonstrate toString method\n\n");
        
        // initialise the array of animal objects
        Animal[] animals = new Animal[4];
        animals[0] = new Canary("Bob");
        animals[1] = new Ostrich("Jim");
        animals[2] = new Shark("Jack");
        animals[3] = new Trout("Tim");
        
        for(int i = 0; i < animals.length;i++){ // loops over the elements of the array
            System.out.print(animals[i]);
        }
        for(Animal animal: animals){ // calling the move method
            animal.move(5);
        }
    }
    
    public void test2(){
        System.out.printf("\nQ2. Use an array to demonstrate the output of the different elements\n\n");
        
        // Initalising array of animal objects
        Animal[] animals = new Animal[9];
        animals[0] = new Canary("Joe");
        animals[1] = new Ostrich("James");
        animals[2] = new Shark("Paul");
        animals[3] = new Trout("Sally");
        animals[4] = new Ostrich("James");
        animals[5] = new Shark("Sean");
        animals[6] = new Canary("Joe");
        animals[7] = new Trout("Sally");
        animals[8] = new Shark("Mike");

        for (int i = 0; i < animals.length; i++) { // Runs through all the animal objects to compare them
            int y = i; // allows us to effectively compare animals in position i and y
            for (y = 0; y < animals.length; y++) {
                if (animals[i].equals(animals[y]) && i != y && !(y < i)) { // Compares animal in position i between i + 1 and 9
                    System.out.printf("%s the %s in position %d in the array matched %s the %s in position %d in the array\n\n", animals[i].getName(), animals[i].getClassName(), i, animals[y].getName(), animals[y].getClassName(), y); 
                }
            }
        }
    }
}