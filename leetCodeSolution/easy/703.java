// class KthLargest {

//     private int kth;
//     private List<Integer> list = new ArrayList<>();
    
//     public KthLargest(int k, int[] nums) {
//         kth = k;
//         for ( int ele : nums )
//             list.add(ele);
//     }
    
//     public int add(int val) {
//         list.add(val);        
//         Collections.sort(list);
        
//         return list.get( list.size() - kth);
//     }
// }

// 2) Smart way using minHeap 
class KthLargest {

    private int kth;
    private Queue<Integer> minHeap = new PriorityQueue<>();
    
    public KthLargest(int k, int[] nums) {
        kth = k; 
        
        for ( int ele : nums ){
            minHeap.offer(ele);
            if( minHeap.size() > kth )
                minHeap.poll();                               
        }
    }
    
    public int add(int val) {
        minHeap.offer(val);
        
        if( minHeap.size() > kth )
            minHeap.poll();

        return minHeap.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */

 