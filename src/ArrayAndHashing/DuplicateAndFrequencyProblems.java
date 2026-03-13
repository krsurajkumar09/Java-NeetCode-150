package ArrayAndHashing;

import java.util.*;

public class DuplicateAndFrequencyProblems {

    public static void main(String[] args) {

        List<String> list = Arrays.asList("apple", "banana", "orange", "apple", "banana");

        System.out.println("Duplicates: " + findDuplicates(list));

        System.out.println("First Duplicate: " + findFirstDuplicate(list));

        System.out.println("Duplicates without extra space:");
        findDuplicatesWithoutExtraSpace(new ArrayList<>(list));

        System.out.println("\nCharacter Frequency:");
        countCharacterFrequency("programming");

        System.out.println("\nDigit Frequency:");
        countDigitFrequency(1122334455);
    }

    /*
    Problem:
    Find all duplicate strings in a list.

    Example:
    Input  : [apple, banana, orange, apple, banana]
    Output : [apple, banana]
    */

    public static Set<String> findDuplicates(List<String> list) {

        Set<String> seen = new HashSet<>();
        Set<String> duplicates = new HashSet<>();

        for (String str : list) {

            if (!seen.add(str)) {
                duplicates.add(str);
            }

        }

        return duplicates;
    }

    /*
    Problem:
    Find the first duplicate string in a list.

    Example:
    Input  : [apple, banana, orange, apple, banana]
    Output : apple
    */

    public static String findFirstDuplicate(List<String> list) {

        Set<String> seen = new HashSet<>();

        for (String str : list) {

            if (!seen.add(str)) {
                return str;
            }

        }

        return null;
    }

    /*
    Problem:
    Find duplicate strings WITHOUT using extra space.

    Approach:
    Sort the list and compare adjacent elements.

    Example:
    Input  : [apple, banana, orange, apple, banana]
    Sorted : [apple, apple, banana, banana, orange]
    Output : apple banana
    */

    public static void findDuplicatesWithoutExtraSpace(List<String> list) {

        Collections.sort(list);

        for (int i = 1; i < list.size(); i++) {

            if (list.get(i).equals(list.get(i - 1))) {
                System.out.println(list.get(i));
            }

        }
    }

    /*
    Problem:
    Count occurrences of characters in a string.

    Example:
    Input  : "programming"
    Output :
    p -> 1
    r -> 2
    o -> 1
    g -> 2
    a -> 1
    m -> 2
    i -> 1
    n -> 1
    */

    public static void countCharacterFrequency(String str) {

        Map<Character, Integer> map = new HashMap<>();

        for (char c : str.toCharArray()) {

            map.put(c, map.getOrDefault(c, 0) + 1);

        }

        for (Map.Entry<Character, Integer> entry : map.entrySet()) {

            System.out.println(entry.getKey() + " -> " + entry.getValue());

        }
    }

    /*
    Problem:
    Count occurrences of digits in a number.

    Example:
    Input  : 1122334455
    Output :
    1 -> 2
    2 -> 2
    3 -> 2
    4 -> 2
    5 -> 2
    */

    public static void countDigitFrequency(int number) {

        Map<Integer, Integer> map = new HashMap<>();

        while (number > 0) {

            int digit = number % 10;

            map.put(digit, map.getOrDefault(digit, 0) + 1);

            number = number / 10;
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {

            System.out.println(entry.getKey() + " -> " + entry.getValue());

        }
    }
}