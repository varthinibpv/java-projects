import java.util.*;

class LRUCacheInteractive {

    interface LRUCache<K, V> {
        V get(K key);
        void put(K key, V value);
        void display();
    }

    // Implementation 1: HashMap + Doubly Linked List
    static class LRUCacheDLL<K, V> implements LRUCache<K, V> {

        private class Node {
            K key;
            V value;
            Node prev, next;
            Node(K key, V value) { this.key = key; this.value = value; }
        }

        private final int capacity;
        private Map<K, Node> map;
        private Node head, tail;

        public LRUCacheDLL(int capacity) {
            this.capacity = capacity;
            map = new HashMap<>();
        }

        private void remove(Node node) {
            if (node.prev != null) node.prev.next = node.next;
            else head = node.next;
            if (node.next != null) node.next.prev = node.prev;
            else tail = node.prev;
        }

        private void addToFront(Node node) {
            node.next = head;
            node.prev = null;
            if (head != null) head.prev = node;
            head = node;
            if (tail == null) tail = head;
        }

        @Override
        public V get(K key) {
            Node node = map.get(key);
            if (node == null) return null;
            remove(node);
            addToFront(node);
            return node.value;
        }

        @Override
        public void put(K key, V value) {
            Node node = map.get(key);
            if (node != null) {
                node.value = value;
                remove(node);
                addToFront(node);
            } else {
                if (map.size() >= capacity) {
                    map.remove(tail.key);
                    remove(tail);
                }
                Node newNode = new Node(key, value);
                addToFront(newNode);
                map.put(key, newNode);
            }
        }

        @Override
        public void display() {
            Node curr = head;
            while (curr != null) {
                System.out.print(curr.key + ":" + curr.value + " -> ");
                curr = curr.next;
            }
            System.out.println("NULL");
        }
    }

    // Implementation 2: LinkedHashMap wrapper
    static class LRUCacheLinkedHashMap<K, V> implements LRUCache<K, V> {
        private final int capacity;
        private LinkedHashMap<K, V> map;

        public LRUCacheLinkedHashMap(int capacity) {
            this.capacity = capacity;
            this.map = new LinkedHashMap<>(capacity, 0.75f, true) {
                @Override
                protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
                    return size() > LRUCacheLinkedHashMap.this.capacity;
                }
            };
        }

        @Override
        public void put(K key, V value) {
            map.put(key, value);
        }

        @Override
        public V get(K key) {
            return map.get(key);
        }

        @Override
        public void display() {
            for (Map.Entry<K, V> entry : map.entrySet()) {
                System.out.print(entry.getKey() + ":" + entry.getValue() + " -> ");
            }
            System.out.println("NULL");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter cache capacity:");
        int capacity = sc.nextInt();

        System.out.println("Select LRU implementation:");
        System.out.println("1: HashMap + Doubly Linked List");
        System.out.println("2: LinkedHashMap");
        int choice = sc.nextInt();

        LRUCache<Integer, String> cache;

        switch (choice) {
            case 1:
                cache = new LRUCacheDLL<>(capacity);
                break;
            case 2:
                cache = new LRUCacheLinkedHashMap<>(capacity);
                break;
            default:
                System.out.println("Invalid choice, defaulting to HashMap + DLL");
                cache = new LRUCacheDLL<>(capacity);
        }

        sc.nextLine(); // consume newline
        System.out.println("Enter commands: put <key> <value>, get <key>, display, exit");

        while (true) {
            System.out.print("> ");
            String line = sc.nextLine().trim();
            if (line.equalsIgnoreCase("exit")) break;
            String[] parts = line.split("\\s+");
            if (parts.length == 0) continue;

            switch (parts[0].toLowerCase()) {
                case "put":
                    if (parts.length == 3) {
                        try {
                            int key = Integer.parseInt(parts[1]);
                            String value = parts[2];
                            cache.put(key, value);
                        } catch (NumberFormatException e) {
                            System.out.println("Invalid key. Must be an integer.");
                        }
                    } else {
                        System.out.println("Usage: put <key> <value>");
                    }
                    break;
                case "get":
                    if (parts.length == 2) {
                        try {
                            int key = Integer.parseInt(parts[1]);
                            String val = cache.get(key);
                            System.out.println(val != null ? val : "Key not found");
                        } catch (NumberFormatException e) {
                            System.out.println("Invalid key. Must be an integer.");
                        }
                    } else {
                        System.out.println("Usage: get <key>");
                    }
                    break;
                case "display":
                    cache.display();
                    break;
                default:
                    System.out.println("Unknown command");
            }
        }

        sc.close();
        System.out.println("Exiting LRU cache.");
    }
}