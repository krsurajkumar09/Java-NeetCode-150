package ArrayAndHashing;

import java.util.Arrays;

public class ValidAnagram {
    public static void main(String[] args) {
        System.out.println("Welcome to Solution of Contains Duplicate Problem");

        String s = "racecar", t = "carrace";

        String p = "jar", q = "jam";

        System.out.println("Are String s, String t Anagram :" + isAnagramOptimized(s, t));
        System.out.println("Are String s, String t Anagram :" + isAnagramOptimized(p, q));

    }

    public static boolean isAnagram(String s, String t) {
        if (s == null || t == null) return false;
        if (s.length() != t.length()) return false;

        char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();

        Arrays.sort(sArr);
        Arrays.sort(tArr);

        return Arrays.equals(sArr, tArr);
    }


    public static boolean isAnagramOptimized(String s, String t) {

            // Edge case checks
            if (s == null || t == null) return false;

            // If lengths differ, cannot be anagrams
            if (s.length() != t.length()) return false;

            int[] frequency = new int[26]; // Only lowercase letters

            for (int i = 0; i < s.length(); i++) {
                frequency[s.charAt(i) - 'a']++;
                frequency[t.charAt(i) - 'a']--;
            }

            // Check if all counts are zero
            for (int count : frequency) {
                if (count != 0) return false;
            }

            return true;
    }
}
