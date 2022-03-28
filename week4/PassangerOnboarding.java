package week4;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
class AirTicket {
    String passanger;
    String source;
    String destination;
    public AirTicket(String passanger, String source, String destination) {
        this.passanger = passanger;
        this.source = source;
        this.destination = destination;
    }
    public String getPassanger() {
        return passanger;
    }
    public void setPassanger(String passanger) {
        this.passanger = passanger;
    }
    public String getSource() {
        return source;
    }
    public void setSource(String source) {
        this.source = source;
    }
    public String getDestination() {
        return destination;
    }
    public void setDestination(String destination) {
        this.destination = destination;
    }
    @Override
    public String toString() {
        return "\nPassanger Name=" + passanger + "\nDestination=" + destination + "\nSource=" + source;
    }
    
}

public class PassangerOnboarding {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)){
                AirTicket at = new AirTicket("XYZ", "Dubai", "Singapore");
                System.out.println("Enter the date of journey in the dd-mm-yyyy format :");
                SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd E");
                Date d = new Date();
                System.out.println("Enter date as yyyy-MM-dd: ");
                Date dateOfJourney = new Date(sc.nextInt(), sc.nextInt(), sc.nextInt());
                if(dateOfJourney.after(d))
                    System.out.println("\nDate of journey is : " + dateOfJourney + "\n" + at + "Date today: " + d);
                else
                    throw new IllegalArgumentException("Enter date of journey is after: " + d);
        } 
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
