package cn.shenyue.A4C1;

import java.util.Arrays;

/**
 * ThreeSum的快速算法，假设所有整数均不相同，当且仅当-(a[i] + a[j])在数组中
 * T(N) ~ N^2logN
 */
public class ThreeSumFast {
    public static int count(int[] a) {
        Arrays.sort(a);
        int N = a.length;
        int cnt = 0;
        for(int i=0; i<N; i++) {
            for(int j=i+1; j<N; j++) {
                if(BinarySearch.rank(-a[i]-a[j], a) > j)
                    cnt++;
            }
        }
        return cnt;
    }
}
