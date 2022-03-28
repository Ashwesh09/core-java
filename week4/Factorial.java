package week4;

import java.util.Scanner;

class MathUtils
{
 //-------------------------------------------------------------
 // Returns the factorial of the argument given
 //-------------------------------------------------------------
public static int factorial(int n){

        if(n < 0)
            throw new IllegalArgumentException("Negative number do not have a factorial.\n"+n+"! =  1");
        else if (n >= 16)
            throw new IllegalArgumentException("The problem is arithmetic overflow.\nThe factorial is bigger than can be represented by an int.");
        int fac = 1;
        for (int i=n; i>0; i--)
            fac *= i;
    return fac;

 }
} 

public class Factorial {
    public static void main(String[] args) {
        
        System.out.println("Enter num to find factorial of it.");
        try(Scanner sc = new Scanner(System.in)){
            int num = sc.nextInt();
            int res = MathUtils.factorial(num);
            System.out.println(num + "! =" + res);
        }
        catch (ArrayIndexOutOfBoundsException | IllegalArgumentException e) {
            System.out.println(e);
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        finally {
            System.out.println("Program termiated. We are in finally block.");
        }
    }
}
