// import java.util.*;

// class Program {
//     // This is an input class. Do not edit.
//     public static class LinkedList {
//         public int value;
//         public LinkedList next;

//         public LinkedList(int value) {
//             this.value = value;
//             this.next = null;
//         }
//     }

//     // 1) T: O(n) | S: O(1)
//     public boolean linkedListPalindrome(LinkedList head) {
//         if (head == null)
//             return true;

//         LinkedList slow = head;
//         LinkedList fast = head;

//         while (fast != null && fast.next != null) {
//             slow = slow.next;
//             fast = fast.next.next;
//         }

//         if (fast != null) {
//             // Potential ODD numbered of LL.
//             slow = slow.next;
//         }

//         slow = reverseLinkedList(slow);

//         while (slow != null) {

//             if (head.value != slow.value)
//                 return false;

//             head = head.next;
//             slow = slow.next;
//         }

//         return true;
//     }

//     private LinkedList reverseLinkedList(LinkedList otherHalf) {
//         LinkedList current = otherHalf;
//         LinkedList prev = null;

//         while (current != null) {
//             LinkedList nextNode = current.next;
//             current.next = prev;
//             prev = current;
//             current = nextNode;
//         }

//         return prev;
//     }

// }

import java.util.*;

class Program {
    // This is an input class. Do not edit.
    public static class LinkedList {
        public int value;
        public LinkedList next;

        public LinkedList(int value) {
            this.value = value;
            this.next = null;
        }
    }
    
    // 2) T: O(n) | S: O(n/2) ~ O(n) - for Using stack. 
    // Solution idea from the CTCI book.
    public boolean linkedListPalindrome(LinkedList head) {
        if (head == null)
            return true;

        LinkedList slow = head;
        LinkedList fast = head;

        Stack<Integer> stack = new Stack<>();

        while (fast != null && fast.next != null) {

            stack.push(slow.value);
            slow = slow.next;
            fast = fast.next.next;
        }

        if (fast != null) {
            // Potential ODD numbered of LL.
            slow = slow.next;
        }

        while (slow != null && !stack.isEmpty()) {
            int currentValue = stack.pop();

            if (currentValue != slow.value)
                return false;

            slow = slow.next;
        }

        return stack.isEmpty();
    }
}
