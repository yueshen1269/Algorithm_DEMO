package cn.shenyue.A4C1;

import java.util.Random;

public class BinarySearch {

    public static void main(String[] args) {
        int key = 3;
        int[] a = {1,2,3,4,5,6};
        System.out.println(rank(key, a));
        System.out.println(rank2(key, a));
        Random random = new Random(2);
        System.out.println(random.nextInt(8));
    }

    // 非递归实现
    public static int rank(int key, int[] a) {
        int lo = 0;
        int hi = a.length - 1;
        while(lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if(key < a[mid]) hi = mid - 1;
            else if(key > a[mid]) lo = mid + 1;
            else return mid;
        }

        return -1;
    }

    // 递归实现

    /**
     *
     * @param key
     * @param a
     * @return
     * 递归的三个要素：
     *  1. 递归总有一个最简单的情况-方法的第一条语句总是一个包含return的条件语句
     *  2. 递归调用总是去舱室解决一个规模更小的子问题，这样才能收敛到最简单的情况
     *  3. 递归调用的父问题和尝试解决的子问题之间不应该有交集
     */
    public static int rank2(int key, int[] a) {
        return rank(key, a, 0, a.length-1);
    }

    public static int rank(int key, int[]a, int lo, int hi) {
        if(lo > hi) return -1;
        int mid = (lo + hi) / 2;
        if(key < a[mid]) return rank(key, a, lo, mid-1);
        else if(key > a[mid]) return rank(key, a, mid+1, hi);
        else return mid;
    }
}
