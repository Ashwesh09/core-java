package Week6.Recurssion;

public class FinobacciSeries {
    public static void displayFibonacciSeries(int n, int first, int second) {
        if (n == 0)
            System.out.print(second + " ");
        else {
            System.out.print(second + " ");
            displayFibonacciSeries(--n, second, first + second);
        }
    }

    public static int findNthTerm(int n){
        if(n < 2)
            return n;
        return findNthTerm(n-1)+findNthTerm(n-2);
    }
    public static void main(String[] args) {
        int n = 9;
        System.out.print("0 ");
        displayFibonacciSeries(n, 0, 1);
        System.out.println("\n"+n+"th term is : "+ findNthTerm(n));
    }
}
