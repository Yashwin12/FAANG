import java.util.*;
class ArrayBasics{

    public static void main (String[] args){

        //int[] arr = new int[3];
        Integer[] arr = {1,2,3};

        // 1) Returns a fixed-size list backed by the specified array.
        List<Integer> a = Arrays.asList(arr);
        for(int i = 0; i < a.size(); i++){
            System.out.println(a.get(i));
        }

       // 2) arr passed should be sorted and key inteded to found in array is passed.
       // Searches the specified array of ints for the specified value using the binary search algorithm. 
        int ab = Arrays.binarySearch(arr, -12);
        System.out.println(ab);

        // 3) It copies the specified array, truncating or padding with false (if necessary) so the copy has the specified length.
        Integer[] copy = Arrays.copyOf(arr, 5);  // copy array of size five is created.

        // 4) This method creates a copy of elements, within a specified range of the original array.
        Integer[] copyRange = Arrays.copyOfRange(arr, 1, 2);  

        // 5) Returns true if the two specified arrays of Objects are equal to one another.  
        Boolean bool = Arrays.equals(copyRange, copy);

        // 6) Sorts with the help of  Dual-Pivot Quicksort. O(n log(n)) performance   
        Arrays.sort(arr);
            // OR
        
        Foo fooObj = new Foo();     
        Collections.sort(new ArrayList<Foo>(), new Comparator (){
            public int compare(Object o1, Object o2) {
                // some complex logic over here for sorting.
            }   
        });

        // Array sorting in reverse order
        Arrays.sort(arr, Collections.reverseOrder()); 

        // 7)  converts array to a string
        arr.toString();

        // 8) Replace value at a specific index
        a.set(0, 100); // replaces 0th element with 100;

        // 9) Sometimes while printing array one gets weird memory address by : System.out.println( arr );
        System.out.println( Arrays.toString( arr ) ); // This would print the whole god damn array :)
    }
}
