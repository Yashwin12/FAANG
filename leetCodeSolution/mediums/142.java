// HACK: https://www.youtube.com/watch?v=S6IfqDXWa10
// HACK: https://www.youtube.com/watch?v=NDpwj0VWz1U 
class LRUCache {
    private Node head;
    private Node tail;
    private int maxSize;
    private Map<Integer, Node> cache;

    public LRUCache(int capacity) {
        this.maxSize = capacity;
        head = new Node();
        tail = new Node();
        cache = new HashMap<>();

        // Wire the head and tail together
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if (cache.containsKey(key)) {
            Node temp = cache.get(key);
            remove(temp);
            add(temp);

            return temp.value;
        }

        return -1;
    }

    public void put(int key, int value) {

        if (cache.containsKey(key)) {
            Node temp = cache.get(key);
            remove(temp);
            temp.value = value;
            add(temp);
        } else {
            if (cache.size() == maxSize) {
                cache.remove(tail.prev.key);
                remove(tail.prev);
            }

            Node nodeToAdd = new Node(key, value);
            cache.put(key, nodeToAdd);
            add(nodeToAdd);
        }
    }

    private void remove(Node node) {
        Node prevNode = node.prev;
        Node nextNode = node.next;

        prevNode.next = nextNode;
        nextNode.prev = prevNode;
    }

    private void add(Node node) {
        Node headNext = head.next;

        node.next = headNext;
        node.prev = head;

        head.next = node;
        headNext.prev = node;
    }

    private class Node {
        private int key;
        private int value;
        private Node prev;
        private Node next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
            this.prev = null;
            this.next = null;
        }

        Node() {

        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such: LRUCache obj =
 * new LRUCache(capacity); int param_1 = obj.get(key); obj.put(key,value);
 */