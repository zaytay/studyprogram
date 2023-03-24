package MultiThread;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class CompletableFutureTest {
    private static final ThreadPoolExecutor executor = new ThreadPoolExecutor(10, 10, 10, TimeUnit.SECONDS, new LinkedBlockingQueue<>(100), new ThreadPoolExecutor.CallerRunsPolicy());
    // private static final List<Integer> resultList = new ArrayList<>();
    private static final List<Integer> resultList = Collections.synchronizedList(new ArrayList<>());
    private static final List<CompletableFuture<Integer>> futureList = new ArrayList<>();


    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        try {
            doSomething(executor, resultList, futureList);
        } catch (Exception e) {
            System.out.println("main 处理了异常 -> " + e.getMessage());
        }
        System.out.println("resultlist:"+resultList);
        System.out.println("方法执行时间: " + (System.currentTimeMillis() - start));
        System.out.println("main 执行完了...");
        executor.shutdown();
    }


    private static void doSomething(ThreadPoolExecutor executor, List<Integer> resultList, List<CompletableFuture<Integer>> futureList) {
        for (int i = 0; i < 10; i++) {
            int finalI = i;
            System.out.println("提交任务"+finalI);
            CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> {
                try {
                    System.out.println("开始执行任务- -> " + finalI);
                    Thread.sleep(finalI * 1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (finalI == 2) {
                    try {
                        Thread.sleep(10000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                if (finalI == 4) {
                    System.out.println("业务异常... -> " + finalI);
                    throw new RuntimeException("业务异常... -> " + finalI);
                }
                System.out.println("任务- -> " + finalI+"结束");
                return finalI;
            }, executor)./*thenApply(r->{
                System.out.println("2阶段- -> " + finalI);
                resultList.add(r);
                return r;
            });*/

                    handle((result, e) -> {
                if (e != null) {
                    System.out.println("CompletableFuture处理异常 -> " + e.getMessage());
                    throw new RuntimeException("CompletableFuture处理异常 -> " + e.getMessage());
                }
                resultList.add(result);
                return result;
            });
            futureList.add(future);
        }
        System.out.println("begin allof");
        AtomicInteger i= new AtomicInteger();
        CompletableFuture<Void> completableFuture = CompletableFuture.allOf(futureList.toArray(new CompletableFuture[0]));
        completableFuture.thenApply(r->futureList.stream().map(f->{
            System.out.println("beigin join "+ i.getAndIncrement());
            return f.join();
        }).collect(Collectors.toList())).join();
        System.out.println("end allof");
        if (completableFuture.isCompletedExceptionally()) {
            System.out.println("find exception");
            //throw new RuntimeException("sdfsd");
        } else {
            System.out.println("begin collect");
/*
            resultList.addAll(futureList.stream().map(r->{
                System.out.println("beigin join "+ i.getAndIncrement());
                return r.join();
            }).collect(Collectors.toList()));
*/
            System.out.println("end collect");
        }
        System.out.println("tasksdf");
        System.out.println(resultList.size());
        System.out.println(resultList);
    }




}
