class Program {
  public static void removeKthNodeFromEnd(LinkedList head, int k) {

		LinkedList L1 = head;
		LinkedList L2 = head;
		while ( k > 0 ){
			L2 = L2.next;
			k--;
		} 
		// This if condition is kept in order to satisfy test case #10.
		if (L2 == null){
			L1.value = L1.next.value;
			L1.next = L1.next.next;
			return;
		}
		while (L2 != null && L2.next != null){
			L1 = L1.next;
			L2 = L2.next;
		}
		L1.next = L1.next.next;
  }

  static class LinkedList {
    int value;
    LinkedList next = null;

    public LinkedList(int value) {
      this.value = value;
    }
  }
}
