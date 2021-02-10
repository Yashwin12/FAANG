public class EnumsBasics {
    
    public enum State{
        visited,
        visiting,
        unvisited;
    }

    //HACK: https://www.geeksforgeeks.org/enum-in-java/
    public static void main( String[] args ){
        State currentState = State.visited;
    }
}
