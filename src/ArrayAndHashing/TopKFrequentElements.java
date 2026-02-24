package ArrayAndHashing;

import java.util.*;

public class TopKFrequentElements {

    public static void main(String[] args) {
        System.out.println("Welcome to Solution of Top K Frequent Elements Problem");

        int[] nums1 = {1,2,2,3,3,3};
        int k = 2;

//      Output: [2,3]

        int[] nums2 = {7,7};
        int k1 = 1;

//      Output: [7]

        System.out.println("Output is :" + Arrays.toString(topKFrequentOptimized(nums1, k)));
        System.out.println("Output is :" + Arrays.toString(topKFrequentOptimized(nums2, k1)));

    }

    public static int[] topKFrequent(int[] nums, int k) {

        if (nums == null || nums.length == 0)
            return new int[0];

        Map<Integer, Integer> freqMap = new HashMap<>();

        for (int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        List<Map.Entry<Integer, Integer>> list =
                new ArrayList<>(freqMap.entrySet());

        list.sort((a, b) -> b.getValue() - a.getValue());

        int[] result = new int[k];

        for (int i = 0; i < k; i++) {
            result[i] = list.get(i).getKey();
        }

        return result;
    }


    public static int[] topKFrequentOptimized(int[] nums, int k) {

        if (nums == null || nums.length == 0)
            return new int[0];

        // Step 1: Frequency Map
        Map<Integer, Integer> freqMap = new HashMap<>();

        for (int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        // Step 2: Bucket Array
        List<Integer>[] bucket = new List[nums.length + 1];

        for (int key : freqMap.keySet()) {
            int freq = freqMap.get(key);

            if (bucket[freq] == null) {
                bucket[freq] = new ArrayList<>();
            }

            bucket[freq].add(key);
        }

        // Step 3: Traverse bucket from high to low
        int[] result = new int[k];
        int index = 0;

        for (int i = bucket.length - 1; i >= 0 && index < k; i--) {

            if (bucket[i] != null) {

                for (int num : bucket[i]) {
                    result[index++] = num;
                    if (index == k)
                        break;
                }
            }
        }

        return result;
    }
}
