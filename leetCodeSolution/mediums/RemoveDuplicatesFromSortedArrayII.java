/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode() {} ListNode(int val) { this.val = val; } ListNode(int val,
 * ListNode next) { this.val = val; this.next = next; } }
 */

// HACK: https://www.youtube.com/watch?v=14PXbvtUbMo
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(-1);
        ListNode fast = head;
        ListNode slow = dummy;
        slow.next = fast;
        boolean skippedNumbs = false;

        while (fast != null) {
            skippedNumbs = false;
            while (fast.next != null && fast.val == fast.next.val) {
                fast = fast.next;
                skippedNumbs = true;
            }

            if (skippedNumbs == true) {
                fast = fast.next;
                slow.next = fast;
            } 
            else {
                slow = slow.next;
                fast = fast.next;
            }
        }

        return dummy.next;
    }
}