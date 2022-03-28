package Week5.CollectionsInJava;

import java.util.*;
import java.util.stream.*;

public class StreamApi {
    public static void main(String[] args) {
        LinkedList<String> lili = new LinkedList<String>();
        Book b1 = new Book(121, "Let us C", "Yashwant Kanetkar", "BPB", 8);
        Book b2 = new Book(233, "Operating System", "Galvin", "Wiley", 6);
        Book b3 = new Book(101, "Data Communications & Networking", "Forouzan", "Mc Graw Hill", 4);
        Book b4 = new Book(121, "Let us C", "Yashwant Kanetkar", "Mc Graw Hill", 11);
        List<Book> library = Arrays.asList(b1, b2, b3, b4);
        Integer[] a = { 1, 2, 3, };
        Stream sarr = Stream.of(a);
        sarr.forEach(System.out::println);
        System.out.println("   ---   List of Books    --- ");
        library.forEach(System.out::println);
        Set<Book> setOfBooks = library.stream().collect(Collectors.toSet());
        System.out.println("   ----  Set of Books  ----- ");
        setOfBooks.stream().forEach(System.out::println);
        List<Book> sortedBooks = library.stream().sorted().toList();
        System.out.println(" ---- List of SORTED Books -----");
        sortedBooks.forEach(System.out::println);
        List<Book> doubleQunBook = library.stream()
                .map(b -> new Book(b.id, b.name, b.author, b.publisher, b.quantity * 2)).toList();
        System.out.println(" ---- Books quantity doubled  ---- ");
        doubleQunBook.stream().forEach(System.out::println);
        List<Book> booksQunLess = library.stream().filter(b -> b.quantity > 10).map(b -> b).toList();
        System.out.println(" --- Books quantity greater than 10 ---- ");
        booksQunLess.forEach(System.out::println);
        System.out.println("\nQuantity of books sold with ID < 200 : "
                + library.stream().filter(b -> b.id < 200).map(b -> b.quantity).reduce(0, Integer::sum));
    }
}