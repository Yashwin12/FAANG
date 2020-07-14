import java.util.*;

class LinkedListBasics{

    // LinkedList -> Allows null entry
    public static void main(String[] args){

        // Linked List implementation via Queue interface is handled more than List interface. 
        // If list methods encountered some problems like an empty list then it throws expcetion; In Queue similar exceptions are handled.  

        // public E peekFirst() {
        //     if (size==0)
        //        return null;
       
        //     return getFirst();
        // }

        LinkedList<String> linkedListObj = new LinkedList<>();

        // 1) Appends the specified element to the end of this list.
        // element can not be added to collection the ADD method throws an exception and OFFER doesn't.
        linkedListObj.add("first");
        linkedListObj.offer("first1");

        // 2) Inserts the specified element at the beginning of this list. (List interface implementation)
        linkedListObj.addFirst("first");
         // Inserts the specified element at the front of this list. (Deque interface implementation)
        linkedListObj.offerFirst("first2");

        // 3) Inserts the specified element at the beginning of this list.        
        linkedListObj.addLast("last");
        // Inserts the specified element at the last of this list.
        linkedListObj.offerLast("first2");

        // 4) Inserts the specified element at the specified position in this list. 
        linkedListObj.add(0, "newFirst");

        System.out.println(linkedListObj);
        
        // 5) Returns a shallow copy of this LinkedList.
        LinkedList<String> copy = (LinkedList<String>) linkedListObj.clone();

        // 6) Returns true if this list contains the specified element.
        copy.contains("last");

        // 7) Returns the element at the specified position in this list.
        copy.get(0);
        //Retrieves, but does not remove, the head (first element) of this list.
        copy.peek();
        //Retrieves and removes the head (first element) of this list.
        linkedListObj.poll();

        // 8) Returns the first element in this list.
        copy.getFirst();
        // Retrieves, but does not remove, the first element of this list, or returns null if this list is empty.
        copy.peekFirst();
        //Retrieves and removes the first element of this list, or returns null if this list is empty.
        linkedListObj.pollFirst();

        // 9) Returns the last element in this list.
        copy.getLast();
        //Retrieves, but does not remove, the last element of this list, or returns null if this list is empty.
        copy.peekLast();
        //Retrieves and removes the last element of this list, or returns null if this list is empty.
        linkedListObj.pollLast();
        
        // 10) Returns the index of the first occurrence of the specified element in this list, or -1 if this list does not contain the element.
        linkedListObj.indexOf("first");
        // Returns the index of the last occurrence of the specified element in this list, or -1 if this list does not contain the element.
        linkedListObj.lastIndexOf("last");
       
        // 11) Replaces the element at the specified position in this list with the specified element.
        linkedListObj.set(0, "1st");

        // 12) Returns an array containing all of the elements in this list in proper sequence (from first to last element)
        Object[] a = linkedListObj.toArray();

        // 13) Removes all of the elements from this list. 
        linkedListObj.clear();
        
    }
}