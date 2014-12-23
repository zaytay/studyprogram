package knowledge;


import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhengxuetong on 2014/12/15.
 */
public class StringUtil {
    public static void main(String args[]){
        List<String> testList=new ArrayList<String>();
        testList.add("1");
        testList.add("2");
        List<String> testList2=null;
        for(String item:testList2){
            System.out.println(item);
        }

    }

    /**
     * 中英文混合字符截取
     * @param str
     * @param length
     * @return
     * desc: java中中文采用USC2编码，
     */
    public static String commonSubString(String str,int length) throws UnsupportedEncodingException {
        byte[] bytes=str.getBytes();
        int i=2; //前两个字节是标志位，从第三个字节开始截取
        int n=0; //表示当前字节数
        for(;i<bytes.length && n < length;i++ ){
            //奇数位置，如3,5,7...为USC2编码中两个字节的第二个字节
            if(i%2 == 1){
                n++;
            }else {
                //如果第一个位置上不为零，表示为中文,占两个字节
                if(bytes[i] != 0){
                    n++;
                }
            }
        }
        //截取一半的汉子保留
        if(i%2==1){
            i=i+1;
        }
        return new String(bytes,0,i,"Unicode");

    }



}
