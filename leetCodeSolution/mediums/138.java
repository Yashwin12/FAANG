/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/
//1) T: O(n) | S: O(n)
// class Solution {
//     public Node copyRandomList(Node head) {
//         Map<Node, Node> map = new HashMap<>();

//         Node current = head;

//         while (current != null) {
//             map.put(current, new Node(current.val));
//             current = current.next;
//         }

//         current = head;

//         while (current != null) {
//             map.get(current).next = map.get(current.next);
//             map.get(current).random = map.get(current.random);
//             current = current.next;
//         }

//         return map.get(head);
//     }
// }

//2) T: O(n) | S: O(1)
// HACK: https://leetcode.com/problems/copy-list-with-random-pointer/discuss/43632/Java-very-simple-and-clean-solution-with-O(n)-time-O(1)-space-(with-algorithm)
class Solution {
    public Node copyRandomList(Node head) {
        if( head == null )
            return null;
            
        Node current = head;
        
        while( current != null ){
            Node copy = new Node( current.val);
            Node temp = current.next;
            
            current.next = copy;
            copy.next = temp;
            
            current = current.next.next;
        }
        
        current = head;
        
        while( current != null ){
            if( current.next != null && current.random != null ){
                current.next.random = current.random.next;
            }
            current = current.next.next;
        }
        
        Node original = head;
        Node clone = head.next;
        Node cloneHead = head.next;
        
        while( original.next != null && clone.next != null ){
            original.next = original.next.next;
            original = original.next;
            
            clone.next = clone.next.next;
            clone = clone.next;                    
        }
                
        if( original != null && original.next != null )
            original.next = null;
        
        return cloneHead;
    }
}