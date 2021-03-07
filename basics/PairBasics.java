import java.util.*;

// NOTE: This is a pre-baked class available in java. We can just use it as any other class (Refer 73.java)
public class PairBasics {
    
    // A geenric class for "key-value" for an object. 
    class Pair<U,V> { 
        public final U first;
        public final V second;

        private Pair( U first, V second ){
            this.first = first;
            this.second = second;
        }
    }

    Pair<Integer, String> pair = new Pair<>(1, "One");
    Integer key = pair.getKey(); // 1
    String value = pair.getValue(); // "One"

    // The same class can be used for another data type..
    Pair<String, String> pair2 = new Pair<>("1", "One");
    String key2 = pair.getKey(); // "1"
    String value2 = pair.getValue(); // "One"

}
