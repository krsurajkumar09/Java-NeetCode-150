package ArrayAndHashing;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * ============================================================
 * 📌 PROBLEM: Contains Duplicate
 * ============================================================
 *
 * 🧠 Problem Statement:
 * Given an integer array nums,
 * return true if any value appears at least twice,
 * otherwise return false.
 *
 * ------------------------------------------------------------
 * 🧾 Example:
 * Input:  nums = [1, 2, 3, 3]
 * Output: true
 *
 * Input:  nums = [1, 2, 3, 4]
 * Output: false
 *
 * ------------------------------------------------------------
 * 📊 Constraints:
 * - 1 <= nums.length <= 10^5
 * - -10^9 <= nums[i] <= 10^9
 *
 * ============================================================
 * 🔥 INTERVIEW QUESTIONS (VERY IMPORTANT)
 * ============================================================
 *
 * 1️⃣ What is the most optimal solution?
 *    → Using HashSet → O(n) time
 *
 * 2️⃣ Can we solve without extra space?
 *    → Yes → Sort the array first
 *    → Then check adjacent elements
 *    → Time: O(n log n), Space: O(1)
 *
 * 3️⃣ Why is HashSet efficient?
 *    → O(1) average insertion & lookup
 *
 * 4️⃣ What if memory is constrained?
 *    → Use sorting instead of HashSet
 *
 * 5️⃣ What edge cases should be handled?
 *    → Null array
 *    → Single element array
 *    → Negative numbers
 *
 * 6️⃣ Follow-up:
 *    → Return the duplicate number instead of true/false
 *
 * ============================================================
 * 💡 KEY LEARNING:
 * - HashSet for duplicate detection
 * - Tradeoff: Time vs Space
 * - Pattern: "Seen before?"
 *
 * ============================================================
 */

public class ContainsDuplicate {

    public static void main(String[] args) {

        System.out.println("Welcome to Contains Duplicate Problem");

        int[] nums1 = {1, 2, 3, 3};
        int[] nums2 = {1, 2, 3, 4};

        // ---------------- ARRAY 1 ----------------
        System.out.println("Input Array1:");
        printArray(nums1);

        System.out.println("Brute Force Result Array1:");
        System.out.println(hasDuplicateBrute(nums1));

        System.out.println("Optimized Result Array1:");
        System.out.println(hasDuplicateOptimized(nums1));

        // ---------------- ARRAY 2 ----------------
        System.out.println("Input Array2:");
        printArray(nums2);

        System.out.println("Brute Force Result Array2:");
        System.out.println(hasDuplicateBrute(nums2));

        System.out.println("Optimized Result Array2:");
        System.out.println(hasDuplicateOptimized(nums2));
    }


    // ------------------------------------------------------------
    // 🧠 BRUTE FORCE APPROACH
    // ------------------------------------------------------------
    // Idea:
    // Compare every element with every other element
    //
    // Time Complexity: O(n²) ❌
    // Space Complexity: O(1) ✅
    // ------------------------------------------------------------

    public static boolean hasDuplicateBrute(int[] nums) {

        if (nums == null || nums.length < 2) {
            return false;
        }

        for (int i = 0; i < nums.length; i++) {

            for (int j = i + 1; j < nums.length; j++) {

                if (nums[i] == nums[j]) {
                    return true; // Duplicate found
                }
            }
        }

        return false;
    }


    // ------------------------------------------------------------
    // 🚀 OPTIMIZED APPROACH (HashSet)
    // ------------------------------------------------------------
    // Idea:
    // Use a HashSet to track seen elements
    //
    // Trick:
    // set.add(x) → returns false if x already exists
    //
    // Time Complexity: O(n) ✅
    // Space Complexity: O(n) ❌
    // ------------------------------------------------------------

    public static boolean hasDuplicateOptimized(int[] nums) {

        if (nums == null || nums.length < 2) {
            return false;
        }

        Set<Integer> seen = new HashSet<>();

        for (int num : nums) {

            if (!seen.add(num)) {
                return true; // Duplicate found
            }
        }

        return false;
    }


    // ------------------------------------------------------------
    // 🔁 ALTERNATE APPROACH (Sorting)
    // ------------------------------------------------------------
    // Idea:
    // 1️⃣ Sort array
    // 2️⃣ Compare adjacent elements
    //
    // Time Complexity: O(n log n)
    // Space Complexity: O(1)
    // ------------------------------------------------------------

    public static boolean hasDuplicateSorting(int[] nums) {

        if (nums == null || nums.length < 2) {
            return false;
        }

        Arrays.sort(nums);

        for (int i = 1; i < nums.length; i++) {

            if (nums[i] == nums[i - 1]) {
                return true;
            }
        }

        return false;
    }


    // ------------------------------------------------------------
    // 🛠️ Utility Function
    // ------------------------------------------------------------

    public static void printArray(int[] nums) {
        System.out.println(Arrays.toString(nums));
    }
}