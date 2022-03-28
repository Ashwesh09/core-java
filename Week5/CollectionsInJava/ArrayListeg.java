package Week5.CollectionsInJava;

import java.util.*;

public class ArrayListeg {
    public static void main(String[] args) {
        List<Character> list = new ArrayList<>();
        list.add('a');
        list.add('A');
        list.add('5');
        list.add('Z');
        System.out.println("List l is:");
        Collections.sort(list, Collections.reverseOrder());
        list.forEach(c -> System.out.print(c + " "));
        System.out.println();
        SortedSet<Integer> set= new TreeSet<>();
        for (Character c : list)
            set.add(Integer.valueOf(c));
        System.out.println("Set s is:");
        set.forEach(c -> System.out.print(c + " "));
        Collections.sort(list, Collections.reverseOrder());
        System.out.println("\nAfter sorting in reverse order");
        System.out.println(set);
    }
}