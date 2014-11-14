package algorithms;

/**
 * Created with IntelliJ IDEA.
 * User: zhengxuetong
 * Date: 14-5-12
 * Time: 上午9:23
 * To change this template use File | Settings | File Templates.
 */
public class SortTest {
    public static void main(String args[]){
        int a[] ={1,9,7,3,6,8,5};
        //insertSort(a);
        //BubbleSort(a);
        shellSort(a);
        // _quickSort(a,0,a.length-1);
        printArray(a);
    }

    /**
     * InsertSort
     * @param source
     */
    public static void insertSort(int[] source){
        int len=source.length;
        for(int i=1;i<len;i++){
            //寻找当前位置的前一个位置数据
            int j=i-1;
            //保存当前位置数据
            int temp=source[i];
            //逐个比较，找到比当前位置数据大的数据的位置
            while (j >= 0 && source[j]>temp ){
                //找到大于的数据后向后移动位置
                source[j+1]=source[j];
                j--;
            }
            source[j+1]=temp;
        }

    }

    /**
     * shell sort
     * @param source
     */
    public static  void shellSort(int[] source){
        int len=source.length;
        int d=len/2;
        //增量条件设置
        while (d>0){
            //增量范围循环
            for(int i=0; i<d ; i++){
                //每一个增量内进行插入排序
                for(int j=i+d;j<len;j=j+d){
                    //寻找比较的前一个节点
                    int k=j-d;
                    //为temp找到合适的位置
                    int temp=source[j];
                    //满足条件判定
                    while (k>=0 && source[k]>temp){
                        source[k+d]=source[k];
                        k=k-d;
                    }
                    source[k+d]=temp;
                }
            }
            d=d/2;
        }
    }

    //简单选择排序


    /**
     * 冒泡排序
     * @param source
     */
    public static void BubbleSort(int[] source){
        int len=source.length;

        for(int j=len-1;j > 0 ;j--){
            boolean endFlag = true;
            for(int i=0;i<j;i++){
                int temp=source[i];
                if(temp>source[i+1]){
                    source[i]=source[i+1];
                    source[i+1]=temp;
                    endFlag = false;
                }
            }
            if(endFlag){
                break;
            }
        }
    }

    /**
     * 快速排序
     * @param start
     * @param end
     * @param a
     */
    public static void quickSort(int start,int end,int a[]){

        if(start<end){
            int i=start;
            int j=end;
            int temp=a[i];   //选择第一个点作为中轴
            while (i<j){
                while (temp<=a[j] && i<j) {
                    j--;
                }
                a[i]=a[j];

                while (temp>=a[i] && i<j) {
                    i++;
                }
                a[j]=a[i];
            }
            a[i]=temp;

            quickSort(start,i-1,a);
            quickSort(i+1,end,a);
        }

    }




    public static void printArray(int a[]){
        for(int i:a){
            System.out.println(i);
        }
    }


}
