package stream;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamPerTest {
    public static void main(String[] args) {
        List<Long> idList = new ArrayList<>();
        for(long i=0;i<15000;i++){
            idList.add(i);
        }
        CompletableFuture<List<Long>> ret1 = CompletableFuture.completedFuture(idList);
        List<CompletableFuture<List<Long>>> recallFutureList = List.of(ret1);
        for(int i=0;i<1000;i++){
            List<Long> adIdList2  = recallFutureList.stream().map(CompletableFuture::join).flatMap(Collection::stream).distinct().collect(Collectors.toList());
        }

        //test 1
        List<Long> costList= new ArrayList<>();
        long start = System.currentTimeMillis();
        int roundNum=10;
        for(int round=0;round<roundNum+1;round++){
            long time = System.currentTimeMillis();
            for(int i=0;i<1000;i++){
                List<Long> adIdList2  = recallFutureList.stream().map(CompletableFuture::join).flatMap(Collection::stream).distinct().collect(Collectors.toList());
            }
            long cost = System.currentTimeMillis()-time;
            if(round !=0){
                costList.add(cost);
            }
        }
        long totalCost = System.currentTimeMillis()-start;
        double avg=costList.stream().mapToLong(a->a).average().orElse(0);
        System.out.println("total avg:"+(totalCost/roundNum));
        System.out.println("costList:"+costList);
        System.out.println("cost avg:"+avg);

        //test2
        List<Long> costList2= new ArrayList<>();
        long start2 = System.currentTimeMillis();
        int roundNum2=10;
        for(int round=0;round<roundNum+1;round++){
            long time = System.currentTimeMillis();
            for(int i=0;i<1000;i++){
                Set<Long> adIdList2  = recallFutureList.stream().map(CompletableFuture::join).flatMap(Collection::stream).collect(Collectors.toSet());
                //List<Long> idlist = new ArrayList<>(adIdList2);
            }
            long cost = System.currentTimeMillis()-time;
            if(round !=0){
                costList2.add(cost);
            }
        }
        long totalCost2 = System.currentTimeMillis()-start2;
        double avg2=costList2.stream().mapToLong(a->a).average().orElse(0);
        System.out.println("total2 avg:"+(totalCost2/roundNum2));
        System.out.println("costList2:"+costList2);
        System.out.println("cost avg2:"+avg2);

        //test3
        //test2
        List<Long> costList3= new ArrayList<>();
        long start3 = System.currentTimeMillis();
        int roundNum3=10;
        for(int round=0;round<roundNum3+1;round++){
            long time = System.currentTimeMillis();
            for(int i=0;i<1000;i++){
                List<Long> adIdList3  = recallFutureList.stream().map(CompletableFuture::join).flatMap(Collection::stream).collect(Collectors.toList());
                List<Long> adIdList4 = new ArrayList<>(new LinkedHashSet<>(adIdList3));
            }
            long cost = System.currentTimeMillis()-time;
            if(round !=0){
                costList3.add(cost);
            }
        }
        long totalCost3 = System.currentTimeMillis()-start3;
        double avg3=costList3.stream().mapToLong(a->a).average().orElse(0);
        System.out.println("total3 avg:"+(totalCost3/roundNum3));
        System.out.println("costList3:"+costList3);
        System.out.println("cost avg3:"+avg3);

    }

}
