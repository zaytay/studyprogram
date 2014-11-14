package knowledge;

/**
 * Created with IntelliJ IDEA.
 * User: zhengxuetong
 * Date: 14-5-16
 * Time: 下午5:04
 * To change this template use File | Settings | File Templates.
 */
public class ParamterTest {

    public static void main(String args[]){
        String test="a";
        StringBuffer test2=new StringBuffer("p");
        changeStr(test);
        System.out.println(test);
        changeStr2(test2);
        System.out.println(test2);
    }

    private static void changeStr(String a){
        a="b";
    }

    private static void changeStr2(StringBuffer a){
        a=a.append("b");
        a=new StringBuffer("c");
        a.append("d");
    }




}
