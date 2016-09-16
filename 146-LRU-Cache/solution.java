public class LRUCache {

    private class Node{
        int key;
        int value;
        Node prev;
        Node next;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
            this.prev = null;
            this.next = null;
        }
    }
    private int capacity;
    private HashMap<Integer, Node> hash = new HashMap<>();
    Node head = new Node(-1, -1);
    Node tail = new Node(-1, -1);

    public LRUCache(int capacity) {
        this.capacity = capacity;
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if (!hash.containsKey(key)) {
            return -1;
        }
        //remove current node
        Node current = hash.get(key);
        current.prev.next = current.next;
        current.next.prev = current.prev;
        //move current to tail
        movetotail(current);
        return current.value;
    }
    
    public void set(int key, int value) {
        if (get(key) != -1) {
            hash.get(key).value = value;
            return;
        }
        //check if cache is full, remove first if full;
        if (hash.size() == capacity) {
            hash.remove(head.next.key);
            head.next = head.next.next;
            head.next.prev = head;
        }
        Node insert = new Node(key, value);
        hash.put(key, insert);
        movetotail(insert);
    }

    public void movetotail(Node cur) {
        cur.prev = tail.prev;
        cur.next = tail;
        cur.prev.next = cur;
        tail.prev = cur;
    }
}