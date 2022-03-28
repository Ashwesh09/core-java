package week4;

import java.io.IOException;
import java.util.Scanner;

public class ExceptionHandeling{
    public static void main(String[] args) throws IOException{
        throw new IOException();
            // Scanner sc = new Scanner(System.in);
            // System.out.println("Enter a,b,c:");
            // int a = sc.nextInt();
            // int b = sc.nextInt();
            // // try {
            //     int res1 = a/b;  
            //     System.out.println("Result of "   + a  +  "/ "   +  b +   " = " +res1); 
            //     try {
            //          int c = sc.nextInt();
            //          int res2 = res1/c;
            //          System.out.println("Result of "   + res1  +  "/ "   +  c +   " =" +res2);
            //          try{
            //             int[] array = new int[res2];
            //             for (int i = 0; i < res2 ; i++) 
            //                 array[i] = i + res1;
            //             System.out.println("3rd Element is: "+ array[2]);
            //         }
            //         catch(ArrayIndexOutOfBoundsException e){
            //             System.out.println("Array index out of bound.");
            //         } 
            //     }
            //     catch(ArithmeticException e){
            //         System.out.println("ArithmeticException: Divide by zero");
            //     }
            // //}
            // // catch(ArithmeticException e){
            // //     System.out.println("ArithmeticException: Divide by zero");
            // // }         
    }
}
