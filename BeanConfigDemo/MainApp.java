package BeanConfigDemo;

public class MainApp {
    public static void main(String[] args) {
        UserDataReader udr = new UserDataReader();
        UserBean ub = udr.myFactory();
        System.out.println(ub);
        
    }
}
