package Week5.CollectionsInJava;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MergerMaps {
    public static void main(String[] args) {
        Map<Integer, String> m1 = new HashMap<>();
        m1.put(1, "A");
        m1.put(2, "B");

        Map<Integer, String> m2 = new HashMap<>();
        m2.put(1, "C");
        m2.put(2, "D");
        Map<Integer, List<String>> mergedMap = Stream.concat(m1.entrySet().stream(), m2.entrySet().stream())
                .collect(
                        Collectors.groupingBy(Map.Entry::getKey,
                                Collectors.mapping(Map.Entry::getValue, Collectors.toList())));

        System.out.println(mergedMap);
    }
}
