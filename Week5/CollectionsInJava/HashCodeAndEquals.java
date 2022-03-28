package Week5.CollectionsInJava;

import java.util.*;

class Book implements Comparable<Book> {
    int id;
    String name;
    String author;
    String publisher;
    int quantity;
    public Book(int id, String name, String author, String publisher, int quantity) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.publisher = publisher;
        this.quantity = quantity;
    }
    @Override
    public String toString() {
        return "ID: " + id + " Book Name: " + name + " Author Name: " + author + " Publisher: " + publisher + " Quantity: "
                + quantity;
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + id;
        result = prime * result + ((author == null) ? 0 : author.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        else if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Book other = (Book) obj;
        if (id == 0 || name == null || author == null) {
            if (other.id != 0 || other.name != null || other.author != null)
                return false;
        } else if (id != other.id || !name.equals(other.name) || !author.equals(other.author))
            return false;
        return true;
    }
    @Override
    public int compareTo(Book other) {
        return this.id - other.id;
    }
}

public class HashCodeAndEquals {
    private static Set<Book> getDuplicateBook(List<Book> library) {
        Set<Book> duplicates = new HashSet<>();
        for(int i = 0; i <library.size()-1 ;i++){
            for(int j = i+1 ; j <library.size() ; j++ ){
                if(library.get(j).equals(library.get(i))){
                    duplicates.add(library.get(i));
                }
            }
        }
        System.out.println("No. of duplicate books : "+duplicates.size());
        return duplicates;
    }
    private static int getMaxmimunQuantity(List<Book> library,Set<Book> duplicates) {
        int maxIndex = library.indexOf(library.get(0));
        for (Book i : library) {
            if (duplicates.contains(library.get(library.indexOf(i))))
                continue;
            if (library.get(library.indexOf(i)).quantity > library.get(maxIndex).quantity)
                maxIndex = library.indexOf(i);
        }
        return maxIndex;
    }
    public static void main(String[] args) {
        Book b1 = new Book(121, "Let us C", "Yashwant Kanetkar", "BPB", 8);
        Book b2 = new Book(233, "Operating System", "Galvin", "Wiley", 6);
        Book b3 = new Book(101, "Data Communications & Networking", "Forouzan", "Mc Graw Hill", 4);
        Book b4 = new Book(121, "Let us C", "Yashwant Kanetkar", "Mc Graw Hill", 11);
        List<Book> library = new ArrayList<>();
        library.add(b1);
        library.add(b2);
        library.add(b3);
        library.add(b4);
        /**
         * Duplicate book
         */
        Set<Book> duplicates = new HashSet<>();
        duplicates = getDuplicateBook(library);
        if(!duplicates.isEmpty()) 
            duplicates.forEach(System.out::println);
        else
            System.out.println("\nNo duplicate books in library.");
        /**
         * Maxmimum quantity book
         */
        int maxIndex = getMaxmimunQuantity(library, duplicates);
        System.out.println("Details of maximum quantity book:"+ library.get(maxIndex));
    }
}
