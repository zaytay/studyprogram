package MultiThread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by zhengxuetong on 2016/11/7.
 */
public class SubThread  implements Callable<Object>{
    public Object call() throws Exception {
        System.out.println("-----subThread start-------");
        ExecutorService executorService= Executors.newFixedThreadPool(10);
        int a=10;
        executorService.submit(new LowerSubThread());
        Thread.sleep(1000);
        System.out.println("-----subThread end --------");
        return null;
    }
}
