package day1;

import java.util.HashMap;
import java.util.Objects;
import java.util.Random;

/**
 * @author MrkWinter
 * @version 1.0
 */
/*
解题思路 使用hashmap 和 链表结构维护缓存
 */
public class LRUCache2 {
    public static void main(String[] args) {
        LRUCache2 lRUCache = new LRUCache2(2);
        lRUCache.put(1, 1); // 缓存是 {1=1}
        lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
        lRUCache.get(1);    // 返回 1
        lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
        lRUCache.get(2);    // 返回 -1 (未找到)
        lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
        lRUCache.get(1);    // 返回 -1 (未找到)
        lRUCache.get(3);    // 返回 3
        lRUCache.get(4);    // 返回 4
    }

    private Node head = new Node(0);
    private Node lastNode;
    private HashMap<Integer, Node> hashMap;
    private int capacity;

    public LRUCache2(int capacity) {
        hashMap = new HashMap<Integer, Node>(capacity);
        this.capacity = capacity;
    }

    public int get(int key) {
        Node node = hashMap.get(key);
        if (node != null) {
            if (node == lastNode && node.front != head)
                lastNode = lastNode.front;
            node.del();
            head.insertNext(node);
            return node.value;
        }
        return -1;
    }

    public void put(int key, int value) {
        Node node = hashMap.get(key);
        if (node != null) {
            if (node == lastNode && node.front != head)
                lastNode = lastNode.front;
            node.del();
            node.value = value;
            head.insertNext(node);
        } else {
            Node temp = new Node(value);
            hashMap.put(value, temp);
            if (hashMap.size() <= capacity) {
                head.insertNext(temp);
                if (lastNode == null)
                    lastNode = temp;
            } else {
                Node temp2 = lastNode;
                lastNode.del();
                hashMap.remove(lastNode.value);
                lastNode = temp2.front;
            }
        }
    }
}

class Node {
    public Node front;
    public Node next;
    public int value;

    public Node(int value) {
        this.value = value;
    }

    public Node del() {
        if (this.next == null) {
            this.front.next = null;
        } else {
            this.front.next = this.next;
            this.next.front = this.front;
        }
        return this;
    }

    public void insertNext(Node node) {
        if (this.next != null) {
            node.front = this;
            node.next = this.next;
            this.next.front = node;
            this.next = node;
        } else {
            this.next = node;
            node.front = this;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node node = (Node) o;
        return value == node.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}