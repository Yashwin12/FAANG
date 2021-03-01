/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        
        // First we will add an auxiliary "dummy" node, which points to the list head. The "dummy" node is used to simplify some corner cases such as a list with only one node, or removing the head of the list
        ListNode dummy = new ListNode(-1, head);
        ListNode right = dummy;
        
        int count = 0;
        while( count < n ){
            count++;
            right = right.next;
        }
        
        ListNode left = dummy;
        
        while( right!= null && right.next != null ){
            left = left.next;
            right = right.next;
        }
        
        left.next = left.next.next;
        
        return dummy.next;
    }
    
    
}