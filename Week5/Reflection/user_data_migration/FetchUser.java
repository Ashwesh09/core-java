package Week5.Reflection.user_data_migration;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.lang.reflect.Field;

public class FetchUser {
    public static void main(String[] args) {
           
       try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Week5/Reflection/user_data_migration/userdata.txt"))) {
            User newUser = (User) ois.readObject();
            System.out.println("User record retrieved");
            Class userClass = newUser.getClass();
            Field fieldOfPassWord = userClass.getDeclaredField("password");
            fieldOfPassWord.setAccessible(true);
            fieldOfPassWord.set(newUser, "MyNewPass2ord123");
            System.out.println(newUser);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
   } 
}