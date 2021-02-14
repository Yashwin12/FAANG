import java.util.*;

// T: O(n * log(k)) | S: O(1)
class Program {

    public int[] sortKSortedArray(int[] array, int k) {

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        int idx = 0;
        for (int i = 0; i < array.length; i++) {

            // Here we know that an array index is out of order by K elements.
            if ( minHeap.size() == k + 1) {
                array[idx] = minHeap.poll();
                idx++;
            }
            minHeap.add(array[i]);
        }

        while (idx < array.length) {
            array[idx] = minHeap.poll();
            idx++;
        }

        return array;
    }
}
