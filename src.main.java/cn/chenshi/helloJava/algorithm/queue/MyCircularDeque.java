package cn.chenshi.helloJava.algorithm.queue;

/**
 * @author ChenShi
 * @date 2021/6/14 下午1:20
 */
public class MyCircularDeque {

    private Node<Integer> head;
    private Node<Integer> tail;
    private int size;
    private int count;

    class Node<E> {
        E item;
        Node<E> next;
        Node<E> prev;

        Node(Node<E> prev, E element, Node<E> next) {
            this.item = element;
            this.next = next;
            this.prev = prev;
        }

        public Node() {

        }
    }

    /** Initialize your data structure here. Set the size of the deque to be k. */
    public MyCircularDeque(int k) {
        this.head = new Node<Integer>();
        this.tail = new Node<Integer>();
        head.next=tail;
        tail.prev = head;
        size = k;
        count =0;

    }

    /** Adds an item at the front of Deque. Return true if the operation is successful. */
    public boolean insertFront(int value) {
        if(count >= size){
            return false;
        }
        Node newNode = new Node<Integer>();
        newNode.next = head.next;
        head.next = newNode;
        count++;
        return true;
    }

    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
    public boolean insertLast(int value) {
        if(count >= size){
            return false;
        }
        Node newNode = new Node<Integer>();
        newNode.next = tail;
        tail.prev.next = newNode;
        count++;
        return true;
    }

    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
    public boolean deleteFront() {
        if(count < 1){
            return false;
        }
        this.head.next = this.head.next.next;
        count --;
        return true;

    }

    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
    public boolean deleteLast() {
        if(count < 1){
            return false;
        }
        this.tail.prev.prev.next = this.tail;
        count --;
        return true;

    }

    /** Get the front item from the deque. */
    public int getFront() {
        if(count < 1){
            return 0;
        }
        return this.head.next.item;
    }

    /** Get the last item from the deque. */
    public int getRear() {
        if(count < 1){
            return 0;
        }
        return this.tail.prev.item;

    }

    /** Checks whether the circular deque is empty or not. */
    public boolean isEmpty() {
        if (count< 1){
            return true;
        }
        return false;
    }

    /** Checks whether the circular deque is full or not. */
    public boolean isFull() {
        if (count == size){
            return true;
        }
        return false;
    }
}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */