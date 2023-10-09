import java.util.*;
import java.util.Queue;
import java.util.Stack;

public abstract class Palindrome {
    static int countM1 = 0, countM2 = 0, countM3 = 0, countM4 = 0; // primitive operations counters
    static long startTimeM1, endTimeM1, startTimeM2, endTimeM2, startTimeM3, endTimeM3, startTimeM4, endTimeM4; // timer
    // Array lists to store Palindromes
    static List<Integer> M1List = new ArrayList<>();
    static List<Integer> M2List = new ArrayList<>();
    static List<Integer> M3List = new ArrayList<>();
    static List<Integer> M4List = new ArrayList<>();

    //Main Method
    public static void main(String[] args) {
        testMethods();
    }
    static void testMethods() {
        startTimeM1 = System.currentTimeMillis(); // start time
        countM1++; // increment primitive operations
        System.out.print("Method1\nInterval\tNumber of operations\n");
        for (int i = 0; i <= 1000000; i++) {
            countM1 += 2; // init i && i < num check
            countM1 += 5;
            if (reversePalindrome(String.valueOf(i)) && reversePalindrome(decimal2Binary(String.valueOf(i)))) { // finds matching binary and decimal palindromes
                M1List.add(i); // adding to array
                countM1++;
            }
            if (i % 50000 == 0) { // interval for the graph
                System.out.printf("\t%d\t\t %d\n", i, countM1);
            }
            countM1++;
        }
        endTimeM1 = System.currentTimeMillis() - startTimeM1;
        System.out.printf("Time taken: %d ms \n", endTimeM1);
        System.out.printf("Number of matching decimal and binary numbers: %d\n", M1List.size());
        System.out.printf("----------------------------------------------------------------\n");


        startTimeM2 = System.currentTimeMillis();
        countM2++;
        System.out.print("Method2\nInterval\tNumber of operations\n");
        for (int i = 0; i <= 1000000; i++) {
            countM2 += 2; // init i && i < num check
            countM2 += 5;
            if (comparePalindrome(String.valueOf(i)) && reversePalindrome(decimal2Binary(String.valueOf(i)))) {
                M2List.add(i); // adding to array
                countM2++;
            }
            if (i % 50000 == 0) { // interval for the graph
                System.out.printf("\t%d\t\t %d\n", i, countM2);
            }
            countM2++;
        }

        endTimeM2 = System.currentTimeMillis() - startTimeM2;
        System.out.printf("Time taken: %d ms \n", endTimeM2);
        System.out.printf("Number of matching decimal and binary numbers: %d\n", M2List.size());
        System.out.printf("----------------------------------------------------------------\n");


        startTimeM3 = System.currentTimeMillis();
        countM3++;
        System.out.printf("Method3\nInterval\tNumber of operations\n");
        for (int i = 0; i <= 1000000; i++) {
            countM3 += 2; // init i && i < num check
            countM3 += 5;
            if (stackAndQueue(String.valueOf(i)) && stackAndQueue(decimal2Binary(String.valueOf(i)))) {
                M3List.add(i);
                countM3++;
            }
                if (i % 50000 == 0) { // interval for the graph
                    System.out.printf("\t%d\t\t %d\n", i, countM3);
                }
                countM3++; // increment i

        }
        endTimeM3 = System.currentTimeMillis() - startTimeM3;
        System.out.printf("Time Taken: %d ms\n", endTimeM3);
        System.out.printf("Number of matching decimal and binary numbers: %d\n", M3List.size());
        System.out.printf("----------------------------------------------------------------\n");


        startTimeM4 = System.currentTimeMillis();
        countM4++;
        System.out.print("Method4\nInterval\tNumber of operations\n");
        for (int i = 0; i <= 1000000; i++) {
           countM4 += 2; // init i && i < num check
           countM4 += 5;
            if (recursivePalindrome(String.valueOf(i)) && recursivePalindrome(decimal2Binary(String.valueOf(i)))) { // find matching binary and decimal palindromes
                M4List.add(i);
                countM4++;
            }
            if (i % 50000 == 0) { // interval for the graph
                System.out.printf("\t%d\t\t %d\n", i, countM4);
            }
            countM4++; // increment i
        }
        endTimeM4 = System.currentTimeMillis() - startTimeM4;
        System.out.printf("Time Taken: %d ms\n", endTimeM4);
        System.out.printf("Number of matching decimal and binary numbers: %d\n", M4List.size());
        System.out.printf("----------------------------------------------------------------\n");
    }

    //Static method for: Palindrome Method 1 (give it a name based on how it works)
    //Takes a String as a parameter and return a boolean value
    public static Boolean reversePalindrome(String str) {
        String rev = ""; // initialise empty String to store reversed string
        countM1++;

        boolean answer = false;
        countM1++;

        // reverse through the string
        for (int i = str.length() - 1; i >= 0; i--) { // decrement through the string
            countM1 += 5;
            rev = rev + str.charAt(i); // add char to the reverse string
            countM1++;
        }

        if (str.equals(rev)) { // compare reversed string to the original string
            answer = true;
            countM1 += 2;
        }
        countM1++;
        return answer;
    }


    //Static method for: Palindrome Method 2 (give it a name based on how it works)
    //Takes a String as a parameter and return a boolean value
    public static boolean comparePalindrome(String str) {

        int left = 0; // start of the string
        int right = str.length() - 1; // end of the string
        countM2 += 3;

        while (left < right) { // when they meet in the middle or there are no more characters to match
            if (str.charAt(left) != str.charAt(right)) { // compare element by element
                countM2 += 5;
                return false;                                                                                                                                                                                                  
            }
            left++; // increment through the string
            right--; // decrement through the string
            countM2 += 2;
        }
        countM2++;
        return true;
    }


    //Static method for: Palindrome Method 3 (give it a name based on how it works)
    //Takes a String as a parameter and return a boolean value
    public static boolean stackAndQueue(String str) {
        Stack<Character> stack = new Stack<Character>(); // initialise stack
        Queue<Character> queue = new ArrayDeque<Character>(); // initialise queue
        countM3 += 2;

        for (int i = 0; i < str.length(); i++) { // loop through string
            countM3 += 3;
            char x = str.charAt(i);
            stack.push(x); // push the string to the stack
            queue.offer(x); // adds element to the end of the queue
            countM3 += 3;
        }

        while (!stack.isEmpty() && !queue.isEmpty()) { // while stack and queue arent empty
            countM3 += 2;
            char x1 = stack.pop(); // pops element at the top of the stack
            char x2 = queue.poll(); // removes last element from the queue
            countM3 +=2;
            if (x1 != x2) { // compare element popped from stack and removed from queue
                countM3 += 2;
                return false; // mismatch
            }
        }
        countM3++;
        return true;
    }

    //Static method for: Palindrome Method 4 (give it a name based on how it works)
    //Takes a String as a parameter and return a boolean value
    public static boolean recursivePalindrome(String str){
        countM4 += 3;
        String reversed = reverse(str); // call reverse recursion
        return str.equals(reversed); // compare strings
    }

    //Static method for: Recursively reversing a String (to be used by Method 4)
    //Takes a String and returns a String value of it reversed (must use recursion)
    public static String reverse(String str) {
        countM4++; // if statement
        if (str.isEmpty()) {
            countM4++;
            return str;
        }
        countM4 += 5; // return,reverse,substring, +, charAt
        return reverse(str.substring(1)) + str.charAt(0);
    }

    //Static method for: Converting a decimal number into its equivalent binary representation
    //Takes a String representation of a number as a parameter and return a String value
    public static String decimal2Binary(String input){
        Stack<Integer> s = new Stack<>(); // create a stack to hold the binary digits
        int in = Integer.parseInt(input); // converts the input to an integer
        StringBuilder output = new StringBuilder(); // create a StringBuilder object to hold the output binary digits

        // convert the input integer to binary by continuously
        // dividing it by 2 and pushing the remainder onto the stack
        if(!input.equals("0")){
            while(in != 0){
                s.push(in % 2);
                in /= 2;
            }
            // pop each binary digit off the stack and add it to the output StringBuilder
            while (!s.isEmpty()){
                output.append(s.peek());
                s.pop();
            }
        }else {
            output.append(input);  // if the input is 0, add "0" to the output StringBuilder
        }
        return output.toString(); // return binary number as a string
    }
}
