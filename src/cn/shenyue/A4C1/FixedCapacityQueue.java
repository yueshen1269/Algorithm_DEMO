package cn.shenyue.A4C1;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;

/**
 * 循环队列
 * first指向首元素，last指向尾元素的下一个位置
 * 队列为空条件 first == last
 * 队列为满条件 1. last + 1 % maxSize = first; (牺牲一个存储单元来区分队空和队满）
 *            2. 判断 队列长度是否等于MaxSize
 *
 * @param <T>
 */
public class FixedCapacityQueue<T> implements Iterable<T> {
    private int first = 0;
    private int last = 0;
    private int intiSize = 20;
    private T[] a = (T[]) new Object[intiSize];
    // 不设置长度N

    public int size() {
        return (last - first + intiSize) % intiSize;
    }

    public boolean isEmpty() {
        return first == last;
    }

    public boolean enqueue(T item) {
        if((last + 1) % intiSize == first) {
            return  false;
        }
        a[last] = item;
        last = (last + 1) % intiSize;
        return true;
    }

    public T dequeue() {
        T item = a[first];
        first = (first + 1) % intiSize;
        return item;
    }

    public Iterator<T> iterator() {
        return new QueueIter();
    }

    private class QueueIter implements Iterator<T> {
        private int n = size();
        private int f = first;

        public boolean hasNext() {
            return n != 0;
        }

        public T next() {
            T ne = a[f];
            f = (f + 1) % intiSize;
            n--;
            return ne;
        }

        public void remove() {}
    }

    public static void main(String[] args) {
        FixedCapacityQueue<String> q = new FixedCapacityQueue<>();
        while(!StdIn.isEmpty()) {
            String item = StdIn.readString();
            if(!item.equals("-"))
                q.enqueue(item);
            else if(!q.isEmpty())
                StdOut.print(q.dequeue() + "　");
        }
//        for(String i : q) StdOut.println(i);
        Iterator<String> i = q.iterator();
        while(i.hasNext()) {
            String s = i.next();
            StdOut.println(s);
        }

        StdOut.println("(" + q.size() + " left on queue)");

    }
}
