import java.util.*;

// We can insert the null value into the LinkedList but couldn't insert it into the Queue , despite implementing Queue by LinkedList 
class QueueBasics{
    public static void main(String[] args){
        Deque<Integer> queueObj = new LinkedList<>(); 

        // 1) Pushes an item onto the top of this stack.
        queueObj.push(1);
        queueObj.push(2);
        
        // 2) Looks at the object at the top of this stack without removing it from the stack.
        System.out.println("PEEK : " + queueObj.peek());

        // 3) Removes the object at the top of this stack and returns that object as the value of this function.
        System.out.println("POP:" +queueObj.pop());

        // 4) Tests if this stack is empty.
        if(!queueObj.isEmpty()){
            queueObj.pop();
        }

        // 5) To check size.  
        queueObj.size();
        
        // 6) Removes head of the queueObj. SAFER THEN POP() 
        // HACK: https://stackoverflow.com/questions/35547237/whats-the-difference-between-poll-and-pop-for-linkedlist-in-java/35547277
        queueObj.poll();
    }
}