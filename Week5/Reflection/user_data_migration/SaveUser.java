package Week5.Reflection.user_data_migration;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class SaveUser {
    public static void main(String[] args) {
        User newUser = new User("Ashwesh","ashwesh@gmail.com","Password123");
        try (FileOutputStream fos = new FileOutputStream("Week5/Reflection/user_data_migration/userdata.txt");
                ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(newUser);
            oos.flush();
            System.out.println("User record saved!");    
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
