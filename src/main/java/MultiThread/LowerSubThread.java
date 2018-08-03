package MultiThread;

import java.util.concurrent.Callable;

/**
 * Created by zhengxuetong on 2016/11/7.
 */
public class LowerSubThread implements Callable<Object>{
    public Object call() throws Exception {
        System.out.println("-----lower subThread start-------");
        Thread.sleep(10000);
        System.out.println("-----lower subThread end --------");
        return null;
    }
}
