package cn.shenyue.A4C1;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;

/**
 * 栈的顺序存储结构
 * @param <T>
 */
public class ResizingArrayStack<T> implements Iterable<T> {
    private T[] a = (T[]) new Object[1];
    private int N = 0;
    public boolean isEmpty() {
        return N == 0;
    }
    public int size() {
        return N;
    }
    public void resize(int max) {
        T[] temp = (T[]) new Object[max];
        for(int i=0; i<N; i++) {
            temp[i] = a[i];
        }
        a = temp;
    }
    public void push(T item) {
        if(N == a.length) resize(2*a.length);
        a[N++] = item;
    }
    public T pop() {
        T item = a[--N];
        a[N] = null;
        if(N>0 && N == a.length/4) resize(a.length/2);
        return item;
    }
    public Iterator<T> iterator() {
        return new ReverseArrayIterator();
    }
    private class ReverseArrayIterator implements Iterator<T> {
        private int i = N;
        public boolean hasNext() {
            return i>0;
        }
        public T next() {
            return a[--i];
        }
        public void remove(){}
    }
    public static void main(String[] args) {
        ResizingArrayStack<String> s = new ResizingArrayStack<>();
        while(!StdIn.isEmpty()) {
            String item = StdIn.readString();
            if(!item.equals("-"))
                s.push(item);
            else if(!s.isEmpty())
                StdOut.print(s.pop() + " ");
        }
        for(String i: s) StdOut.println(i);
        StdOut.println("(" +  s.size() + " left on stack)");
    }
}
