package ArrayAndHashing;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public static void main(String[] args) {

        System.out.println("Welcome to Two Sum Problem");

        int[] nums1 = {3, 4, 5, 6};
        int target1 = 7;

        int[] nums2 = {4, 5, 6};
        int target2 = 10;

        System.out.println("Brute Force Result nums1: " + Arrays.toString(twoSumBrute(nums1, target1)));
        System.out.println("Optimized Result nums1: " + Arrays.toString(twoSumOptimized(nums1, target1)));

        System.out.println("Brute Force Result nums2: " + Arrays.toString(twoSumBrute(nums2, target2)));
        System.out.println("Optimized Result nums2: " + Arrays.toString(twoSumOptimized(nums2, target2)));
    }


    // ------------------------------------------------------------
    // BRUTE FORCE APPROACH
    // ------------------------------------------------------------
    // Idea:
    // Check every possible pair of elements
    // If nums[i] + nums[j] == target → return their indices
    //
    // Time Complexity: O(n²)
    // Space Complexity: O(1)
    // ------------------------------------------------------------

    public static int[] twoSumBrute(int[] nums, int target) {

        // Edge case safety
        if (nums == null || nums.length < 2) {
            return new int[0];
        }

        // Compare every pair
        for (int i = 0; i < nums.length; i++) {

            for (int j = i + 1; j < nums.length; j++) {

                // Check if the sum matches the target
                if (nums[i] + nums[j] == target) {

                    return new int[]{i, j};
                }
            }
        }

        return new int[0];
    }



    // ------------------------------------------------------------
    // OPTIMIZED APPROACH (HashMap)
    // ------------------------------------------------------------
    // Idea:
    // Instead of checking all pairs,
    // store numbers we have already seen in a HashMap.
    //
    // For every number:
    // complement = target - current number
    //
    // If complement already exists in the map
    // → we found the answer
    //
    // Time Complexity: O(n)
    // Space Complexity: O(n)
    // ------------------------------------------------------------

    public static int[] twoSumOptimized(int[] nums, int target) {

        // Edge case safety
        if (nums == null || nums.length < 2) {
            return new int[0];
        }

        // HashMap stores:
        // key   → number
        // value → index
        Map<Integer, Integer> map = new HashMap<>();


        // Traverse the array
        for (int i = 0; i < nums.length; i++) {

            int current = nums[i];

            // Find the number needed to reach target
            int complement = target - current;


            // Check if complement already exists
            if (map.containsKey(complement)) {

                int index = map.get(complement);

                // Return smaller index first
                return index < i
                        ? new int[]{index, i}
                        : new int[]{i, index};
            }


            // Store current number and index
            map.put(current, i);
        }

        return new int[0]; // If no pair found
    }

}