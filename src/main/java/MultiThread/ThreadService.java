package MultiThread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by zhengxuetong on 2015/9/14.
 */
public class ThreadService {
    private ExecutorService executorService;
    private static ThreadService instance =new ThreadService();

    private ThreadService(){
        int size=Runtime.getRuntime().availableProcessors()*1;
        System.out.println("core size is:" + size);
        executorService = Executors.newFixedThreadPool(size);
    }

    public static ThreadService getInstance(){
        return instance;
    }

    public void execute(Runnable runnable){
        executorService.execute(runnable);
    }

    public boolean  awaitTermination(long timeout, TimeUnit unit) throws InterruptedException {
        return executorService.awaitTermination(timeout,unit);
    }
    public void shutdown(){
        executorService.shutdown();
    }

    public boolean isTerminated(){
        return executorService.isTerminated();
    }

}