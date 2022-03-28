package SpringConfigDemo;

public class MyBean {
    private String firstName;
    private String lastName;
    public MyBean(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    @Override
    public String toString() {
        return "Name : " + firstName + " " + lastName;
    }
    
}
class MyFactory{
    public MyBean createMyBean(){
        return new MyBean();
    }
}