package ArrayAndHashing;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

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

        // Expected Output:
        // true


        // ---------------- ARRAY 2 ----------------
        System.out.println("Input Array2:");
        printArray(nums2);

        System.out.println("Brute Force Result Array2:");
        System.out.println(hasDuplicateBrute(nums2));

        System.out.println("Optimized Result Array2:");
        System.out.println(hasDuplicateOptimized(nums2));

        // Expected Output:
        // false
    }


    // ------------------------------------------------------------
    // BRUTE FORCE APPROACH
    // ------------------------------------------------------------
    // Idea:
    // 1️⃣ Compare every element with every other element
    // 2️⃣ If any two elements are equal → duplicate found
    //
    // Time Complexity: O(n²) ❌
    // Space Complexity: O(1) ✅
    // ------------------------------------------------------------

    public static boolean hasDuplicateBrute(int[] nums) {

        if (nums == null || nums.length < 2) {
            return false; // No duplicate possible
        }

        for (int i = 0; i < nums.length; i++) {

            // Compare with remaining elements
            for (int j = i + 1; j < nums.length; j++) {

                if (nums[i] == nums[j]) {
                    return true; // Duplicate found
                }
            }
        }

        return false; // No duplicates
    }


    // ------------------------------------------------------------
    // OPTIMIZED APPROACH (Using HashSet)
    // ------------------------------------------------------------
    // Idea:
    // 1️⃣ Use a HashSet to track seen elements
    // 2️⃣ If element already exists → duplicate found
    //
    // Important Trick:
    // set.add(value) returns:
    // ✔ true  → if value is NEW
    // ❌ false → if value already exists
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

            // Try adding element to set
            // If already present → add() returns false
            if (!seen.add(num)) {
                return true; // Duplicate found
            }
        }

        return false; // No duplicates
    }


    // ------------------------------------------------------------
    // Utility Function to Print Array
    // ------------------------------------------------------------

    public static void printArray(int[] nums) {
        System.out.println(Arrays.toString(nums));
    }
}