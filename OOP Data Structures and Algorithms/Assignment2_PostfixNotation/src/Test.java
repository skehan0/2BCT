import javax.swing.*;
import java.lang.*;

public class Test {
    // create a new stack
    private static ArrayStack stack = new ArrayStack();

    public static void main(String[] args) {
        char[] in = getInput();
        String postfix = infixToPostfix(in);
        JOptionPane.showMessageDialog(null, "Postfix: " + postfix);
        double answer = postfixEvaluator(postfix);
        JOptionPane.showMessageDialog(null, "Answer: " + answer);
    }

    // return the precedence of the given operators with the higher values
    // having higher precedence
    public static int precedenceLevel(char x){
        // switch statement to determine the precedence levels of the operators
        switch (x){
            case '+':
            case '-':
                return 1;

            case '*':
            case '/':
                return 2;

            case '^':
                return 3;
        }
        return -1;
    }

    // convert infix to postfix
    public static String infixToPostfix(char[] in) {
        StringBuilder output = new StringBuilder();

        // for loop to loop until the end of the array
        for(char x : in){
            // if character is an operand: append (add) to output string
            if(Character.isLetterOrDigit(x)){
                output.append(x);
            }
            // PUSH if scanned operator is > in precedence, empty or contains an opening parenthesis
            else if((precedenceLevel(x) == 2) || stack.isEmpty() || stack.contains( '(' )){
                stack.push(x);
                continue;
            } else { // Pop operators >= in prec and append to output
                while(precedenceLevel(x) >= 1 && !stack.isEmpty() && !stack.contains('(')){
                    output.append(x);
                    stack.pop();
                }
                stack.push(x); // push operator
            }
            if(!stack.isEmpty()){
                if(x == '('){
                    stack.push(x);
                }
                if(x == ')'){
                    stack.pop();
                    while(!stack.contains( '(' )){
                        output.append(x);
                        stack.pop();
                    }
                    stack.pop();
                }
            }
        }

        // Once the whole string has been scanned, pops all operators on the stack to output string
        while (!stack.isEmpty()) {
            if ((char)stack.top() != '(') {
                output.append((char) stack.top());
            }
            stack.pop();
        }
        return output.toString();
    }

    public Test(){

    }

    // utility method, returns value for an operator based on its precedence
public static double postfixEvaluator(String in){
        double output, z, y;

        for(int i = 0; i < in.length(); i++){
            char x = in.charAt(i);
            if(Character.isLetterOrDigit(x)){
                stack.push((double)Character.getNumericValue(x));
            } else if (isOperator(x)) {
                z = (double) stack.top();
                stack.pop();
                y = (double) stack.top();
                stack.pop();

                if (x == '*') stack.push(z*y);
                else if (x == '/') stack.push(y/z);
                else if (x == '+') stack.push(z+y);
                else if (x == '-') stack.push(y-z);
                else stack.push(Math.pow(y, z));
            }
        }
        output = (double) stack.pop();
        return output;
}
// returns true if characters are operators
public static boolean isOperator(char x){
    return x == '+' || x == '-' || x == '*' || x == '/' || x == '^';
}

    public static char[] getInput() {
        // Prompt user for input
        String input = JOptionPane.showInputDialog(null, "Please enter an infix numerical expression between 3 and 20 characters:");
        char[] in = new char[input.length()];
        int openBracketCounter = 0, closeBracketCounter = 0;

        // Validate each character in the input
        for (int i = 0; i < input.length(); i++) {
            char currentChar = input.charAt(i);
            char previousChar = i > 0 ? input.charAt(i-1) : 0;
            char nextChar = i <= input.length() - 2 ? input.charAt(i+1) : 0;

            // Check if input length is within boundaries and if current character is valid
            if ((input.length() <= 20 && input.length() >= 3) && (isValidCharacter(currentChar))) {
                // Keep track of bracket count
                if (currentChar == '(') {
                    openBracketCounter++;
                } else if (currentChar == ')') {
                    closeBracketCounter++;
                }

                // Check first character in the input
                if (i == 0 && isValidFirstCharacter(currentChar, nextChar)) {
                    in[i] = currentChar;
                }

                // Check last character in the input
                else if (i == input.length() - 1 && isValidLastCharacter(currentChar)) {
                    in[i] = currentChar;
                }

                // Check middle characters in the input
                else if (isValidMiddleCharacter(currentChar, previousChar, nextChar) || isOperator(currentChar)) {
                    in[i] = currentChar;
                }

                // If input is invalid, prompt user again
                else {
                    JOptionPane.showMessageDialog(null, "Only the following characters are valid: +, -, *, /, ^, (, ) and numbers 0-9 in single use\n");
                    return getInput();
                }
            } else {
                // If input is invalid, prompt user again
                JOptionPane.showMessageDialog(null, "Only the following characters are valid: +, -, *, /, ^, (, ) and numbers 0-9 in single use\n");
                return getInput();
            }
        }

        // Check if bracket count is balanced
        if ((openBracketCounter + closeBracketCounter) % 2 == 0) {
            return in;
        } else {
            JOptionPane.showMessageDialog(null, "Only the following characters are valid: +, -, *, /, ^, (, ) and numbers 0-9 in single use\n");
            return getInput();
        }


    }
    // these are our method to check for the valid inputs of the characters
    public static boolean isValidCharacter(char currentChar) {
        return Character.isDigit(currentChar) || isOperator(currentChar) || currentChar == '(' || currentChar == ')';
    }

    public static boolean isValidFirstCharacter(char currentChar, char nextChar) {
        return Character.isDigit(currentChar) || (currentChar == '(' && (Character.isDigit(nextChar) || nextChar == '('));
    }

    public static boolean isValidLastCharacter(char currentChar) {
        return Character.isDigit(currentChar) || currentChar == ')';
    }

    public static boolean isValidMiddleCharacter(char currentChar, char previousChar, char nextChar) {
        return Character.isDigit(currentChar) || (currentChar == ')' && (Character.isDigit(previousChar) || previousChar == ')')) || (currentChar == '(' && (Character.isDigit(nextChar) || nextChar == '('));
    }

}