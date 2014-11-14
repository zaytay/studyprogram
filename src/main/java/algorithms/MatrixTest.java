package algorithms;

/**
 * Created with IntelliJ IDEA.
 * User: zhengxuetong
 * Date: 14-5-29
 * Time: 下午2:33
 * Desc:矩阵相乘算法
 */
public class MatrixTest {

    public static void main(String args[]){
        int[][] mn={{1,2,3,1,1},{1,2,1,2,1}};
        int[][] np={{1,2,3},{1,2,3},{1,2,3},{1,2,3},{1,2,3}};

        //
        int m=mn.length;
        int n=mn[0].length;
        int n1=np.length;
        int p=np[0].length;
        int[][] mp;
        mp=new int[m][];
        for(int i=0;i<m;i++){
            mp[i]=new int[p];
            for(int j=0;j<p;j++){
                mp[i][j]=score(i,j,mn,np,n);
            }
        }
        printArray(mp);
    }


    public static int score(int row,int col,int[][] a,int[][] b,int n){
        int sum=0;
        for(int i=0;i<n;i++){
            sum+=a[row][i]*b[i][col];
        }
        return sum;
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








}
