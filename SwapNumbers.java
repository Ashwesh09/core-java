public class SwapNumbers {
    void SwapNumbers(int a,int b){
        System.out.println("Before Swap \na="+a+" b="+b);
        int temp = a;
        a = b;
        b = temp;
        System.out.println("After Swap \na="+a+" b="+b);
    }
    public static void main(String[] args) {
        SwapNumbers ain = new SwapNumbers();
        int a = 10;
        int b = 13;
        ain.SwapNumbers(a,b);
    }
}
