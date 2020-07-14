//1) Using Stack DS
// import java.util.*;

// class Program {
	
//   static class MinMaxStack {
// 		// [ [min, max], [min, max], [min, max] ]
// 		Stack<List<Integer>> minMaxStack = new Stack<List<Integer>>();
// 		Stack<Integer> stack = new Stack<>();
		
//     public int peek() {
//       return stack.peek();
//     }

//     public int pop() {
// 			int temp = stack.peek();
// 			stack.pop();
// 			minMaxStack.pop();
//       return temp;
//     }

//     public void push(Integer number) {
			
//       List<Integer> tempList = new ArrayList<>();
// 			tempList.add(number);
// 			tempList.add(number);
				
// 			if( !minMaxStack.isEmpty() ){
// 				int tempMin = number > minMaxStack.peek().get(0) ? minMaxStack.peek().get(0) : number;
// 				int  tempMax= number < minMaxStack.peek().get(1) ? minMaxStack.peek().get(1) : number;
			
// 				tempList.set( 0 , tempMin);
// 				tempList.set( 1 , tempMax);									
// 			}
			
// 			minMaxStack.push(tempList);
// 			stack.push(number);
//     }

//     public int getMin() {
//       return minMaxStack.peek().get(0);
//     }

//     public int getMax() {
//       return minMaxStack.peek().get(1);
//     }
//   }
// }

// 2) Using List DS
import java.util.*;

class Program {
    static class MinMaxStack {

        List<Map<String, Integer>> minMaxListMap = new ArrayList<Map<String, Integer>>();
        List<Integer> stack = new ArrayList<>();

        // T: O (1) | S: O(1)
        public int peek() {
            return stack.get(stack.size() - 1);
        }

        // T: O (1) | S: O(1)
        public int pop() {
            int popReturn = stack.get(stack.size() - 1);
            stack.remove(stack.size() - 1);
            minMaxListMap.remove(minMaxListMap.size() - 1);

            return popReturn;
        }

        // T: O (1) | S: O(1)
        public void push(Integer number) {
            Map<String, Integer> tempMap = new HashMap<>();
            tempMap.put("max", number);
            tempMap.put("min", number);

            if (minMaxListMap.size() > 0) {
                int tempMax = number < minMaxListMap.get(minMaxListMap.size() - 1).get("max")
                        ? minMaxListMap.get(minMaxListMap.size() - 1).get("max")
                        : number;

                int tempMin = number > minMaxListMap.get(minMaxListMap.size() - 1).get("min")
                        ? minMaxListMap.get(minMaxListMap.size() - 1).get("min")
                        : number;

                tempMap.replace("max", tempMax);
                tempMap.replace("min", tempMin);

            }
            minMaxListMap.add(tempMap);
            stack.add(number);
        }

        // T: O (1) | S: O(1)
        public int getMin() {
            return minMaxListMap.get(minMaxListMap.size() - 1).get("min");
        }

        // T: O (1) | S: O(1)
        public int getMax() {
            return minMaxListMap.get(minMaxListMap.size() - 1).get("max");
        }
    }
}

