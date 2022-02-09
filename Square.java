public class Square {
    long square(int a){
        return a*a;
    }
    public static void main(String[] args){
        int a = 5;
        Square s = new Square();
        System.out.println("Sqaure of "+a+" is "+s.square(a));
    }
}
