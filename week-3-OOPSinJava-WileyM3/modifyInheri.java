class Parent extends Object{
    String firstname;
    String lastname;

    Parent() {
        this.lastname = "Alone";
    }

    Parent(String firstname) {
        this();
        this.firstname = firstname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }
    public String toString() {
        return String.format("Firstname: %s %nLastname: %s", firstname, lastname);
    }
}

class Child extends Parent {
    Child() {
        super();
    }

    public Child(String firstname) {
        //super(firstname);
        this.firstname = firstname;
    }
    //super.toString();
}


public class modifyInheri {
    public static void main(String[] args) {
        Parent p = new Parent("Ashwesh");
        Child c = new Child("Abc");
        System.out.println("Information of Parent :\n"+p+"\nInformation of Child : \n"+c);
    }
}
