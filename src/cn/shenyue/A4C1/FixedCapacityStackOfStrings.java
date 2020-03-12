package cn.shenyue.A4C1;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

/**
 * 定容栈， 容量固定的字符串栈的抽象数据类型
 */
public class FixedCapacityStackOfStrings {
    private String[] a;
    private int N;

    public FixedCapacityStackOfStrings(int cap) {
        a = new String[cap];
        N = 0;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return  N;
    }

    public void push(String item) {
        a[N++] = item;
    }

    public String pop() {
        return a[--N];
    }

    public static void main(String[] args) {
        FixedCapacityStackOfStrings s;
        s = new FixedCapacityStackOfStrings(10);
        while(!StdIn.isEmpty()) {
            String item = StdIn.readString();
            if(!item.equals("-"))
                s.push(item);
            else if(!s.isEmpty())
                StdOut.print(s.pop() + " ");
        }
        StdOut.println("(" + s.size() + " left on stack" + Arrays.toString(s.a));
    }
}
