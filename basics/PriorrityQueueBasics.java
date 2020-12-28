import java.util.*;

class PriorrityQueueBasics {

    public static void main(String[] args) {

        // 1) We use PriorityQueue class to implement (Min/Max) Heaps in Java. By
        // default "Min Heap" is implemented by this class.
        PriorityQueue<Integer> pqMin = new PriorityQueue<Integer>(); // MIN HEAP

        // 2) Implements Max Heap
        // HACK: https://stackoverflow.com/questions/11003155/change-priorityqueue-to-max-priorityqueue

        PriorityQueue<Integer> pqMax = new PriorityQueue<>((x, y) -> y - x);
                            // OR
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
                            //OR
        PriorityQueue<Integer> pq = new PriorityQueue<Integer> ( new Comparator<Integer> () {
            public int compare(Integer a, Integer b) {
                return b - a;
            }
        });        
        
        queue.add(e);
        queue.offer(e);

        queue.poll();
        queue.peek();

        queue.size();

        // Removes a single instance of the specified element from this queue, if it is present.
        queue.remove(ele);
        
    }
}
