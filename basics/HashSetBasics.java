import java.util.Set;

public class HashSetBasics {
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

        // 4) Returns true if this set contains the specified element.
        set.contains(21); // returns true as 21 is still in set.

        // 5) Returns true if this set contains no elements.
        set.isEmpty(); // returns false

        // 6) Returns the number of elements in this set.
        set.size() // returns 1.
    } 
}