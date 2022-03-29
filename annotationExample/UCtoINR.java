package annotationExample;

import java.util.Scanner;

public class UCtoINR {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter UC:");
        double input = sc.nextDouble();
        System.out.println("UC : \t" + input);
        double inr = input  * (8500.0/8100.0);
        System.out.println("INR : \t" + inr);

    }
}

