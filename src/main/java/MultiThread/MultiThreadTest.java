package MultiThread;

import java.util.concurrent.CountDownLatch;

/**
 * Created by zhengxuetong on 2015/9/14.
 */
public class MultiThreadTest {

    public static void main(String args[]) throws InterruptedException {
        System.out.println("begin Test multiThread");
        final CountDownLatch countDownLatch=new CountDownLatch(10);
        for(int i=0;i<10;i++){
            final int k=i;
            ThreadService.getInstance().execute(new Runnable() {
                public void run() {
                    try {
                        System.out.println(Thread.currentThread().getName() + "   work-" + k + ":begin sleep");
                        Thread.sleep(1000);
                        System.out.println(Thread.currentThread().getName() + "   work-" + k + ":end sleep" + " countdown:" + countDownLatch.getCount());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                        countDownLatch.countDown();
                    }
                }
            });
        }
        countDownLatch.await();
        System.out.println("end for method ");
        //ThreadService.getInstance().shutdown();
        /*while(true){
            System.out.println("----judge -----");
            if(ThreadService.getInstance().isTerminated()){
                System.out.println("���е����̶߳������ˣ�");
                break;
            }
        }*/

        /*try {
            boolean loop=true;
            do{
                loop=!ThreadService.getInstance().awaitTermination(2, TimeUnit.SECONDS);
            }while (loop);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
       /* try {
            System.out.println("begin await");
            ThreadService.getInstance().awaitTermination(1, TimeUnit.MINUTES);
            System.out.println("end await");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        System.out.println("main thread continue");
    }



}
