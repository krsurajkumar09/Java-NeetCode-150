package ArrayAndHashing;

import java.util.Arrays;

public class RemoveElement {

    public static void main(String[] args) {

        System.out.println("Welcome to Remove Element Problem");

        int[] nums1 = {1,1,2,3,4};
        int val1 = 1;

        int[] nums2 = {0,1,2,2,3,0,4,2};
        int val2 = 2;


        // ---------------- ARRAY 1 ----------------
        System.out.println("Input Array1:");
        printArray(nums1);
        System.out.println("Value to Remove: " + val1);

        System.out.println("Brute Force Result Array1:");
        printArray(removeElementBrute(nums1, val1));

        System.out.println("Optimized Result Array1 (Two Pointer):");
        printArray(removeElementOptimized(nums1, val1));

        System.out.println("Swap With Last Result Array1:");
        printArray(removeElementSwap(nums1, val1));


        // ---------------- ARRAY 2 ----------------
        System.out.println("\nInput Array2:");
        printArray(nums2);
        System.out.println("Value to Remove: " + val2);

        System.out.println("Brute Force Result Array2:");
        printArray(removeElementBrute(nums2, val2));

        System.out.println("Optimized Result Array2 (Two Pointer):");
        printArray(removeElementOptimized(nums2, val2));

        System.out.println("Swap With Last Result Array2:");
        printArray(removeElementSwap(nums2, val2));
    }


    // ------------------------------------------------------------
    // BRUTE FORCE APPROACH
    // ------------------------------------------------------------
    // Problem:
    // Remove all occurrences of val from nums
    //
    // Idea:
    // 1️⃣ Count valid elements
    // 2️⃣ Create new array
    // 3️⃣ Copy elements != val
    //
    // Time Complexity: O(n)
    // Space Complexity: O(n)
    // ------------------------------------------------------------

    public static int[] removeElementBrute(int[] nums, int val) {

        if (nums == null || nums.length == 0) {
            return new int[0];
        }

        int count = 0;

        for (int num : nums) {
            if (num != val) {
                count++;
            }
        }

        int[] result = new int[count];
        int index = 0;

        for (int num : nums) {
            if (num != val) {
                result[index++] = num;
            }
        }

        return result;
    }


    // ------------------------------------------------------------
    // OPTIMIZED APPROACH (Two Pointer - Stable Order)
    // ------------------------------------------------------------
    // Idea:
    // 1️⃣ Traverse array
    // 2️⃣ Keep valid numbers at index k
    // 3️⃣ Increment k
    //
    // Time Complexity: O(n)
    // Space Complexity: O(1)
    // Order preserved
    // ------------------------------------------------------------

    public static int[] removeElementOptimized(int[] nums, int val) {

        if (nums == null || nums.length == 0) {
            return new int[0];
        }

        int k = 0;

        for (int i = 0; i < nums.length; i++) {

            if (nums[i] != val) {
                nums[k] = nums[i];
                k++;
            }
        }

        return Arrays.copyOf(nums, k);
    }


    // ------------------------------------------------------------
    // OPTIMIZED APPROACH 2 (Swap With Last Element)
    // ------------------------------------------------------------
    // Idea:
    // 1️⃣ If nums[i] == val
    // 2️⃣ Replace with last element
    // 3️⃣ Shrink array size
    //
    // Order NOT preserved
    //
    // Time Complexity: O(n)
    // Space Complexity: O(1)
    //
    // Better when many elements = val
    // ------------------------------------------------------------

    public static int[] removeElementSwap(int[] nums, int val) {

        if (nums == null || nums.length == 0) {
            return new int[0];
        }

        int n = nums.length;
        int i = 0;

        while (i < n) {

            if (nums[i] == val) {

                nums[i] = nums[n - 1]; // swap with last element
                n--;                   // reduce size

            } else {

                i++;
            }
        }

        return Arrays.copyOf(nums, n);
    }


    // ------------------------------------------------------------
    // Utility Function to Print Array
    // ------------------------------------------------------------

    public static void printArray(int[] nums) {
        System.out.println(Arrays.toString(nums));
    }
}