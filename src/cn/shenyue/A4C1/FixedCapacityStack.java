package cn.shenyue.A4C1;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * 定容栈 泛型版本
 * @param <T>
 */
public class FixedCapacityStack<T> {
    private T[] a;
    private int N;

    public FixedCapacityStack(int cap) {
        a = (T[]) new Object[cap];
        N = 0;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return  N;
    }

    public void push(T item) {
        a[N++] = item;
    }

    public T pop() {
        return a[--N];
    }

    public static void main(String[] args) {
        FixedCapacityStack<String> s;
        s = new FixedCapacityStack<>(100);
        while(!StdIn.isEmpty()) {
            String item = StdIn.readString();
            if(!item.equals("-"))
                s.push(item);
            else if(!s.isEmpty())
                StdOut.print(s.pop() + "　");
        }
        StdOut.println("(" + s.size() + " left on stack");
    }
}
