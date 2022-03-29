package BeanConfigDemo;

public class UserBean {
    private String first_name;
    private String last_name;
    public void setFirstName(String firstName) {
        this.first_name = firstName;
    }
    public void setLastName(String lastName) {
        this.last_name = lastName;
    }
    @Override
    public String toString() {
        return "Name : " + first_name + " " + last_name;
    }
}
