// 1) 
// class MyQueue {
    
//     private Stack<Integer> stack1;
    
//     /** Initialize your data structure here. */
//     public MyQueue() {
//         stack1 = new Stack<>();        
//     }
        
        // T: O(N) | S: O(N)
//     /** Push element x to the back of queue. */
//     public void push(int x) {
        
//         Stack<Integer> stack2 = new Stack<>();        

//         while( !stack1.empty() )
//             stack2.push( stack1.pop() );
        
//         stack1.push(x);
        
//         while( !stack2.empty() )
//             stack1.push( stack2.pop() );
//     }
    
        // T: O(1) | S: O(1)
//     /** Removes the element from in front of queue and returns that element. */
//     public int pop() {
//         return stack1.pop();
//     }
    
        // T: O(1) | S: O(1)
//     /** Get the front element. */
//     public int peek() {
//         return stack1.peek();
//     }
    
        // T: O(1) | S: O(1)
//     /** Returns whether the queue is empty. */
//     public boolean empty() {
//         return stack1.isEmpty();
//     }
// }

// /**
//  * Your MyQueue object will be instantiated and called as such:
//  * MyQueue obj = new MyQueue();
//  * obj.push(x);
//  * int param_2 = obj.pop();
//  * int param_3 = obj.peek();
//  * boolean param_4 = obj.empty();
//  */


//HACK : https://www.youtube.com/watch?v=ma1S6vtkw9I
class MyQueue {
    
    private Stack<Integer> stack1;
    private Stack<Integer> stack2 = new Stack<>();        

    
    /** Initialize your data structure here. */
    public MyQueue() {
        stack1 = new Stack<>();        
    }
    
    // T: O(1) | S: O(N)
    /** Push element x to the back of queue. */
    public void push(int x) {
        
        stack1.push(x);                
    }
    
    // T: Amortized O(1), Worst Case O(N) | S: O(1)
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if ( stack2.empty() )
            while( !stack1.empty() )
                stack2.push( stack1.pop() );       
                    //OR
        // peek();
//         
        return stack2.pop();
    }
    
    // T: Amortized O(1), Worst Case O(N) | S: O(1)
    /** Get the front element. */
    public int peek() {
          if ( stack2.empty() )
            while( !stack1.empty() )
                stack2.push( stack1.pop() );       
        
        return stack2.peek();
    }
    
        // T: O(1) | S: O(1)
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */