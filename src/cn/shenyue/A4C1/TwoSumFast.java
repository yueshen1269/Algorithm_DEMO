package cn.shenyue.A4C1;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * TwoSum： ThreeSum的简化版本，找出一个输入文件中所有和为0的整数对的数量
 * 简单起见，假设所有整数均不相同
 * 1. T(N) ~ aN^2 将ThreeSum aN^3算法中的循环减少一个
 * 2. 改进算法： 当且仅当-a[i]存在于数组中，且a[i] 非0时， a[i]存在于某个和为0的数组对中
 *      1. 首先对数组排序（为二分查找做准备）
 *      2. 然后对数组中的每个a[i],二分查找-a[i],如果结果为j并且j>i,就将计数器加一
 *      查找的三种情况：
 *      1. 二分查找失败，返回-1，不增加计数器
 *      2. 二分查找成功，并且返回的j>i,则将计数器加一
 *      3. 二分查找成功，但返回的j<=i,不增加计数器，避免重复计数
 *    算法时间 T(N) ~ NlogN
 *
 */
public class TwoSumFast {
    public static int count(int[] a) {
        Arrays.sort(a);
        int N = a.length;
        int cnt = 0;
        for(int i=0; i<N; i++) {
            if(BinarySearch.rank(-a[i], a) > i)
                cnt++;
        }
        return cnt;
    }
}
