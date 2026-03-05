package BinarySearch;

import java.util.Arrays;

public class SearchInRotatedSortedArray {

    public static void main(String[] args) {

        System.out.println("Welcome to Search in Rotated Sorted Array Problem");

        int[] nums1 = {3, 4, 5, 6, 1, 2};
        int target1 = 1;

        int[] nums2 = {3, 5, 6, 0, 1, 2};
        int target2 = 4;

        System.out.println("Brute Force Result nums1: " + searchBrute(nums1, target1));
        System.out.println("Optimized Result nums1: " + searchOptimized(nums1, target1));

        System.out.println("Brute Force Result nums2: " + searchBrute(nums2, target2));
        System.out.println("Optimized Result nums2: " + searchOptimized(nums2, target2));
    }


    // ------------------------------------------------------------
    // BRUTE FORCE APPROACH
    // ------------------------------------------------------------
    // Idea:
    // Traverse the entire array and check each element
    // If the element equals target → return the index
    //
    // Time Complexity: O(n)
    // Space Complexity: O(1)
    // ------------------------------------------------------------

    public static int searchBrute(int[] nums, int target) {

        // Edge case safety
        if (nums == null || nums.length == 0) {
            return -1;
        }

        // Traverse the entire array
        for (int i = 0; i < nums.length; i++) {

            // If target found return index
            if (nums[i] == target) {
                return i;
            }
        }

        // Target not found
        return -1;
    }



    // ------------------------------------------------------------
    // OPTIMIZED APPROACH (Binary Search)
    // ------------------------------------------------------------
    // Idea:
    // The array is rotated but one half is always sorted.
    //
    // Example:
    // [3,4,5,6,1,2]
    //
    // At any step:
    // left ---- mid ---- right
    //
    // Either:
    // Left half is sorted
    // OR
    // Right half is sorted
    //
    // We check where the target lies and discard the other half.
    //
    // Time Complexity: O(log n)
    // Space Complexity: O(1)
    // ------------------------------------------------------------

    public static int searchOptimized(int[] nums, int target) {

        // Edge case safety
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int left = 0;
        int right = nums.length - 1;

        // Binary search loop
        while (left <= right) {

            // Calculate mid safely
            int mid = left + (right - left) / 2;

            // If target found return index
            if (nums[mid] == target) {
                return mid;
            }

            // ------------------------------------------------
            // CASE 1 : LEFT HALF IS SORTED
            // ------------------------------------------------
            if (nums[left] <= nums[mid]) {

                // Check if target lies inside left sorted portion
                if (nums[left] <= target && target < nums[mid]) {

                    // Move search space to left half
                    right = mid - 1;

                } else {

                    // Otherwise search right half
                    left = mid + 1;
                }
            }

            // ------------------------------------------------
            // CASE 2 : RIGHT HALF IS SORTED
            // ------------------------------------------------
            else {

                // Check if target lies inside right sorted portion
                if (nums[mid] < target && target <= nums[right]) {

                    // Move search space to right half
                    left = mid + 1;

                } else {

                    // Otherwise search left half
                    right = mid - 1;
                }
            }
        }

        // Target not found
        return -1;
    }

}