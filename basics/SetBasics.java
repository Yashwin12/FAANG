import java.util.Set;

public class SetBasics {
 
    // HashSet - Doesn't maintain order. Allows null values however if you insert more than one nulls it would still return only one null value.
    // TreeSet - Sorts the elements in the ascending order. doesnt not allow null value
    // LinkedHashSet - Maintains the insertion order. Allows null values however if you insert more than one nulls it would still return only one null value.
    public static void main( String[] args ){
        Set<Integer> set = HashSet<>();

        //  1) Add elements to set
        set.add(21);
        set.add(22);

        // 2) Removes elements from set
        set.remove(22);

        // 3) To iterate over the values in set
        Iterator<Integer> i = set.iterator(); 
        while (i.hasNext()) 
            System.out.println(i.next()); 
            // OR
        for( int ele : set)
            System.out.println( ele ); 

        // 4) Returns true if this set contains the specified element.
        set.contains(21); // returns true as 21 is still in set.

        // 5) Returns true if this set contains no elements.
        set.isEmpty(); // returns false

        // 6) Returns the number of elements in this set.
        set.size() // returns 1.

        set.contains(o)
    } 
}