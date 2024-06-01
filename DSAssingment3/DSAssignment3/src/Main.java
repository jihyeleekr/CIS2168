import java.util.*;
public class Main {
    public static void main(String[] args) {
        //Create Stack
        Stack<Character>operations = new Stack<Character>();
        //Define infix & postfix
        String infix;
        String postfix;

        // infix = (3*(((2+8)*(4*2))+7))
        infix = "(3*(((2+8)*(4*2))+7))";
        postfix = converter(infix, operations);
        System.out.println(evaluation(postfix));

        // infix = 9*(5+(2+1)*8+3)
        infix = "9*(5+(2+1)*8+3)";
        postfix = converter(infix, operations);
        System.out.println(evaluation(postfix));

        // infix = 9+2*(5-2)
        infix = "9+2*(5-2)";
        postfix = converter(infix, operations);
        System.out.println(evaluation(postfix));
    }
    // Convert infix into postfix
    public static String converter(String s, Stack<Character> operation) {
        String postfix = "";
        for (char c : s.toCharArray()) {
            // If c is a number then add it to postfix
            if (Character.isDigit(c)) {
                postfix += c;
                // If c is '(' add it to stack
            } else if (c == '(') {
                operation.push(c);

            } else if (c == ')') {
                // Add operation elements until the pointer points '('
                while (!operation.isEmpty() && operation.peek() != '(') {
                    postfix += operation.pop();
                }

                if (!operation.isEmpty() && operation.peek() == '(') {
                    operation.pop(); // Pop the '('
                }
            } else {
                // check operation order then add it to the postfix
                while (!operation.isEmpty() && precedence(c) <= precedence(operation.peek())) {
                    postfix += operation.pop();
                }
                operation.push(c);
            }
        }
        // Add rest of the operator in stack to postfix
        while (!operation.isEmpty()) {
            postfix += operation.pop();
        }

        return postfix;
    }

    // Helper method to determine precedence of operators
    public static int precedence(char operator) {
        switch (operator) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
        }
        return 0; // Default precedence for other characters
    }


    // Evaluate postfix
    public static int evaluation(String postfix){
        // Create the stack which will contain calculated values
        Stack<Integer>result = new Stack<Integer>();
        // Check each element in stack
        for(char c: postfix.toCharArray()){
            // Check whether c is a number. If it is then add convert c into int then add it to stack
            if(Character.isDigit(c)){
                result.push(Character.getNumericValue(c));
            }
            //If c is *, then multiply the last element in the stack with the second to the last element than push it into stack
            else if(c == '*'){
                result.push(result.pop() * result.pop());
            }
            //If c is *, then divide the last element in the stack with the second to the last element than push it into stack
            else if(c == '/'){
                // Because the order does matter for division so assign 'a' and 'b' for the last and second to the last elements then do calculation
                // Then push it into stack
                int a = result.pop();
                int b = result.pop();
                result.push(b / a);
            }
            //If c is *, then add the last element in the stack with the second to the last element than push it into stack
            else if(c == '+'){
                result.push(result.pop() + result.pop());
            }
            else if(c == '-'){
                // Because the order does matter for subtraction so assign 'a' and 'b' for the last and second to the last elements then do calculation
                // Then push it into stack
                int a = result.pop();
                int b = result.pop();
                result.push(b - a);
            }
        }
        // return the result of the calculation
        return result.pop();
    }
}