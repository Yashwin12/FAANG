import java.util.*;

// Do not edit the class below except for the buildHeap,
// siftDown, siftUp, peek, remove, and insert methods.
// Feel free to add new properties and methods to the class.
class Program {
    static class MinHeap {
        List<Integer> heap = new ArrayList<Integer>();

        public MinHeap(List<Integer> array) {
            heap = buildHeap(array);
        }

        // NOT INTUITIVE. More optimal than using siftUp. T: O(n) | S: O(1)
        public List<Integer> buildHeap(List<Integer> array) {
            int firstParentIdx = (array.size() - 2) / 2;
            for (int currentIdx = firstParentIdx; currentIdx >= 0; currentIdx--) {
                siftDown(currentIdx, array.size() - 1, array);
            }
            return array;
        }

        // NOT INTUITIVE. Building Heap using siftUp, Although its not optimal. T: O(n *log(n) ) | S: O(1). As we start from the root node, in the worst case we might have to siftUp from the leaf node till the root.
        // public List<Integer> buildHeap(List<Integer> array) {
        //     int firstNode = 1;
        //     for (int currentIdx = firstNode; currentIdx <= array.size() - 1; currentIdx++) {
        //         siftUp(currentIdx, array);
        //     }
        //     return array;
        // }

        // Space : O(1) | Time: O(log(n))
        public void siftDown(int currentIdx, int endIdx, List<Integer> heap) {
            int childOneIdx = (2 * currentIdx) + 1;
            while (childOneIdx > 0 && childOneIdx <= endIdx) {
                int childTwoIdx = (2 * currentIdx) + 2 <= endIdx ? (2 * currentIdx) + 2 : -1;
                int indexToSwap;
                if (childTwoIdx != -1 && heap.get(childOneIdx) > heap.get(childTwoIdx)) {
                    indexToSwap = childTwoIdx;
                } else {
                    indexToSwap = childOneIdx;
                }

                if (heap.get(currentIdx) > heap.get(indexToSwap)) {
                    swap(currentIdx, indexToSwap, heap);
                    currentIdx = indexToSwap;
                    childOneIdx = (2 * currentIdx) + 1;
                } else {
                    return;
                }

            }

        }

        // Space : O(1) | Time: O(log(n))
        public void siftUp(int currentIdx, List<Integer> heap) {
            int parentIdx = (currentIdx - 1) / 2;
            while (currentIdx > 0 && heap.get(parentIdx) > heap.get(currentIdx)) {
                swap(currentIdx, parentIdx, heap);
                currentIdx = parentIdx;
                parentIdx = (currentIdx - 1) / 2;
            }
        }

        public int peek() {
            return heap.get(0);
        }

        // Space : O(1) | Time: O(log(n))
        public int remove() {
            int valueToRemove = heap.get(0);
            swap(0, heap.size() - 1, heap);

            heap.remove(heap.size() - 1);
            siftDown(0, heap.size() - 1, heap);
            return valueToRemove;
        }

        // Space : O(1) | Time: O(log(n))
        public void insert(int value) {
            heap.add(value);
            siftUp(heap.size() - 1, heap);
        }

        public void swap(int i, int j, List<Integer> heap) {
            Integer temp = heap.get(j);
            heap.set(j, heap.get(i));
            heap.set(i, temp);
        }
    }
}
