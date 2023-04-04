package stream;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamTest {
    public static void main(String[] args) {
        Map<Long,String> id2Data = new HashMap<Long,String>();
        id2Data.put(1L,"1");
        id2Data.put(2L,"2");
        id2Data.put(3L,"3");
        id2Data.put(4L,"4");
        List<Long> idList = new ArrayList<>();
        idList.add(1L);
        idList.add(3L);
        idList.add(8L);

        List<String> idStrs = idList.stream().map(id2Data::get).filter(Objects::nonNull).collect(Collectors.toList());
        System.out.println(idStrs);



        Stream<String> language = Stream.of("java", "python", "node", null, "ruby", null, "php");
        Stream<String> language2 = Stream.of("java", "python", "node", null, "ruby", null, "php");
        List<String> result1 = language.collect(Collectors.toList());
        List<String> result2 = language2.filter(Objects::nonNull).collect(Collectors.toList());
        System.out.println(result1);
        System.out.println(result2);
    }

}
