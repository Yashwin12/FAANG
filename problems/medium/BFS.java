import java.util.*;

class Program {
  // Do not edit the class below except
  // for the breadthFirstSearch method.
  // Feel free to add new properties
  // and methods to the class.
  static class Node {
    String name;
    List<Node> children = new ArrayList<Node>();

    public Node(String name) {
      this.name = name;
    }

    public List<String> breadthFirstSearch(List<String> array) {
			Queue<Node> queue = new LinkedList<>();
			queue.add(this);
			array.add (this.name);
			while ( !queue.isEmpty() ){
				Node current = queue.poll();
				
				for (int i = 0; i < current.children.size(); i++){
				
					queue.add(current.children.get(i));
					array.add( current.children.get(i).name );
				}
			}
      return array;
    }

    public Node addChild(String name) {
      Node child = new Node(name);
      children.add(child);
      return this;
    }
  }
}
