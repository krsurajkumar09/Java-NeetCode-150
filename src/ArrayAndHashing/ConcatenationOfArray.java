package ArrayAndHashing;

import java.util.Arrays;

/**
 * ============================================================
 * 📌 PROBLEM: Concatenation of Array
 * ============================================================
 *
 * 🧠 Problem Statement:
 * Given an integer array nums of length n,
 * return an array ans of length 2n where:
 *
 * ans[i] = nums[i]
 * ans[i + n] = nums[i]
 *
 * ------------------------------------------------------------
 * 🧾 Example:
 * Input:  nums = [1, 2, 3]
 * Output: [1, 2, 3, 1, 2, 3]
 *
 * ------------------------------------------------------------
 * 📊 Constraints:
 * - 1 <= nums.length <= 1000
 * - 1 <= nums[i] <= 1000
 *
 * ============================================================
 * 🔥 INTERVIEW QUESTIONS (VERY IMPORTANT)
 * ============================================================
 *
 * 1️⃣ Can you solve it without using extra space?
 *    → Not possible in Java (fixed size arrays)
 *    → But possible in languages with dynamic arrays (like ArrayList trick)
 *
 * 2️⃣ What is the time complexity?
 *    → O(n)
 *
 * 3️⃣ What is the space complexity?
 *    → O(n) (new array created)
 *
 * 4️⃣ Can we do this in-place?
 *    → No (array size cannot be increased in Java)
 *
 * 5️⃣ What if array is very large?
 *    → Consider streaming or chunk-based copying
 *
 * 6️⃣ What edge cases should we consider?
 *    → Empty array
 *    → Null input
 *    → Single element array
 *
 * ============================================================
 * 💡 KEY LEARNING:
 * - Array copying
 * - Index manipulation
 * - Space-time tradeoff
 * - Pattern: "Duplicate / Extend Array"
 *
 * ============================================================
 */

public class ConcatenationOfArray {

    public static void main(String[] args) {

        System.out.println("Welcome to Concatenation of Array Problem");

        int[] nums1 = {1, 4, 1, 2};
        int[] nums2 = {22, 21, 20, 1};

        // ---------------- ARRAY 1 ----------------
        System.out.println("Input Array1:");
        printArray(nums1);

        System.out.println("Brute Force Result Array1:");
        printArray(concatBrute(nums1));

        System.out.println("Optimized Result Array1:");
        printArray(concatOptimized(nums1));

        // ---------------- ARRAY 2 ----------------
        System.out.println("Input Array2:");
        printArray(nums2);

        System.out.println("Brute Force Result Array2:");
        printArray(concatBrute(nums2));

        System.out.println("Optimized Result Array2:");
        printArray(concatOptimized(nums2));
    }


    // ------------------------------------------------------------
    // 🧠 BRUTE FORCE APPROACH
    // ------------------------------------------------------------
    // Idea:
    // 1️⃣ Create new array of size 2n
    // 2️⃣ Copy array twice using two loops
    //
    // Time Complexity: O(n)
    // Space Complexity: O(n)
    // ------------------------------------------------------------

    public static int[] concatBrute(int[] nums) {

        if (nums == null || nums.length == 0) {
            return new int[0];
        }

        int n = nums.length;
        int[] ans = new int[2 * n];

        // First copy
        for (int i = 0; i < n; i++) {
            ans[i] = nums[i];
        }

        // Second copy
        for (int i = 0; i < n; i++) {
            ans[i + n] = nums[i];
        }

        return ans;
    }


    // ------------------------------------------------------------
    // 🚀 OPTIMIZED APPROACH
    // ------------------------------------------------------------
    // Idea:
    // Use a single loop
    //
    // ans[i] = nums[i]
    // ans[i + n] = nums[i]
    //
    // Time Complexity: O(n)
    // Space Complexity: O(n)
    // ------------------------------------------------------------

    public static int[] concatOptimized(int[] nums) {

        if (nums == null || nums.length == 0) {
            return new int[0];
        }

        int n = nums.length;
        int[] ans = new int[2 * n];

        for (int i = 0; i < n; i++) {
            ans[i] = nums[i];       // first half
            ans[i + n] = nums[i];   // second half
        }

        return ans;
    }


    // ------------------------------------------------------------
    // 🛠️ Utility Function
    // ------------------------------------------------------------

    public static void printArray(int[] nums) {
        System.out.println(Arrays.toString(nums));
    }
}