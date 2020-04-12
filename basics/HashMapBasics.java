import java.util.*;

class HashMapBasics{
    public static void main (String[] args){

        HashMap<String, String> hashMapObj = new HashMap<>();
        
        // 1) Associates the specified value with the specified key in this map.
        hashMapObj.put("key1", "one");
        hashMapObj.put("key2", "two");
        // If the specified key is not already associated with a value (or is mapped to null) associates it with the given value and returns null, else returns the current value.
        hashMapObj.putIfAbsent("key4", "four"); 

        Map<String, String> copy = new HashMap<>();
        
        // 2) Returns true if this map contains no key-value mappings.
        if (copy.isEmpty()) { 
            System.out.println("map is empty"); 
        } 
        copy = ( HashMap<String, String> ) hashMapObj.clone();

        if(!copy.isEmpty()){
            // 3) Returns a Set view of the keys contained in this map.
            System.out.println("KEYSET:"+ copy.keySet()); 
            
            // 4) Returns a Collection view of the values contained in this map.
            System.out.println("VALUES:"+ copy.values()); 
        }
        // 5) Returns true if this map contains a mapping for the specified key.
        if( hashMapObj.containsKey("key1") ){

            // 6) Returns the value to which the specified key is mapped, or null if this map contains no mapping for the key.
            System.out.println(hashMapObj.get("key1"));
            //Returns the value to which the specified key is mapped, or defaultValue if this map contains no mapping for the key.
            System.out.println(hashMapObj.getOrDefault("key3", "three") );
        }

        // 7) Removes the mapping for the specified key from this map if present.
        hashMapObj.remove("key4");
        //Removes the entry for the specified key only if it is currently mapped to the specified value.
        hashMapObj.remove("key3", "three");

        // 8) Replaces the entry for the specified key only if it is currently mapped to some value.
        hashMapObj.replace("key2", "two2");
        //Replaces the entry for the specified key only if currently mapped to the specified value.
        hashMapObj.replace("key2", "two2", "two");

        // 9) Removes all of the mappings from this map.
        hashMapObj.clear();

        //10) Two ways to iterate through all the key and values in the map
        for (String key: hashMapObj.keySet()) {
            System.out.println("key : " + key);
            System.out.println("value : " + map.get(key));
        }
        //              OR
        for(Entry<String, Integer> entry: map.entrySet()) {
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
        }
        
    }
}