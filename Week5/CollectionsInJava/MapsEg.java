package Week5.CollectionsInJava;

import java.util.*;


public class MapsEg {
    public static void main(String[] args) {
        Book b1 = new Book(121, "Let us C", "Yashwant Kanetkar", "BPB", 8);
        Book b2 = new Book(233, "Operating System", "Galvin", "Wiley", 6);
        Book b3 = new Book(101, "Data Communications & Networking", "Forouzan", "Mc Graw Hill", 4);
        Book b4 = new Book(121, "Let us C", "Yashwant Kanetkar", "Mc Graw Hill", 11);
        HashMap<Integer, Book> library = new HashMap<>();
        library.put(b1.id, b1);
        library.put(b2.id, b2);
        library.put(b3.id, b3);
        library.put(b4.id, b4);
        Set<Integer> s = library.keySet();
        System.out.println("== Books ==");
        library.values().stream().forEach(System.out::println);
        library.forEach((k, v) -> {v.quantity *= 2;library.put(k, v);});
        library.merge(233, library.get(233), (oB, nB) -> new Book(233, library.get(233).name, library.get(233).author,
            library.get(233).publisher + " USA", library.get(233).quantity));
        System.out.println(" ----- AFTER MERGING -----");
        library.values().stream().forEach(System.out::println);
    }
}
