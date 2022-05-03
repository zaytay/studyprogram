package sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CompartTest {


    public static void main(String[] args) {
        List<Long> idList=new ArrayList<Long>();
        idList.add(1L);
        idList.add(-3L);
        idList.add(15L);
        idList.add(6L);
        Collections.sort(idList,absComparator);
        System.out.println(idList);
    }

    // comparator that sorts by absolute value, putting highest first
    private static Comparator<Long> absComparator = new Comparator<Long>() {
        public int compare(Long o1, Long o2) {
            long l1 = Math.abs(o1);
            long l2 = Math.abs(o2);
            if (l1 >l2) return -1;
            if (l1 < l2) return 1;
            return 0;
        }
    };


}
