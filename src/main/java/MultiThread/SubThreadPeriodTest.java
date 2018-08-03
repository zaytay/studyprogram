package MultiThread;


import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Created by zhengxuetong on 2016/11/7.
 */
public class SubThreadPeriodTest {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService= Executors.newFixedThreadPool(10);
        /*Future<Object> future=executorService.submit(new Callable<Object>() {
            public Object call() throws Exception {
                System.out.println("subThread begin");
                ExecutorService executorService2= Executors.newFixedThreadPool(10);
                executorService2.submit(new Callable<Object>() {
                    public Object call() throws Exception {
                        System.out.println("lower subThread begin");
                        Thread.sleep(10000);
                        System.out.println("lower subThread end");
                        return null;
                    }
                });
                Thread.sleep(1000);
                System.out.println("subThread end");
                return null;
            }
        });
        System.out.println("begin get");
        future.get();
        System.out.println("finish job");*/

        Future<Object> future=executorService.submit(new SubThread());
        System.out.println("---begin invoke future get----");
        future.get();
        System.out.println("----end main thread");


    }
}
