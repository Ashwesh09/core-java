import java.util.Scanner;

public class RockPaperScissors {
    static int rndmNo(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }

    static String getCompChoice(int n) {
        switch(n){
            case 1:
                return "rock";
            case 2:
                return "paper";
            case 3:
                return "scissors";
            default:
                return "";
        }
    }
    public static void main(String[] args) {
        System.out.println(
                "\n------  WELCOME TO ROCK PAPER SCISSORS GAME ------ \n       --- It's you vs the computer ---\n");
        System.out.println("---- Rules: ----\n1. You have to type\n\t a. 'rock'\n\t b.'paper'\n\t c.'scissors'.");
        System.out.println("2. Careful of the spelling.\n3. Computer will auto-generate its choice.");
        System.out.println("4. You can play unlimited times.\n5. To termiate game enter 's'");
        System.out.println("\n**** So lets begin ****");
        Scanner sc = new Scanner(System.in);
        int n;
        String ch = "";
        while (!"s".equals(ch)) {
            System.out.print("------> Enter your choice: ");
            ch = sc.nextLine();

            n = rndmNo(1, 4);
            if (ch.equals("s")) {
                break;
            }
            if ((ch.equals(getCompChoice(n)))) {
                System.out.println("\nSheesh! We got same O_o\nI was " + getCompChoice(n));
            } else if (("paper".equals(ch) && getCompChoice(n).equals("rock"))
                    || ("scissors".equals(ch) && getCompChoice(n).equals("paper"))
                    || ("rock".equals(ch) && getCompChoice(n).equals("scissors")))
                System.out.println("\n ---  YOU WIN  <*('_')*>  ---\n   I was " + getCompChoice(n) + " -_-'");
            else if ((("scissors".equals(ch) && getCompChoice(n).equals("rock"))
                    || ("rock".equals(ch) && getCompChoice(n).equals("paper"))
                    || ("paper".equals(ch) && getCompChoice(n).equals("scissors")))) {
                System.out.println("\nI was " + getCompChoice(n) + " B)");
                System.out.println("Hard Luck! ):");
            } else
                System.out
                        .println("\nPlease play fair OR enter valid choice :)\n Btw I got:" + getCompChoice(n) + "\n");
            System.out.println("Enter 's' to exit or continue playing!!\n");
        }
        System.out.println("Thank you for playing!");
        sc.close();
    }

}
    
