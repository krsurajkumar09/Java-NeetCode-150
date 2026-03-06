package Stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class ValidParentheses {

    public static void main(String[] args) {

        System.out.println("Welcome to Valid Parentheses Problem");

        String s1 = "[]";
        String s2 = "([{}])";
        String s3 = "[(])";

        System.out.println("Brute Force Result s1: " + isValidBrute(s1));
        System.out.println("Optimized Result s1: " + isValidOptimized(s1));

        System.out.println("Brute Force Result s2: " + isValidBrute(s2));
        System.out.println("Optimized Result s2: " + isValidOptimized(s2));

        System.out.println("Brute Force Result s3: " + isValidBrute(s3));
        System.out.println("Optimized Result s3: " + isValidOptimized(s3));

/*
        Expected Output
        Welcome to Valid Parentheses Problem

        Brute Force Result s1: true
        Optimized Result s1: true

        Brute Force Result s2: true
        Optimized Result s2: true

        Brute Force Result s3: false
        Optimized Result s3: false
        */

    }


    // ------------------------------------------------------------
    // BRUTE FORCE APPROACH
    // ------------------------------------------------------------
    // Idea:
    // Repeatedly remove valid bracket pairs
    //
    // Remove:
    // ()
    // []
    // {}
    //
    // Continue removing until the string stops changing.
    //
    // If final string becomes empty → valid
    // Otherwise → invalid
    //
    // Time Complexity: O(n^2)
    // Space Complexity: O(n)
    // ------------------------------------------------------------

    public static boolean isValidBrute(String s) {

        // Safety check
        if (s == null) {
            return false;
        }

        while (true) {

            String updated = s
                    .replace("()", "")
                    .replace("[]", "")
                    .replace("{}", "");

            // If no change occurs stop loop
            if (updated.equals(s)) {
                break;
            }

            s = updated;
        }

        // If string becomes empty → valid
        return s.isEmpty();
    }



    // ------------------------------------------------------------
    // OPTIMIZED APPROACH (STACK)
    // ------------------------------------------------------------
    // Idea:
    //
    // Parentheses follow LIFO (Last In First Out)
    //
    // Example:
    // ([{}])
    //
    // Opening order:
    // ( → [ → {
    //
    // Closing order must be:
    // } → ] → )
    //
    // So we use a stack to store opening brackets.
    //
    // Algorithm:
    //
    // 1. Traverse characters in the string
    //
    // 2. If character is opening bracket
    //    push it into stack
    //
    // 3. If character is closing bracket
    //    check stack top
    //
    //    - If stack empty → invalid
    //    - Pop stack
    //    - Verify correct matching pair
    //
    // 4. At the end stack must be empty
    //
    // Time Complexity: O(n)
    // Space Complexity: O(n)
    // ------------------------------------------------------------

    public static boolean isValidOptimized(String s) {

        // Stack to store opening brackets
        Deque<Character> stack = new ArrayDeque<>();

        // Traverse characters
        for (char ch : s.toCharArray()) {

            // ------------------------------------------------
            // CASE 1 : OPENING BRACKET
            // ------------------------------------------------
            if (ch == '(' || ch == '{' || ch == '[') {

                // Push opening bracket
                stack.push(ch);
            }

            // ------------------------------------------------
            // CASE 2 : CLOSING BRACKET
            // ------------------------------------------------
            else {

                // If stack empty → no matching opening bracket
                if (stack.isEmpty()) {
                    return false;
                }

                // Pop the last opening bracket
                char top = stack.pop();

                // Check matching pairs
                if (ch == ')' && top != '(') return false;
                if (ch == '}' && top != '{') return false;
                if (ch == ']' && top != '[') return false;
            }
        }

        // If stack empty → all brackets matched
        return stack.isEmpty();
    }

}

