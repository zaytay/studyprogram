/**
 * Created with IntelliJ IDEA.
 * User: zhengxuetong
 * Date: 14-10-14
 * Time: 下午3:07
 * Desc:单词转换  转换规则：apple-》a4，ap3，app1e，appl1,4e ，输出所有转换的形式
 * 思想：将单词转换同等长度位数的二进制数，二进制数中0就输出字母，1则为数字，与后面数字相加，直到遇到0为止，最后输出数字
 */
public class CharacterConvert {
    public static void main(String args[]){
        String str="apple";
        char a[]=str.toCharArray();
        convertCharacter(a);
    }

    public static void convertCharacter(char a[]){

        int len=a.length;
        //定义转换范围
        int bitMap= 1<<len;

        for(int i=0;i<bitMap;i++){
            int num=0;

            for(int j=0;j<len;j++){
                //数字按位与，如果flag为0，代表当前第j位上二进制数为0
                int flag=i & (1<<j);
                if(flag == 0){
                    if (num>0){
                        System.out.print(num);
                    }
                    System.out.print(a[j]);
                    num=0;
                }else {
                    num++;
                }
            }
            if(num>0){
                System.out.print(num);
            }
            System.out.println("------"+i);

        }
    }






}
