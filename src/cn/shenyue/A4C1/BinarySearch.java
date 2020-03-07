package cn.shenyue.A4C1;

public class BinarySearch {

    public static void main(String[] args) {
        int key = 3;
        int[] a = {1,2,3,4,5,6};
        System.out.println(rank(key, a));
        System.out.println(rank2(key, a));
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
