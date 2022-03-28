import java.util.Scanner;

class Coin {
    String sideUp;
    public Coin() {
        tossCoin();
    }
    public void tossCoin() {
        if (1 + (int) (Math.random() * ((2 - 1) + 1)) == 1)
            this.sideUp = "head";
        else
            this.sideUp = "tail";
    }
    public String getSideUp() {
        return sideUp;
    }
}

public class CoinTossGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Coin quater = new Coin();
        Coin dime = new Coin();
        Coin nickel = new Coin();
        double bal = 0;
        int i = 1;
        System.out.println(
                "\n------  WELCOME TO COIN TOSS GAME ------ \n       --- Get to 1 Dollar to win ---\n");
        System.out.println("---- Rules: ----\n1. Three coins quater(for 25 cents), dime(for 10 cents) and nickel (for 5 cents) will be tossed.");
        System.out.println("2. Information will be displayed like wise.\n5. To win your balance should be 1 Dollar else you lose");
        System.out.println("\n**** So lets here the game begins ****\n");
        while (true) {
            System.out.print("Do you want to play?: 'y' (YES) or 'n' (NO):");
            if (sc.next().charAt(0) == 'y') {
                bal = 0;
                i = 0;
            } else {
                System.out.println("Thank you for playing!");
                break;
            }

            while (bal < 1) {
                System.out.println("\nRound No. " + (i++) + ":\n");
                quater.tossCoin();
                if (quater.getSideUp().equals("head"))
                    bal += 0.25;
                dime.tossCoin();
                if (dime.getSideUp().equals("head"))
                    bal += 0.10;
                nickel.tossCoin();
                if (nickel.getSideUp().equals("head"))
                    bal += 0.05;
                System.out.println("Quater had : \t" + quater.getSideUp());
                System.out.println("Dime had : \t" + dime.getSideUp());
                System.out.println("Nickel had : \t" + nickel.getSideUp());
                System.out.println("Net Balance : \t" + bal);
                if (bal == 1) {
                    System.out.println("\n-----  YOU WIN <(^_^)>  -------\n ");
                } else if (bal > 1) {
                    System.out.println("\n-----  Hard Luck you lost. You bal was: " + bal + "-------\n ");
                }
            }
        }
        sc.close(); 
    }
}