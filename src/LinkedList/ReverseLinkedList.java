package LinkedList;

public class ReverseLinkedList {

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

        System.out.println("Welcome to Reverse Linked List Problem\n");

        // ---------------- LIST 1 ----------------
        int[] arr1 = {0, 1, 2, 3};

        ListNode head1 = buildList(arr1);

        System.out.println("Input List1:");
        printList(head1);

        System.out.println("Brute Force Result List1:");
        ListNode brute1 = reverseListBrute(head1);
        printList(brute1);

        System.out.println("Optimized Result List1:");
        ListNode optimized1 = reverseListOptimized(brute1);
        printList(optimized1);

        // Expected Output:
        // 3 -> 2 -> 1 -> 0


        // ---------------- LIST 2 ----------------
        int[] arr2 = {};

        ListNode head2 = buildList(arr2);

        System.out.println("Input List2:");
        printList(head2);

        System.out.println("Brute Force Result List2:");
        ListNode brute2 = reverseListBrute(head2);
        printList(brute2);

        System.out.println("Optimized Result List2:");
        ListNode optimized2 = reverseListOptimized(brute2);
        printList(optimized2);

        // Expected Output:
        // (empty)
    }

    // ------------------------------------------------------------
    // BRUTE FORCE APPROACH (Using Array)
    // ------------------------------------------------------------
    // Idea:
    // 1️⃣ Store node values in array
    // 2️⃣ Create new reversed linked list
    //
    // Time Complexity: O(n)
    // Space Complexity: O(n) ❌
    // ------------------------------------------------------------

    public static ListNode reverseListBrute(ListNode head) {

        if (head == null) return null;

        java.util.List<Integer> values = new java.util.ArrayList<>();
        ListNode current = head;

        while (current != null) {
            values.add(current.val);
            current = current.next;
        }

        ListNode newHead = null;

        for (int i = 0; i < values.size(); i++) {
            ListNode node = new ListNode(values.get(i));
            node.next = newHead;
            newHead = node;
        }

        return newHead;
    }

    // ------------------------------------------------------------
    // OPTIMIZED APPROACH (In-place Pointer Reversal)
    // ------------------------------------------------------------
    // Idea:
    // 1️⃣ Use 3 pointers: prev, current, next
    // 2️⃣ Reverse links one by one
    //
    // Time Complexity: O(n)
    // Space Complexity: O(1) ✅
    // ------------------------------------------------------------

    public static ListNode reverseListOptimized(ListNode head) {

        if (head == null) return null;

        ListNode prev = null;
        ListNode current = head;

        while (current != null) {

            ListNode next = current.next;  // Save next node
            current.next = prev;           // Reverse pointer
            prev = current;                // Move prev forward
            current = next;                // Move current forward
        }

        return prev;  // New head
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