package ArrayAndHashing;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public static void main(String[] args) {
        System.out.println("Welcome to Solution of Contains Duplicate Problem");

        int[] nums1 = {3,4,5,6};
        int target1 = 7;
        int[] nums2 = {4,5,6};
        int target2 = 10;

        String p = "jar", q = "jam";

        System.out.println("Pair of array element whose sum is given target :" + Arrays.toString(twoSum(nums1, target1)));
        System.out.println("Pair of array element whose sum is given target :" + Arrays.toString(twoSum(nums2, target2)));

    }

    public static int[] twoSum(int[] nums, int target) {

    // Edge case safety
    if (nums == null || nums.length < 2) {
        return new int[0];
    }

    Map<Integer, Integer> map = new HashMap<>();

    for (int i = 0; i < nums.length; i++) {

        int complement = target - nums[i];

        // Check if complement already exists
        if (map.containsKey(complement)) {
            int index = map.get(complement);

            // Smaller index first
            return index < i
                    ? new int[]{index, i}
                    : new int[]{i, index};
        }

        // Store current number with index
        map.put(nums[i], i);
    }

    return new int[0]; // Not required by problem
   }

}
