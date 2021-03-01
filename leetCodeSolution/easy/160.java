/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

// 1) T: O(m*n) | S: O(m+n)

// public class Solution {
//     public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
//         ListNode A = headA;
        
//         while( A != null ){
//             ListNode B = headB;
            
//             while( B != null ){
//                 if( A == B )
//                     return A;
//                 B = B.next;
//             }
//             A = A.next;            
//         }
//         return null;
//     }
// }

// 2) T: O(m + n) | S: O(m); where m = length of headA
// public class Solution {
//     public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
//         Map<ListNode, Integer> map = new HashMap<>();
                
//         while ( headA != null ){
//             map.put( headA, headA.val );
//             headA = headA.next;
//         }
         
//         while ( headB != null ){
//             if( map.containsKey(headB) )
//                 if( headB.val == map.get(headB) )
//                     return headB;                
                        
//             headB = headB.next;
//         }
        
//         return null;
//     }
// }

// 3) T: O(m + n) | S: O(m); where m = length of headA
// HACK: https://www.youtube.com/watch?v=CPXIkMWNn5Q
// public class Solution {
//     public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
//         Set<ListNode> set = new HashSet<>();
                
//         while ( headA != null ){
//             set.add( headA );
//             headA = headA.next;
//         }
         
//         while ( headB != null ){
//             if( set.contains( headB ) )
//                 return headB;                                        
//             headB = headB.next;
//         }
//         return null;
//     }
// }

// 4) T: O(m +n) | S: O(1)
// HACK: https://leetcode.com/problems/intersection-of-two-linked-lists/discuss/49785/Java-solution-without-knowing-the-difference-in-len!
// public class Solution {
//     public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
//         ListNode ptrA = headA;
//         ListNode ptrB = headB;

//         // It will not have an infinite loop. If the two lists have no intersection, you may imagine that there is an "imaginary" intersection node which is null. The while loop continues when a != b, but if both nodes reach the "null" node, the loop will be terminated and return a (which is null).

//         while ( ptrA != ptrB ){
//             ptrA = ptrA == null ? headB : ptrA.next;
//             ptrB = ptrB == null ? headA : ptrB.next;
//         }
        
//         return ptrA;
//     }
// }


// 5) T: O(m+n) | T: O(1)
// HACK : https://www.youtube.com/watch?v=_7byKXAhxyM
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode ptrA = headA;
        ListNode ptrB = headB;
        
        int lenA = 0;
        int lenB = 0;
        
        while( ptrA != null ){
            lenA++;
            ptrA = ptrA.next;
        }
         
        while( ptrB != null ){
            lenB++;
            ptrB = ptrB.next;
        }
        
        ptrA = headA;
        ptrB = headB;
        if ( lenA > lenB ){
            while( lenA != lenB ){
                lenA--;
                ptrA = ptrA.next;
            }                
        }
        else if ( lenA < lenB ){
            while( lenA != lenB ){
                lenB--;
                ptrB = ptrB.next;
            }                
        }
             
        while ( ptrA != ptrB ){
            ptrA = ptrA.next;
            ptrB = ptrB.next;
        }
        
        return ptrA;
    }
}