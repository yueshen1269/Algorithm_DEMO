package cn.shenyue.A4C1;

import java.util.Iterator;

public class Bag<T> implements Iterable<T> {
    private Node first;
    private int N;

    private class Node {
        T item;
        Node next;
    }
    public boolean isEmpty() {
        return first == null;
    }
    public int size() {
        return N;
    }
    public void add(T item) {
        Node oldfirst = first;
        first = new Node();
        first.item = item;
        first.next = oldfirst;
        N++;
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
}
