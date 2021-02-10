import java.util.*;

// This is bit different than the solution provided on AlgoExpert. Referenced from CTCI book.
// T: O(n) | S: O(1).
class Program {
  public static LinkedList rearrangeLinkedList(LinkedList head, int k) {
    LinkedList beforeStart = null;
		LinkedList beforeEnd = null;
		
		LinkedList equalStart = null;
		LinkedList equalEnd = null;
		
		LinkedList afterStart = null;
		LinkedList afterEnd = null;
		
		while( head != null ){
			LinkedList next = head.next;
			head.next = null;
			
			if( head.value == k){
				
				if( equalStart == null ){
					equalStart = head;
					equalEnd = equalStart;
				}	
				else{
					equalEnd.next = head;
					equalEnd = equalEnd.next;
				}				
			}
			
			else if( head.value < k){
				
				if( beforeStart == null ){
					beforeStart = head;
					beforeEnd = beforeStart;
				}	
				else{
					beforeEnd.next = head;
					beforeEnd = beforeEnd.next;
				}
				
			}
			
			else{
				if( afterStart == null ){
					afterStart = head;
					afterEnd = afterStart;
				}	
				else{
					afterEnd.next = head;
					afterEnd = afterEnd.next;
				}
			}
			
			head = next;
		}
		
		if( beforeStart != null ){
			beforeEnd.next = equalStart;
		}
		if( equalStart != null ){
			equalEnd.next = afterStart;
		}
		
		if( equalStart == null && afterStart != null && beforeEnd != null ){
			beforeEnd.next = afterStart;
		}
		
    return beforeStart != null ? beforeStart: equalStart != null? equalStart: afterStart;
  }

  static class LinkedList {
    public int value;
    public LinkedList next;

    public LinkedList(int value) {
      this.value = value;
      next = null;
    }
  }
}
