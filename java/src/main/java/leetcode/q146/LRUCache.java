package q146;


import java.util.HashMap;


/**
 * 双向链表 + map 实现LRU
 */
public class LRUCache {

    private  int capacity;
    private HashMap<Integer, Node> map = new HashMap();
    private  Node head, tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.head = new Node();
        this.tail = new Node();
        //构建虚拟头部,可以避免节点挂载头部或者尾部的时候还要判断自己是不是头部和尾部,避免成环
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        Node node = map.get(key);
        if (node == null) {
            return -1;
        }

        //将该节点的前节点和该节点的后节点连起来
        connectPrevAndNext(node);

        //将该节点放到头部
        moveNodeToHead(node);

        return node.value;
    }

    public void put(int key, int value) {
        Node node = map.get(key);
        if (node != null) {
            //不等于空覆盖并且将该节点提到最前面
            node.value = value;
            connectPrevAndNext(node);
            moveNodeToHead(node);
        } else {
            //创建一个节点放到头结点,并且判断是否超过了容量
            Node newNode = new Node(key, value);
            if (map.size() == capacity) {
                //已经最大容量了删除尾部
                map.remove(tail.prev.key);
                tail.prev.prev.next = tail;
                tail.prev = tail.prev.prev;
            }
            map.put(key,newNode);
            moveNodeToHead(newNode);
        }

    }

    /**
     * 将某一个节点的前节点和后节点连接
     * node 不为 null 且前后节点也不为 null
     *
     * @param node
     */
    private void connectPrevAndNext(Node node) {
        node.next.prev = node.prev;
        node.prev.next = node.next;
    }

    /**
     * 将该节点放到头部
     *
     * @param node
     */
    private void moveNodeToHead(Node node) {
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }


}

class Node {
    int key;
    int value;
    Node next;
    Node prev;


    public Node(int key, int value) {
        this.key = key;
        this.value = value;
    }

    public Node() {
    }
}


