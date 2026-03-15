package ArrayAndHashing;

import java.util.Arrays;

public class SortArray {

    public static void main(String[] args) {

        System.out.println("Welcome to Sort Array Problem");

        int[] nums1 = {10, 9, 1, 1, 1, 2, 3, 1};
        int[] nums2 = {5, 10, 2, 1, 3};

        // ---------------- ARRAY 1 ----------------
        System.out.println("Input Array1:");
        printArray(nums1);

        System.out.println("Brute Force Result Array1:");
        printArray(sortArrayBrute(nums1.clone()));

        System.out.println("Optimized Result Array1:");
        printArray(sortArrayOptimized(nums1.clone()));

        // Expected Output:
        // [1,1,1,1,2,3,9,10]


        // ---------------- ARRAY 2 ----------------
        System.out.println("Input Array2:");
        printArray(nums2);

        System.out.println("Brute Force Result Array2:");
        printArray(sortArrayBrute(nums2.clone()));

        System.out.println("Optimized Result Array2:");
        printArray(sortArrayOptimized(nums2.clone()));

        // Expected Output:
        // [1,2,3,5,10]
    }


    // ------------------------------------------------------------
    // BRUTE FORCE APPROACH (Bubble Sort)
    // ------------------------------------------------------------
    // Idea:
    // 1️⃣ Compare adjacent elements
    // 2️⃣ Swap if left element is greater
    // 3️⃣ Repeat until array becomes sorted
    //
    // Time Complexity: O(n²) ❌
    // Space Complexity: O(1) ✅
    // ------------------------------------------------------------

    public static int[] sortArrayBrute(int[] nums) {

        if (nums == null || nums.length <= 1) {
            return nums;
        }

        int n = nums.length;

        for (int i = 0; i < n - 1; i++) {

            for (int j = 0; j < n - i - 1; j++) {

                if (nums[j] > nums[j + 1]) {

                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
            }
        }

        return nums;
    }


    // ------------------------------------------------------------
    // OPTIMIZED APPROACH (Merge Sort)
    // ------------------------------------------------------------
    // Idea:
    // 1️⃣ Divide the array into two halves
    // 2️⃣ Recursively sort each half
    // 3️⃣ Merge the sorted halves
    //
    // Time Complexity: O(n log n) ✅
    // Space Complexity: O(n)
    // ------------------------------------------------------------

    public static int[] sortArrayOptimized(int[] nums) {

        if (nums == null || nums.length <= 1) {
            return nums;
        }

        mergeSort(nums, 0, nums.length - 1);

        return nums;
    }


    private static void mergeSort(int[] nums, int left, int right) {

        if (left >= right) {
            return;
        }

        int mid = left + (right - left) / 2;

        mergeSort(nums, left, mid);
        mergeSort(nums, mid + 1, right);

        merge(nums, left, mid, right);
    }


    private static void merge(int[] nums, int left, int mid, int right) {

        int n1 = mid - left + 1;
        int n2 = right - mid;

        int[] leftArr = new int[n1];
        int[] rightArr = new int[n2];

        for (int i = 0; i < n1; i++) {
            leftArr[i] = nums[left + i];
        }

        for (int j = 0; j < n2; j++) {
            rightArr[j] = nums[mid + 1 + j];
        }

        int i = 0, j = 0, k = left;

        while (i < n1 && j < n2) {

            if (leftArr[i] <= rightArr[j]) {
                nums[k++] = leftArr[i++];
            } else {
                nums[k++] = rightArr[j++];
            }
        }

        while (i < n1) {
            nums[k++] = leftArr[i++];
        }

        while (j < n2) {
            nums[k++] = rightArr[j++];
        }
    }


    // ------------------------------------------------------------
    // Utility Function to Print Array
    // ------------------------------------------------------------

    public static void printArray(int[] nums) {
        System.out.println(Arrays.toString(nums));
    }
}