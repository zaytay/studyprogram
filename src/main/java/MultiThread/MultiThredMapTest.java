package MultiThread;

/**
 * Created by zhengxuetong on 2016/5/3.
 */
public class MultiThredMapTest {
    public static void main(String args[]) throws InterruptedException {
        System.out.println("begin Test multiThread");
        //final ConcurrentHashMap<String, Integer> ipClickMap = new ConcurrentHashMap<String, Integer>();
        for(int i=0;i<10;i++){
            final int k=i;
            ThreadService.getInstance().execute(new Runnable() {
                public void run() {
                        System.out.println(Thread.currentThread().getName() + "   work-" + k + ":begin sleep");
                    try {
                        Thread.sleep(10000L);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
        ThreadService.getInstance().shutdown();
        System.out.println("end for method ");
        System.out.println("main thread continue");
    }

}
