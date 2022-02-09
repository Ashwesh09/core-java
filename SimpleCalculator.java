import java.util.Scanner;

public class SimpleCalculator {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        char choice;
        double result,b;
        System.out.println("*******   SimpleCalculator    *********"); //Heading
        System.out.println(
                " Operations:  Add(+)  Subtract(-)  Multiply(*)  Divide(/)  Modules(%)\nTo terminate (t) To startover(s)"); // Instruction on calculator
        System.out.print("Enter number:");              // First Number
        result = in.nextDouble();
        System.out.print("Operation:");                 // Operation to be performed 
        choice = in.next().charAt(0);
        while (choice != 't') {                         // Terminate on 't' entered
            System.out.print("Enter number:");          // Second number
            b = in.nextDouble();
            switch (choice) {
                case '+': 
                    System.out.print(result + "+" + b);  // addition
                    result = result + b;
                    break;
                case '-':
                    System.out.print(result + "-" + b); // substration
                    result = result - b;
                    break;
                case '*':
                    System.out.print(result + "x" + b); // Multiplication
                    result = result * b;
                    break;
                case '/':
                    System.out.print(result + "/" + b); // Division
                    result = result / b;
                    break;
                case '%':
                    System.out.print(result + "%" + b); // Modulous
                    result = result % b;
                    break;
                default:
                    System.out.println("Invalid choice! '"+choice+"'\nTry Again.Press t to terminate");     //Invalid choice
            }
            System.out.println(" = " + result + "\n");
            System.out.print("Operation:");
            choice = in.next().charAt(0);
            if (choice == 's') {                        // Logic to reset the calculator.
                System.out.print("\nProcess reset!\nEnter number:");
                result = in.nextDouble();
                System.out.print("Operation:");
                choice = in.next().charAt(0);
            }
        }
        in.close();
    }
}