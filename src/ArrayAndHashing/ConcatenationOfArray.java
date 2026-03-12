package ArrayAndHashing;

import java.util.Arrays;

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

        // Expected Output:
        // [1,4,1,2,1,4,1,2]


        // ---------------- ARRAY 2 ----------------
        System.out.println("Input Array2:");
        printArray(nums2);

        System.out.println("Brute Force Result Array2:");
        printArray(concatBrute(nums2));

        System.out.println("Optimized Result Array2:");
        printArray(concatOptimized(nums2));

        // Expected Output:
        // [22,21,20,1,22,21,20,1]
    }


    // ------------------------------------------------------------
    // BRUTE FORCE APPROACH
    // ------------------------------------------------------------
    // Idea:
    // 1️⃣ Create new array of size 2n
    // 2️⃣ First loop copies original array
    // 3️⃣ Second loop copies array again
    //
    // Time Complexity: O(n) + O(n) = O(n)
    // Space Complexity: O(2n) ≈ O(n)
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
    // OPTIMIZED APPROACH
    // ------------------------------------------------------------
    // Idea:
    // 1️⃣ Use a single loop
    // 2️⃣ Copy element to two positions
    //
    // ans[i] = nums[i]
    // ans[i+n] = nums[i]
    //
    // Time Complexity: O(n) ✅
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
    // Utility Function to Print Array
    // ------------------------------------------------------------

    public static void printArray(int[] nums) {
        System.out.println(Arrays.toString(nums));
    }
}
