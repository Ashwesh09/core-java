package Week5.Serilalization;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class ATM {
    public static void main(String[] args){
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Week5/Serilalization/accounts.txt"))) {
            BankAccounts account = (BankAccounts) ois.readObject();
            account.displayBalance();
            System.out.println("\n"+ account);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
