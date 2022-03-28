import java.util.Scanner;

class Account {
    double balance;
    String accountHolder;

    Account(double balance, String accountHolder) {
        this.accountHolder = accountHolder;
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }
    
    public void setBalance(double balance) {
        this.balance = balance;
    }
    
    public String getAccountHolder() {
        return accountHolder;
    }
    
    public void setAccountHolder(String accountHolder) {
        this.accountHolder = accountHolder;
    }
    
    protected double debit(double bal, double balanceDebt) {
        if (balanceDebt > bal) {
            return bal;
        }
        return bal - balanceDebt;
    }
    protected double credit(double bal, double balance) {
        return bal + balance;
    }
}
public class BankAccounts {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Account ac1 = new Account(0, "");
        Account ac2 = new Account(0, "");
        int accountCount = 0;
        String ch = "C";
        while (accountCount <= 2) {  
            if (ch.equals("A")) {
                sc.nextLine();
            }
            System.out.println("To create an account press 'C'. To access your account press A:");
            ch = sc.nextLine();
            if (ch.equals("C")) {
                System.out.print("Enter Name as User name: ");
                if (accountCount == 0) 
                    ac1.setAccountHolder(sc.nextLine());
                else
                    ac2.setAccountHolder(sc.nextLine());
                if (accountCount == 1 || accountCount == 2 || accountCount == 0) {
                    System.out.println("Account is created!");
                }
                accountCount++;
            } else if (ch.equals("A")) {
                System.out.print("Enter your name:");
                String name = sc.nextLine();
                if (!ac1.getAccountHolder().equals(name) && !ac2.getAccountHolder().equals(name)) {
                    System.out.println("Invalid name entered Or account might not exist.");
                } else {
                    System.out.print("'D' to withdraw money; 'C' to credit money:");
                    String choice = sc.nextLine();
                    switch (choice) {
                        case "D":
                            if (name.equals(ac1.getAccountHolder())) {
                                System.out.print("Enter your amount to debit:");
                                double balanceDebt = sc.nextDouble();
                                if (ac1.getBalance() == ac1.debit(ac1.getBalance(), balanceDebt)) {
                                    System.out.println(
                                            "Debit amount exceeded account balance.\nAvailable balance:"
                                                    + ac1.getBalance());
                                } else {
                                    ac1.setBalance(ac1.getBalance() - balanceDebt);
                                    System.out.println(
                                            "Transation success!\nAvailable balance:" + ac1.getBalance());
                                }
                            }
                            else {
                                System.out.print("Enter your amount to debit:");
                                double balanceDebt = sc.nextDouble();
                                if (ac2.getBalance() == ac2.debit(ac2.getBalance(), balanceDebt)) {
                                    System.out.println(
                                            "Debit amount exceeded account balance.\nAvailable balance:"
                                                    + ac2.getBalance());
                                } else {
                                    ac2.setBalance(ac2.getBalance() - balanceDebt);
                                    System.out.println(
                                            "Transation success!\nAvailable balance:" + ac2.getBalance());
                                    }
                                }
                            break;
                        case "C":
                            if (name.equals(ac1.getAccountHolder())) {
                                System.out.print("Enter your amount to credit:");
                                double balanceCred = sc.nextDouble();
                                System.out.println(
                                        "Success!\nAvailable balance:" + ac1.credit(ac1.getBalance(), balanceCred));
                                ac1.setBalance(ac1.credit(ac1.getBalance(), balanceCred));
                            } else {
                                System.out.print("Enter your amount to credit:");
                                double balanceCred = sc.nextDouble();
                                System.out.println(
                                        "Success!\nAvailable balance:" + ac2.credit(ac2.getBalance(), balanceCred));
                                 ac2.setBalance(ac2.credit(ac2.getBalance(), balanceCred));
                            }
                            break;
                        default:
                            System.out.println("Invalid choice");
                    }
                }
            } else
                System.out.println("Invalid choice");
        }
        System.out.println("No of accounts limit exceeded");
        sc.close();
    }

}
