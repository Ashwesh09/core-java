package Week6;

import java.util.NoSuchElementException;
class LinkedList {
    Node head;
    int size;
    static class Node {
        int data;
        Node next = null;
    
        Node(int d) {
            this.data = d;
        }
    }
    public int size() {
        return this.size;
    }
    public boolean isEmpty() {
        return head == null;}
    public void insertAtFirst(int data) {
        Node temp = new Node(data);
        if (isEmpty())
            head = temp;
        else {
            temp.next = head;
            head = temp;
        }
        size++;
    }

    public void insertAtEnd(int data) {
        Node temp = new Node(data);
        if (isEmpty())
            head = temp;
        else {
            Node itr = head;
            while (itr.next != null)
                itr = itr.next;
            itr.next = temp;
        }
        size++;
    }

    public void insertInMiddle(int data, int index) {
        index -= 1;
        Node temp = new Node(data);
        if (index == 0)
            insertAtFirst(data);
        else if (size == index)
            insertAtEnd(data);
        else {
            Node curr = head;
            Node prev = null;
            for (int i = 0; i < index && curr != null; i++) {
                prev = curr;
                curr = curr.next;
            }
            if (curr != null && prev != null) {
                prev.next = temp;
                temp.next = curr;
                size++;
            } else
                throw new IndexOutOfBoundsException("Poistion " + (index + 1) + " is invalid.");
        }
    }

    public void deleteFirst() {
        if (isEmpty())
            throw new NoSuchElementException("Empty");
        head = head.next;
        size--;
    }

    public void deleteAtIndex(int index) {
        if (isEmpty())
            throw new NoSuchElementException("Empty");
        else if (index == 1)
            deleteFirst();
        else {
            index -= 1;
            Node curr = head;
            Node prev = null;
            for (int i = 0; i < index && curr != null; i++) {
                prev = curr;
                curr = curr.next;
            }
            if (curr != null && prev != null) {
                prev.next = curr.next;
                size--;
            } else
                throw new IndexOutOfBoundsException("Poistion " + (index + 1) + " is invalid.");
        }
    }

    public int indexOf(int d) {
        Node temp = head;
        int i;
        boolean eleFound = false;
        for (i = 1; i <= size; i++) {
            if (temp.data == d) {
                System.out.println("Found : " + temp.data);
                eleFound = true;
                break;
            }
            temp = temp.next;
        }
        if(eleFound)
            return i;
        else    
            return -1;
    }
    public int getValueAtIndex(int index) {
        Node temp = head;
        for(int i = 1 ; i < index && temp != null; i++)
            temp = temp.next;
        if(temp != null)
            return temp.data;
        throw new IndexOutOfBoundsException("Index " + index + " is invalid.");
    }

    public void removeElement(int d) {
        if (isEmpty())
            throw new NoSuchElementException("Empty");
        int i = indexOf(d);
        System.out.println("deleteing at index " + i);
        deleteAtIndex(i);
    }

    public void replaceAt(int index,int data){
        deleteAtIndex(index);
        insertInMiddle(data,index);
    }
    public void display() {
        LinkedList.Node temp = head;
        System.out.println("\nLinkedList:");
        while (temp != null) {
            System.out.print(temp.data +" --> ");
            temp = temp.next;
        }
        System.out.print("EOL\n");
    }
    //head-> a -> b -> c -> d -> e -> f -> g
    //head-> g -> f -> e -> d -> c -> b -> a
    public void reverse() {
        LinkedList.Node curr = head;
        LinkedList.Node prev = null;
        LinkedList.Node next = null;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev; 
    }
    public int getFirstElement(int k){
        Node temp = head;
        int count = 1;
        while(temp.next != null){
            if(temp.data == k)
                return count;
            temp = temp.next;
            count++;
        }
        return -1;
    }
}
public class LinkedListDemo {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.insertAtFirst(20);
        list.insertAtFirst(30);
        list.insertAtFirst(40);
        list.insertAtFirst(50);
        list.insertAtEnd(60);
        list.insertInMiddle(15, 3);
        list.display();
        // //list.deleteAtIndex(6);
        // //list.removeElement(60);
        // list.replaceAt(4, 90);
        // System.out.println("Before reverse:");
        // list.display();
        // System.out.println("After reverse:");
        // list.reverse();
        // list.display();
        // // System.out.println("Element at " + 6 + " is : " + list.getValueAtIndex(6));
        // // System.out.println("Element "+ 60 + " is at index : "+list.indexOf(90));
        // System.out.println("\nSize of linked list: " + list.size());
        System.out.println("Element : " + list.getFirstElement(6));
    }
}
