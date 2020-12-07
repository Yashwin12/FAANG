// Feel free to add new properties and methods to the class.
// TEST CASE #3 is failing
class Program {
	static class DoublyLinkedList {
		public Node head;
		public Node tail;

		//  T: O(1) | S: O(1)
		public void setHead(Node node) {
			// Write your code here.
			if (this.head == null) {
				this.head = node;
				this.tail = node;
			}
			insertBefore(this.head, node);
		}
		
		//  T: O(1) | S: O(1)
		public void setTail(Node node) {
			// Write your code here.
			if (tail == null) {
				setHead(node);
				return;
			}
			insertAfter(tail, node);

		}

		//  T: O(1) | S: O(1)
		public void insertBefore(Node node, Node nodeToInsert) {
			// Write your code here.
			if (nodeToInsert == head && nodeToInsert == tail) {
				return;
			}

			remove(nodeToInsert);
			nodeToInsert.prev = node.prev;
			nodeToInsert.next = node;
			if (node.prev == null) {
				head = nodeToInsert;
			} else {
				node.prev.next = nodeToInsert;
			}
			node.prev = nodeToInsert;
		}

		//  T: O(1) | S: O(1)
		public void insertAfter(Node node, Node nodeToInsert) {
			// Write your code here.
			if (nodeToInsert == head && nodeToInsert == tail) {
				return;
			}
			remove(nodeToInsert);
			nodeToInsert.prev = node;
			nodeToInsert.next = node.next;

			if (node.next == null) {
				tail = nodeToInsert;
			} else {
				node.next.prev = nodeToInsert;
			}
			node.next = nodeToInsert;
		}

		//  T: O(position) | S: O(1)
		public void insertAtPosition(int position, Node nodeToInsert) {

			if (position == 1) {
				setHead(nodeToInsert);
				return;
			}

			Node pointer = head;
			int count = 1;
			while (count != position && pointer != null) {
				count++;
				pointer = pointer.next;
			}
			if (pointer == null) {
				setTail(nodeToInsert);
			} else {
				insertBefore(pointer, nodeToInsert);
			}

		}
		
		//  T: O(n) | S: O(1)
		public void removeNodesWithValue(int value) {
			Node tempHead = head;

			while (tempHead != null) {
				// Doing this in order to make sure we remove all the nodes having this value
				// not just the first occurence.
				Node anotherTempHead = tempHead;
				tempHead = tempHead.next;
				if (anotherTempHead.value == value) {
					// call removeNode method
					remove(anotherTempHead);
				}
			}
		}

		//  T: O(1) | S: O(1)
		public void remove(Node node) {

			if (head == node) {
				head = head.next;
			}
			if (tail == node) {
				tail = tail.prev;
			}
			removeNodeBindings(node);
		}

		//  T: O(n) | S: O(1)
		public boolean containsNodeWithValue(int value) {
			Node currentNode = head;

			while (currentNode != null) {
				if (currentNode.value == value) {
					return true;
				}
				currentNode = currentNode.next;
			}
			return false;
		}

		public void removeNodeBindings(Node node) {
			if (node.prev != null) {
				node.prev.next = node.next;
			}
			if (node.next != null) {
				node.next.prev = node.prev;
			}

			node.next = null;
			node.prev = null;
		}
	}

	// Do not edit the class below.
	static class Node {
		public int value;
		public Node prev;
		public Node next;

		public Node(int value) {
			this.value = value;
		}
	}
}
