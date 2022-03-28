package Week5.Reflection.user_data_migration;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.io.Serializable;


public class User implements Serializable {
    private static long serialVersionUID = 1L;
    static String country = "INDIA";
    private String name;
    private String email;
    private transient String password;
    public User(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }
    public static String getCountry() {
        return country;
    }
    public static void setCountry(String country) {
        User.country = country;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getEmail() {
        return email;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    @Override
    public String toString() {
        return "User\nEmail: \t\t" + email + "\nName: \t\t" + name + "\nPassword: \t" + password;
    }
}
