package ArrayAndHashing;

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {
    public static void main(String[] args) {
        System.out.println("Welcome to Solution of Contains Duplicate Problem");

        int[] nums1 = {1, 2, 3, 3};
        int[] nums2 = {1, 2, 3, 4};

        System.out.println("Does num1 contains duplicate :" + hasDuplicateOptimized(nums1));
        System.out.println("Does num2 contains duplicate :" + hasDuplicateOptimized(nums2));

    }

    public boolean hasDuplicate(int[] nums) {
        if (nums == null) return false;

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean hasDuplicateOptimized(int[] nums) {

        // No possibility of duplicate
        if (nums == null || nums.length < 2) {
            return false;
        }

        Set<Integer> seen = new HashSet<>();

        for (int num : nums) {
            if (!seen.add(num)) {   // add() returns false if already exists
                return true;
            }
        }
        return false;
    }
}
