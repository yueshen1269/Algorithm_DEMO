package cn.shenyue.A4C1;

public class Exercise1_1 {
    public static void main(String[] args) {
//        ex6();
//        ex8();
//        System.out.println(ex9(50));
        boolean[][] a = {{true, false}, {false, true}};
//        ex11(a);
        ex13(a);
    }


    public static void ex6() {
        int f = 0;
        int g = 1;
        for(int i=0; i<=15; i++) {
            System.out.println(f);
            f = f + g;
            g = f - g;
        }
    }

    public static void ex8() {
        System.out.println('b');
        System.out.println('b' + 'c');
        System.out.println((char)('a' + 4));
    }

    /**
     * 将正整数N用二进制表示并转换为一个String，即Integer.toBinaryString(N)
     * @param N
     * @return
     */
    public static String ex9(int N) {
        String s = "";
        for(int n=N; n>0; n /= 2) {
            s = (n%2) + s;
        }
        return s;
    }

    public static String toBinaryString(int value) {
        if (value == 0) {
            return "0";
        }
        int bufLen = 32;
        int index = bufLen;
        char[] result = new char[bufLen];
        do {
            // 使用 & 符合相对除 2 提升一定性能
            result[--index] = (char)('0' + (value & 1));
            value = value >>> 1;
        } while (value != 0);
        return new String(result, index, bufLen - index);
    }

    public static void ex11(boolean[][] matrix) {
        System.out.print(' ');
        for(int i=0; i<matrix[0].length; i++) {
            System.out.print(i);
        }
        System.out.println();
        for(int j=0; j<matrix.length; j++) {
            System.out.print(j);
            for(int k=0; k<matrix[j].length; k++) {
                System.out.print(matrix[j][k] == true ? "*" : " ");
            }
            System.out.println();
        }
    }

    public static void ex13(boolean[][] a) {
        for(int i=0; i<a.length; i++) {
            for(int j=0; j<a[i].length; j++) {
                System.out.printf("%6b", a[j][i]);
            }
            System.out.println();
        }
    }
}
