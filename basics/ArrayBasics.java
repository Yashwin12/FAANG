import java.util.*;
class ArrayBasics{

    // ArrayList -> Allows multiple null entry
    // int[] a = null; Invalid becuase primitive datatype cant have null values
    public static void main (String[] args){

        //int[] arr = new int[3];
        Integer[] arr = {1,2,3};

        // This will initialize all the indexes of an array with 500.
        Arrays.fill(arr, 500);

        // 1) Returns a fixed-size list backed by the specified array.
        // Copies array arr values to a list 'a'. 
        List<Integer> a = Arrays.asList(arr);
        for(int i = 0; i < a.size(); i++){
            System.out.println(a.get(i));
        }
        // Copies oldList values to a newList values. NOTE: This makes a "shallow" copy
        List<Integer> newList = new ArrayList<>(oldList); 

        // This would initialize anotherList as [0,1];
        List<Integer> anotherList = new ArrayList<>(Arrays.asList(0,1));

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


        // Refer 937.java file for implementation
        Collections.sort(new ArrayList<Foo>(), new Comparator (){
            public int compare(Object o1, Object o2) {
                // some complex logic over here for sorting.
            }   
        });
        // Makes Collection sort in reverseOrder
        Collections.sort( list, Collections.reverseOrder() );

        // Array sorting in reverse order
        Arrays.sort(arr, Collections.reverseOrder()); 

        // 7)  converts array to a string
        arr.toString();

        // 8) Replace value at a specific index
        a.set(0, 100); // replaces 0th element with 100;

        // 9) Sometimes while printing array one gets weird memory address by : System.out.println( arr );
        System.out.println( Arrays.toString( arr ) ); // This would print the whole god damn array :)

        // 10) Returns true if this list contains the specified element.
        a.contains(10);

        // 11) Returns the index of the FIRST occurrence of the specified element in this list, or -1 if this list does not contain the element. 
        a.indexOf(10);

        // 11) Removes the first occurrence of the specified ELEMENT from this list, if it is present (optional operation). If this list does not contain the element, it is unchanged.
        a.remove(10); // REMOVE BY THE ELEMENT value

        // Removes the element at the specified position in this list (optional operation). 
        a.remove(0); // Removes value at 0th index

        // 12) Appends all of the elements in the specified collection to the end of this list, i
        a.addAll(collection);

        // 13) Initialize arrayList with 1,10,100
        ArrayList<Integer> initializeList = new ArrayList<>() {
            {
                add(1);
                add(10);
                add(100);
            }
        };
                // OR
        // ArrayList<Integer> initializeList = new ArrayList<>( Arrays.asList( 1,10, 100 ) ); 


        // If one wants to compare list of an arrays [ [],[],[] ]        
        // -1 : o1 < o2
        // 0 : o1 == o2
        // +1 : o1 > o2

        // HACK: https://stackoverflow.com/questions/19596950/sort-an-arraylist-of-integer-arrays
        Collections.sort( list, (Integer[] a, Integer[] b) ->{
            // below will compare last element present in the arrays
            return (Integer)(a[a.length-1]).compareTo(b[b.length-1]);
        });

        // This is to convert List<int[]> to 2D matrix! 
        // BEWARE: int[] is actually an object, not a primitive.
        // HACK: https://stackoverflow.com/questions/47135950/how-can-i-convert-a-listint-to-a-2d-array/47136005#47136005
        List<int[]> lists = new ArrayList<>();
        int[][] converted = lists.toArray( new int[lists.size()][] );

    }
}
