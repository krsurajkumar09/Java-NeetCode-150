package ArrayAndHashing;

import java.util.*;

public class GroupAnagram {

    public static void main(String[] args) {
        System.out.println("Welcome to Solution of Contains Duplicate Problem");

        String[] strs = {"act","pots","tops","cat","stop","hat"};
//        Output: [["hat"],["act", "cat"],["stop", "pots", "tops"]]
        String[] strs1 = {"x"};
//        Output: [["x"]]
        String[] strs2 = {""};
//        Output: [[""]]


        String p = "jar", q = "jam";

        System.out.println("Output Anagrams:" + groupAnagrams(strs));
        System.out.println("Output Anagrams:" + groupAnagrams(strs1));
        System.out.println("Output Anagrams:" + groupAnagrams(strs2));

    }

    public static List<List<String>> groupAnagrams(String[] strs) {

        // Edge case check
        if (strs == null || strs.length == 0) {
            return new ArrayList<>();
        }

        Map<String, List<String>> map = new HashMap<>();

        for (String word : strs) {

            // Frequency array for 26 lowercase letters
            int[] count = new int[26];

            for (char c : word.toCharArray()) {
                count[c - 'a']++;
            }

            // Build unique key
            StringBuilder keyBuilder = new StringBuilder();

            for (int num : count) {
                keyBuilder.append("#").append(num);
            }

            String key = keyBuilder.toString();

            // Insert into map
            map.putIfAbsent(key, new ArrayList<>());
            map.get(key).add(word);
        }

        return new ArrayList<>(map.values());
    }
}
