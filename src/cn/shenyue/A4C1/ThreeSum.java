package cn.shenyue.A4C1;

/**
 * 在N个数中找出三个和为0的整型元祖的数量
 * T(N) ~ aN^3
 */
public class ThreeSum {
    public static int count(int[] a) {
        int N = a.length;
        int cnt = 0;
        for(int i=0; i<N; i++) {
            for(int j=i+1; j<N; j++) {
                for(int k=j+1; k<N; k++) {
                    if(a[i] + a[j] + a[k] == 0)
                        cnt++;
                }
            }
        }

        return  cnt;
    }
}
