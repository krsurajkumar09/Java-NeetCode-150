package ArrayAndHashing;

import java.util.LinkedHashMap;
import java.util.Map;

public class FirstNonRepeatingCharacter {

    public static void main(String[] args) {

        System.out.println("Welcome to First Non-Repeating Character Problem");

        String str1 = "Swiss";
        String str2 = "AABBCC";

        // ---------------- STRING 1 ----------------
        System.out.println("Input String1: " + str1);

        System.out.println("Frequency Array Result String1:");
        printResult(firstNonRepeating(str1));

        System.out.println("LinkedHashMap Result String1:");
        printResult(firstNonRepeatingUsingLinkedHashMap(str1));

        // Expected Output:
        // w


        // ---------------- STRING 2 ----------------
        System.out.println("Input String2: " + str2);

        System.out.println("Frequency Array Result String2:");
        printResult(firstNonRepeating(str2));

        System.out.println("LinkedHashMap Result String2:");
        printResult(firstNonRepeatingUsingLinkedHashMap(str2));

        // Expected Output:
        // No non-repeating character
    }


    // ------------------------------------------------------------
    // APPROACH 1 — FREQUENCY ARRAY
    // ------------------------------------------------------------
    // Idea:
    // 1️⃣ Create frequency array of size 256 (ASCII)
    // 2️⃣ First loop counts occurrences
    // 3️⃣ Second loop finds first character with frequency = 1
    //
    // If characters are case-insensitive, convert them using
    // Character.toLowerCase()
    //
    // Time Complexity: O(n)
    // Space Complexity: O(1)
    // ------------------------------------------------------------

    public static char firstNonRepeating(String s) {

        if (s == null || s.isEmpty()) {
            return '\0';
        }

        int[] freq = new int[256];

        // Counting frequency
        for (int i = 0; i < s.length(); i++) {

            char c = Character.toLowerCase(s.charAt(i)); // remove if case-sensitive
            freq[c]++;
        }

        // Finding first non-repeating character
        for (int i = 0; i < s.length(); i++) {

            char c = Character.toLowerCase(s.charAt(i)); // remove if case-sensitive
            if (freq[c] == 1) {
                return s.charAt(i); // return original character
            }
        }

        return '\0';
    }


    // ------------------------------------------------------------
    // APPROACH 2 — LINKEDHASHMAP
    // ------------------------------------------------------------
    // Idea:
    // 1️⃣ LinkedHashMap maintains insertion order
    // 2️⃣ Store character frequency in map
    // 3️⃣ Traverse again and return first char with freq = 1
    //
    // Time Complexity: O(n)
    // Space Complexity: O(n)
    // ------------------------------------------------------------

    public static char firstNonRepeatingUsingLinkedHashMap(String s) {

        if (s == null || s.length() == 0) {
            return '\0';
        }

        Map<Character, Integer> map = new LinkedHashMap<>();

        // Counting frequency
        for (char c : s.toCharArray()) {

            char lower = Character.toLowerCase(c); // remove if case-sensitive
            map.put(lower, map.getOrDefault(lower, 0) + 1);
        }

        // Finding first non-repeating character
        for (char c : s.toCharArray()) {

            char lower = Character.toLowerCase(c);
            if (map.get(lower) == 1) {
                return c;
            }
        }

        return '\0';
    }


    // ------------------------------------------------------------
    // Utility Function to Print Result
    // ------------------------------------------------------------

    public static void printResult(char result) {

        if (result == '\0') {
            System.out.println("No non-repeating character");
        } else {
            System.out.println(result);
        }
    }
}