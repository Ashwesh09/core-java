package week4;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

class User { // POJO Class
    protected String email;
    protected String firstName;
    protected String lastName;
    protected String password;
    protected String fullName;
    Date dateOfBirth;
    protected IndianPhoneNumber[] phNumber;

    

    public User(String email, String firstName, String lastName, String password, Date dateOfBirth, IndianPhoneNumber[] phNumber) {
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.dateOfBirth = dateOfBirth;
        this.phNumber = phNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
        setFullName();
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName() {
        this.fullName = this.firstName + " " + this.lastName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPhNumber(IndianPhoneNumber[] phNumber) {
        this.phNumber = phNumber;
    } 
    public Date getdateOfBirth() {
        return dateOfBirth;
    }

    public void setdateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
    @Override
    public String toString() {
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd E");
        String s = "Details are :\nEmail ID :\t" + email + "\nFull Name :\t" + fullName + "\nDate of Birth :\t"+f.format(dateOfBirth)+"\nPhone Numbers : ";
        for (int i = 0; i < phNumber.length; i++)
            s += this.phNumber[i].pNum + "\n\t\t";
        return s;
    }
}

class InvalidInputValueException extends Exception {
    InvalidInputValueException(String msg) {
        super(msg);
    }
}
class UserValidation {
    
    private UserValidation() {
    }
    public static boolean hasAllDigits(String str) {
        for (int i = 0; i < str.length(); i++) {
            if (!(str.charAt(i) >= '0' && str.charAt(i) <= '9'))
                return false;
        }
        return true;
    }

    public static void validate(User user) {
        if (!(user.password.length() >= 8 && user.password.length() <= 16))
            throw new IllegalArgumentException("Password Should be between 8-16 characters in name.");
        if (!user.email.contains("@"))
            throw new IllegalArgumentException("Please include a @ symbol in the email address");
        if (!user.email.contains("."))
            throw new IllegalArgumentException("'.' is missing in email address provided.");
        if (user.email.contains(" "))
            throw new IllegalArgumentException("No spaces are allowed in email address");
        for (int i = 0; i < user.phNumber.length; i++) {
            if (user.phNumber[i].pNum.length() != 10)
                throw new IllegalArgumentException("Number should be 10 digits.");
        }
        for (int i = 0; i < user.phNumber.length; i++) {
            if (!hasAllDigits(user.phNumber[i].pNum))
                throw new IllegalArgumentException("Number should contain only digits.");
        }
        if (!user.firstName.matches("^[a-zA-Z]*$"))
            throw new IllegalArgumentException("Please enter only alphabet characters:" + user.fullName);
        if (!user.lastName.matches("^[a-zA-Z]*$"))
            throw new IllegalArgumentException("Please enter only alphabet characters:" + user.fullName);
        if (!(user.password.matches(".*\\d+.*")))
            throw new IllegalArgumentException("Password should contain atleast one digit in:" + user.password);
        //DATE OF BIRTH MODIFICATION
        int yr = user.dateOfBirth.getYear() + 1900;
        if(yr < 1900 || yr > 2009)
            throw new IllegalArgumentException("Sorry you are not eligible to use this application.");
    }
}
class UserRegistration {
    
    private UserRegistration() {
    }

    static void register(String fname,String lname,String email,String password,IndianPhoneNumber[] phNumber,Date dateOfBirth) {
        User user = new User(email, fname, lname, password,dateOfBirth, phNumber);
        user.setFullName();
        UserValidation.validate(user);
        System.out.println(user);
    }
}
class IndianPhoneNumber{
    static final String countryCode = "+91";
    String pNum;

    public IndianPhoneNumber(String pNum) {
        this.pNum = pNum;
    }
    
    @Override
    public String toString() {
        return countryCode+"-" + pNum;
    }
    
}
public class RegisExceptionH {
    public static void main(String[] args) throws ParseException {       
        String fname = "Peter";
        String lname = "Parker";
        String email = "peterp@gmail.com";
        String password = "password123";
        String dob = "1901.05.09";
        SimpleDateFormat f = new SimpleDateFormat("yyyy.MM.dd");
        IndianPhoneNumber[] phNumber = (new IndianPhoneNumber[] { new IndianPhoneNumber("8521478521"),
                new IndianPhoneNumber("9632541115") });
        try {
            UserRegistration.register(fname, lname, email, password, phNumber,f.parse(dob));
            System.out.println("Regsitration successful");
        } 
        catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            System.out.println("Registration failed");
        }
    }
}