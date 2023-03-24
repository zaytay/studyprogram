package performance;

import java.util.*;

public class BitSetTest {
    public static void main(String[] args) {
        List<Integer> arr=new ArrayList<>(10);
        System.out.println(arr.isEmpty());
        int b = 1 << 34;
        System.out.println(b);
        bitsetbuild();
    }
    private static void bitsetbuild(){
        //build adIdList
        Long[] arr=generateRandomArray(50000,200000);
        List<Long> adIdArray=Arrays.asList(arr);
        //Collections.sort(adIdArray);
        //build targeIds
        Set<Long> targetIds =new HashSet<>();
        for(int i=0;i<100000;i++){
            targetIds.add(Long.valueOf(i));
        }
        int testSize=10;
        Long sum=0L;
        for(int i=0;i<testSize;i++){
            sum+=buildBitSetCost(targetIds,adIdArray,10000);
        }
        System.out.println("build bitset cost:"+(sum/testSize));
    }
    private static Long buildBitSetCost(Set<Long> targetIds,List<Long> adIdArray,int round){
        Long begin = System.currentTimeMillis();
        for(int i=0;i<round;i++){
            BitSet bitSet=new BitSet(adIdArray.size());
            for(int j=0;j<adIdArray.size();j++){
                if(targetIds.contains(adIdArray.get(j))){
                    bitSet.set(j);
                }
            }
        }
        Long end=System.currentTimeMillis();
        return end-begin;
    }

    private static Long[] generateRandomArray(int len,int max){
        Long[] arr=new Long[len];
        for(int i=0;i<arr.length;i++){
            arr[i]=(long)(Math.random()*max);
        }
        return arr;
    }


    private static Long buildBitSetCost(Set<Long> targetIds,long[] adIdArray,int round){
        Long begin = System.currentTimeMillis();
        for(int i=0;i<round;i++){
            BitSet bitSet=new BitSet(adIdArray.length);
            for(int j=0;j<adIdArray.length;j++){
                if(targetIds.contains(adIdArray[j])){
                    bitSet.set(j);
                }
            }
        }
        Long end=System.currentTimeMillis();
        return end-begin;
    }




    private static void intersect(){
        HashSet<Long> annIds=new HashSet<Long>();
        for(int i=0;i<20000;i++){
            annIds.add((Long.valueOf(i)));
        }
        List<Long> targetIds =new LinkedList<Long>();
        for(int i=0;i<30000;i++){
            targetIds.add(Long.valueOf(i));
        }
        Collections.shuffle(targetIds);
        System.out.println("begin test");
        int testSize=10;
        Long sum=0L;
        for(int i=0;i<testSize;i++){
            sum+=costComp(targetIds,annIds,10000);
        }
        System.out.println("intersect avg cost:"+(sum/testSize));
    }



    private static Long costComp(List<Long> targetIds,HashSet<Long> annIds,int round){
        Long begin = System.currentTimeMillis();
        for(int i=0;i<round;i++){
            List<Long> ret =new ArrayList<>();
            for(Long item : targetIds){
                if(annIds.contains(item)){
                    ret.add(item);
                }
            }
        }
        Long end=System.currentTimeMillis();
        return end-begin;
    }













}
