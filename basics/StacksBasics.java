import java.util.*;

// LIFO 
class StacksBasics{
    public static void main(String[] args){
        Stack<Integer> stackObj = new Stack<>();
        
        // 1) Pushes an item onto the top of this stack.
        stackObj.push(1);
        stackObj.push(2);
        
        // 2) Looks at the object at the top of this stack without removing it from the stack.
        System.out.println("PEEK : " + stackObj.peek());

        // 3) Removes the object at the top of this stack and returns that object as the value of this function.
        System.out.println("POP:" +stackObj.pop());
        
        // 4) Returns the 1-based position where an object is on this stack.
        System.out.println(stackObj.search(2));
    
        // 5) Tests if this stack is empty.
        if(!stackObj.isEmpty()){
            stackObj.pop();
        }
    }
}