package cn.shenyue.A4C1;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;

/**
 * 队列的链式存储结构
 * 头指针first 指向头元素，尾指针last 指向尾元素
 * 初始状态： first == null last == null
 * 一个元素： first == last first != null
 * enqueue: 判断链表是否为空，如果为空，则 first = last = new Node()，链表长度加一
 * dequeue: first = fist.next后， 若first == null，说明此时链表为空，则 last = null, 链表长度减一
 * @param <T>
 */
public class Queue<T> implements Iterable<T> {
    private Node first;
    private Node last;
    private int N;

    private class Node {
        T item;
        Node next;
    }

    public int size() {
        return N;
    }
    public boolean isEmpty() {
        return first == null;
    }
    public void enqueue(T item) {
        // 向标尾添加元素
        Node oldlast = last;
        last = new Node();
        last.item = item;
        last.next = null;
        if(N == 0) {
            first = last;
        }else {
            oldlast.next = last;
        }
        N++;
    }
    public T dequeue() {
        // 表头删除元素
        T item = first.item;
        first = first.next;
        if(isEmpty()) last = null;
        N--;
        return item;

    }
    public Iterator<T> iterator() {
        return new ListIterator();
    }
    private class ListIterator implements Iterator<T> {
        private Node current = first;
        public boolean hasNext() {
            return current != null;
        }
        public void remove(){
        }
        public T next() {
            T item = current.item;
            current = current.next;
            return item;
        }
    }

    public static void main(String[] args) {
        Queue<String> q = new Queue<>();
        while(!StdIn.isEmpty()) {
            String item = StdIn.readString();
            if(!item.equals("-"))
                q.enqueue(item);
            else if(!q.isEmpty())
                StdOut.print(q.dequeue() + "　");
        }
        StdOut.println("(" + q.size() + " left on queue)");
    }
}
