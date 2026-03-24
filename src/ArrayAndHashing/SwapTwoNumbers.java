package ArrayAndHashing;

import java.util.Arrays;

/**
 * ============================================================
 * 📌 PROBLEM: Swap Two Numbers Without Third Variable
 * ============================================================
 *
 * 🧠 Problem Statement:
 * Given two integers a and b,
 * swap their values WITHOUT using a third variable
 * and return the swapped values.
 *
 * ------------------------------------------------------------
 * 🧾 Example:
 * Input:  a = 5, b = 10
 * Output: [10, 5]
 *
 * ------------------------------------------------------------
 * 📊 Constraints:
 * - Integer values (can be positive, negative, or zero)
 * - No extra variable allowed for swapping
 *
 * ============================================================
 * 🔥 INTERVIEW QUESTIONS (VERY IMPORTANT)
 * ============================================================
 *
 * 1️⃣ Can you swap without using extra space?
 *    → Yes, using XOR or arithmetic
 *
 * 2️⃣ Why is XOR preferred?
 *    → No overflow risk
 *
 * 3️⃣ What is time complexity?
 *    → O(1)
 *
 * 4️⃣ What is space complexity?
 *    → O(1) (excluding return array)
 *
 * 5️⃣ Can integer overflow happen?
 *    → Yes (in addition/subtraction method)
 *
 * 6️⃣ How to return multiple values in Java?
 *    → Use array or custom object
 *
 * ============================================================
 * 💡 KEY LEARNING:
 * - Bit Manipulation (XOR)
 * - In-place operations
 * - Handling multiple return values in Java
 * - Space optimization
 *
 * ============================================================
 */

public class SwapTwoNumbers {

    public static void main(String[] args) {

        System.out.println("Welcome to Swap Two Numbers Problem");

        int a1 = 5, b1 = 10;
        int a2 = -3, b2 = 7;

        // ---------------- CASE 1 ----------------
        System.out.println("Input: a = " + a1 + ", b = " + b1);

        System.out.println("Brute Force (Using Temp):");
        printArray(swapBrute(a1, b1));

        System.out.println("Optimized (Using XOR):");
        printArray(swapOptimized(a1, b1));

        // ---------------- CASE 2 ----------------
        System.out.println("Input: a = " + a2 + ", b = " + b2);

        System.out.println("Brute Force (Using Temp):");
        printArray(swapBrute(a2, b2));

        System.out.println("Optimized (Using XOR):");
        printArray(swapOptimized(a2, b2));
    }


    // ------------------------------------------------------------
    // 🧠 BRUTE FORCE APPROACH
    // ------------------------------------------------------------
    // Idea:
    // Use a third variable (temp)
    //
    // Time Complexity: O(1)
    // Space Complexity: O(1)
    // ------------------------------------------------------------

    public static int[] swapBrute(int a, int b) {

        int temp = a;
        a = b;
        b = temp;

        return new int[]{a, b};
    }


    // ------------------------------------------------------------
    // 🚀 OPTIMIZED APPROACH (XOR)
    // ------------------------------------------------------------
    // Idea:
    // a = a ^ b
    // b = a ^ b  → original a
    // a = a ^ b  → original b
    //
    // Time Complexity: O(1)
    // Space Complexity: O(1)
    // ------------------------------------------------------------

    public static int[] swapOptimized(int a, int b) {

        // Edge case: if both are same, XOR will still work but safe check
        if (a == b) {
            return new int[]{a, b};
        }

        a = a ^ b;
        b = a ^ b;
        a = a ^ b;

        return new int[]{a, b};
    }


    // ------------------------------------------------------------
    // 🛠️ Utility Function
    // ------------------------------------------------------------

    public static void printArray(int[] nums) {
        System.out.println(Arrays.toString(nums));
    }
}