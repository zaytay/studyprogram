/**
 * Created with IntelliJ IDEA.
 * User: zhengxuetong
 * Date: 14-9-25
 * Time: 下午4:00
 * Desc:
 */
public class KmpStudy {
    public static void main(String args[]){
        String s="abcdabcaedfeabcabefjkl";
        String p="abcabef";

        char[] sArray=s.toCharArray();
        char[] pArray=p.toCharArray();
        int next[]=getNextArray(pArray);
        printArray(next);
        int ret=kmpJudge(sArray,pArray,next);
        System.out.println("ret:"+ret);
    }

    public static int kmpJudge(char[] s,char[] p,int[] next){
        int i=0;
        int j=0;

        while (i<s.length && j<p.length){
            if(j==-1 || s[i]==p[j]){
                i++;
                j++;
            } else {
                j=next[j];
            }
        }
        if(j==p.length){
            return i-j;
        } else {
            return -1;
        }
    }

    public static int[] getNextArray(char[] p){
        int len = p.length;
        int[] next = new int[len];
        //初始值-1相当于一个标志
        next[0] = -1;

        int k = -1;
        int j = 0;

        while (j < len-1){
            //k==-1 条件作为初始的入口
            if (k == -1 || p[k] == p[j]){
                next[j+1]=k+1;
                k++;
                j++;
               //next[j]=k;
            }else {
                k = next[k];
            }
        }
        return next;
    }




    public static void printArray(int [] a){
        for(int i:a){
            System.out.print(i);
        }
    }



}
