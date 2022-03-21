import java.util.Scanner;

interface List{
    void add(Object obj);
    void Display();
}
class Element{
    Object currentObject;
    Object nextObject = null;
    public Object getCurrentObject() {
        return currentObject;
    }
    public void setCurrentObject(Object currentObject) {
        this.currentObject = currentObject;
    }
    public Object getNextObject() {
        return nextObject;
    }
    public void setNextObject(Object nextObject) {
        this.nextObject = nextObject;
    }
}
class LinkedList implements List{
    Element[] object;
    int size;
    public LinkedList(int n) {
        this.object = new Element[n];
    }
    @Override
    public void add(Object object) {
        this.object[size++].setCurrentObject(object);
    }
    @Override
    public void Display() {
        for (Element element : object){
            System.out.println("Current Element:"+element.getCurrentObject());
            System.out.println("Next Element:"+element.getNextObject());
        }
    }
}
class ArrayList implements List{
    Object object;
    public Object getObject() {
        return object;
    }
    public void setObject(Object object) {
        this.object = object;
    }
    @Override
    public void add(Object object) {
        this.object = object; ;
    }
    @Override
    public void Display() {
        System.out.println(this.object);
    }
}   

public class InterfaceDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("1.LinkedList\n2.ArrayList");
        int ch = sc.nextInt();
        int len;
        if(ch == 1){
            
        }
        else if(ch == 2){
            ArrayList al = new ArrayList();
            len = sc.nextInt();
            for(int i=0; i<len; i++)
                al.add(sc.nextLine());
            al.Display();
        }
    }
}
