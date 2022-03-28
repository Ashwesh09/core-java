package Week5.Serilalization;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class BankAccounts implements Serializable {
    int accountNumber;
    String accountHolderName;
    double accountBalance;
    public BankAccounts(int accountNumber, String accountHolderName, double accountBalance) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.accountBalance = accountBalance;
    }
    @Override
    public String toString() {
        return "BankAccount: \nAccount Number:\t\t" + accountNumber + "\nAccount Holder Name :\t" + accountHolderName
                + "\nAccount Balance: \t" + accountBalance;
    }

    public void displayBalance() {
        System.out.println("Balance: " + this.accountBalance);
    }
}
public class Kioks{
    public static void main(String[] args) {
        BankAccounts bankAccounts = new BankAccounts(1, "XYZ", 1234.56);
        try(FileOutputStream fout = new FileOutputStream("Week5/Serilalization/accounts.txt");
            ObjectOutputStream out = new ObjectOutputStream(fout);){
            out.writeObject(bankAccounts);
            out.flush();
            System.out.println("Done Serialization.");
        }
        catch (Exception e) {
            System.out.println(e);
        }
    }
}
