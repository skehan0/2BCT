import java.time.Instant;
import java.util.Scanner;

public class SpeedTest {
    public static void main(String [] args) {
        System.out.print("Type the alphabet in order (hit enter between letters)\n");
        System.out.print("Forwards or Backwards (f/b)?");

        /*
         * we use the ASCII table to generate an alphabet by creating an array of characters and
         * then assigning them the corresponding ASCII values.
         * First we initialise array of chars*/
        char alphabet[] = generateAlphabet();
        char in;

        System.out.printf("Type: %s\n", alphabet[0]);

        // time calculator using Instant.now().toEpochMilli() to get the current time in milliseconds
        long startTime = Instant.now().toEpochMilli();

        /* we use this for loop to iterate through the array until we complete it. The program will use orint statements
        to guide the user through the tasks i.e printing the next letter.
        if the user scans the wrong letter i will decrement back to the letter ths user should have input until correct
        * */
        for (int i = 0; i < 26; i++) {
            in = getInput();

            if (in == alphabet[i] && i != 25) {
                System.out.printf("%s: Correct! Now Type: %s\n", alphabet[i], alphabet[i + 1]);
            } else if (in == alphabet[i] && i == 25) {
                System.out.print("Correct! Well Done!\n");
            } else i--; // decrements back to the required letter after incorrect input
        }

        // print out the time in seconds
        long endTime = Instant.now().toEpochMilli();
        double seconds = (endTime - startTime) / 1000.0;
        System.out.println("Time taken: " + seconds + "seconds");
    }

    private static char getInput() {
        // Scanner is used to get the input from the user
        Scanner scan = new Scanner(System.in); // system.in points to the terminal
        String input = scan.nextLine();

        // Character input must be one character otherwise print error
        if (input.length() == 1) {
            return input.toLowerCase().charAt(0);
        }
        else {
            System.out.print("Error, input a single character\n");
            return getInput();
        }
    }

    private static char[] generateAlphabet() {
        char array[] = new char[26], in;
        int i = 0, y = 0;

        // f or b method
        in = getInput();

        /* Checking if input is f or b , then our array generates based on the user input, we use the ASCII table to create
         * and initialise the alphabet array (i.e 97 == A). The array will either begin with A or Z.
         * We call the function if the user doesn't input either f or b until they do */
        if(in == 'f') {
            for(i = 97; i < 123; i++) { // 'a' is ASCII value 97, so we start at 97 and add the value of i to get the next letter of the alphabet
                array[i - 97] = (char)i;
            }
        }
        else if(in == 'b') {
            for(i = 122; i >= 97; i--) {
                array[y] = (char)i;
                y++;
            }
        }
        else {
            return generateAlphabet(); // if there is an invalid input
        }
        return array;
    }
}
