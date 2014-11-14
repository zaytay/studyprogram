package datastructure;

/**
 * Created with IntelliJ IDEA.
 * User: zhengxuetong
 * Date: 14-5-19
 * Time: 下午1:21
 * Desc:二维数组按特定规则打印
 */
public class ArrayTest {
    public static void main(String args[]) {
        //int[][] a=new int[4][4];
        int[][] a = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        //printArray(a);
        printSort(a);
    }


    private static void printArray(int[][] a) {

        for (int i = 0; i < a.length; i++) {
            System.out.print("[");
            for (int j = 0; j < a[i].length; j++) {
                if (j != a[i].length - 1) {
                    System.out.print(a[i][j]);
                    System.out.print(",");
                } else {
                    System.out.print(a[i][j]);
                }
            }
            System.out.println("]");
        }
    }


    private static void printSort(int[][] a) {
        int N = a.length;
        for (int line = 1; line < 2 * N; line++) {
            //
            for (int i = 0; i < N; i++) {
                int j = N + i - line;
                if (j > -1 && j < N ) {
                    if (i == N - 1 || j == N - 1) {
                        System.out.print(a[i][j]);
                        System.out.println("---" + line);
                        break;
                    } else {
                        System.out.print(a[i][j] + ",");
                    }

                }
            }
        }

    }

}

