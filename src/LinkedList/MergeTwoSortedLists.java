package LinkedList;

public class MergeTwoSortedLists {

    // ------------------------------------------------------------
    // Definition for singly-linked list.
    // ------------------------------------------------------------
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {

        System.out.println("Welcome to Merge Two Sorted Linked Lists Problem\n");

        // ---------------- LIST 1 & LIST 2 (Example 1) ----------------
        int[] arr1 = {1, 2, 4};
        int[] arr2 = {1, 3, 5};

        ListNode list1 = buildList(arr1);
        ListNode list2 = buildList(arr2);

        System.out.println("Input List1:");
        printList(list1);

        System.out.println("Input List2:");
        printList(list2);

        System.out.println("Brute Force Result:");
        ListNode bruteResult = mergeBrute(list1, list2);
        printList(bruteResult);

        System.out.println("Optimized Result:");
        ListNode optimizedResult = mergeOptimized(buildList(arr1), buildList(arr2));
        printList(optimizedResult);

        // Expected Output:
        // 1 -> 1 -> 2 -> 3 -> 4 -> 5


        // ---------------- LIST 3 & LIST 4 (Edge Case) ----------------
        int[] arr3 = {};
        int[] arr4 = {1, 2};

        ListNode list3 = buildList(arr3);
        ListNode list4 = buildList(arr4);

        System.out.println("Input List3:");
        printList(list3);

        System.out.println("Input List4:");
        printList(list4);

        System.out.println("Optimized Result:");
        ListNode optimizedEdge = mergeOptimized(list3, list4);
        printList(optimizedEdge);

        // Expected Output:
        // 1 -> 2
    }

    // ------------------------------------------------------------
    // BRUTE FORCE APPROACH (Using Array + Sorting)
    // ------------------------------------------------------------
    // Idea:
    // 1️⃣ Store values of both lists in an array
    // 2️⃣ Sort the array
    // 3️⃣ Create new sorted linked list
    //
    // Time Complexity: O((n+m) log(n+m))
    // Space Complexity: O(n+m) ❌
    // ------------------------------------------------------------

    public static ListNode mergeBrute(ListNode list1, ListNode list2) {

        java.util.List<Integer> values = new java.util.ArrayList<>();

        while (list1 != null) {
            values.add(list1.val);
            list1 = list1.next;
        }

        while (list2 != null) {
            values.add(list2.val);
            list2 = list2.next;
        }

        java.util.Collections.sort(values);

        ListNode dummy = new ListNode(-1);
        ListNode current = dummy;

        for (int val : values) {
            current.next = new ListNode(val);
            current = current.next;
        }

        return dummy.next;
    }

    // ------------------------------------------------------------
    // OPTIMIZED APPROACH (Two Pointer Merge)
    // ------------------------------------------------------------
    // Idea:
    // 1️⃣ Use dummy node
    // 2️⃣ Compare list1 and list2 values
    // 3️⃣ Attach smaller node
    // 4️⃣ Move pointer forward
    //
    // Time Complexity: O(n + m) ✅
    // Space Complexity: O(1) ✅
    // ------------------------------------------------------------

    public static ListNode mergeOptimized(ListNode list1, ListNode list2) {

        if (list1 == null) return list2;
        if (list2 == null) return list1;

        ListNode dummy = new ListNode(-1);
        ListNode current = dummy;

        while (list1 != null && list2 != null) {

            if (list1.val <= list2.val) {
                current.next = list1;
                list1 = list1.next;
            } else {
                current.next = list2;
                list2 = list2.next;
            }

            current = current.next;
        }

        // Attach remaining nodes
        if (list1 != null) {
            current.next = list1;
        } else {
            current.next = list2;
        }

        return dummy.next;
    }

    // ------------------------------------------------------------
    // Utility Function to Build Linked List from Array
    // ------------------------------------------------------------

    public static ListNode buildList(int[] arr) {

        if (arr.length == 0) return null;

        ListNode head = new ListNode(arr[0]);
        ListNode current = head;

        for (int i = 1; i < arr.length; i++) {
            current.next = new ListNode(arr[i]);
            current = current.next;
        }

        return head;
    }

    // ------------------------------------------------------------
    // Utility Function to Print Linked List
    // ------------------------------------------------------------

    public static void printList(ListNode head) {

        if (head == null) {
            System.out.println("(empty)\n");
            return;
        }

        ListNode current = head;

        while (current != null) {
            System.out.print(current.val);
            if (current.next != null)
                System.out.print(" -> ");
            current = current.next;
        }

        System.out.println("\n");
    }
}