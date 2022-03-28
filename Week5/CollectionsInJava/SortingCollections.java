package Week5.CollectionsInJava;

import java.util.*;
import java.text.DecimalFormat;
interface Client{
    double getCharges();

    double calculatePayments(GregorianCalendar d);
 
    void sendEmail(double payement);
}
abstract class ServiceClient implements Client, Comparable<ServiceClient> {
    int id;
    String name;
    String email;
    double charges;
    GregorianCalendar dateOfAgreement;

    public int compareTo(ServiceClient other) {
        return this.id - other.id;
    }

    public double getCharges() {
        return charges;
    }
    @Override
    public void sendEmail(double payement) {
        String dateOfRegistraion = dateOfAgreement.get(Calendar.DATE) + "/" + (dateOfAgreement.get(Calendar.MONTH) + 1)
                + "/"
                + dateOfAgreement.get(Calendar.YEAR);
        DecimalFormat df = new DecimalFormat("#0.00");
        System.out.println("You payment of " + df.format(payement) + " is plending from " + dateOfRegistraion);
    }
    @Override
    public String toString() {
        String dateOfRegistraion = dateOfAgreement.get(Calendar.DATE) + "/" + (dateOfAgreement.get(Calendar.MONTH) + 1)
                + "/"
                + dateOfAgreement.get(Calendar.YEAR);
        return this.getClass().getSimpleName() +"\nID:\t\t" + id + "\nName :\t" + name + "\nEmail :\t" + email+"\nDate of Aggrement :\t"+ dateOfRegistraion ;
    }
}
class Customer extends ServiceClient {

    public Customer(int id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.charges = 2.36;
        this.dateOfAgreement = new GregorianCalendar(2022,3-1,(int)(Math.random() * ((15 - 1) + 1)));
    }
    private static int getNoOfDays(GregorianCalendar present, GregorianCalendar future) {
        if (future.get(Calendar.DATE) > present.get(Calendar.DATE)) {
            return future.get(Calendar.DATE) - present.get(Calendar.DATE);
        }
        return 0;
    }
    @Override
    public
    double calculatePayments(GregorianCalendar d) {
        int noOfDays = getNoOfDays(dateOfAgreement, d);
        return noOfDays * getCharges();
    }
}

class Business extends ServiceClient {
    double gstRate;
    public Business(int id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.charges = 3.36;
        this.dateOfAgreement = new GregorianCalendar(2022,3-1,(int)(Math.random() * ((15 - 1) + 1)));
        this.gstRate = 20; // in precentage
    }
    
    public double getGstRate() {
        return gstRate;
    }
    private static int getNoOfDays(GregorianCalendar present, GregorianCalendar future) {
        if (future.get(Calendar.DATE) > present.get(Calendar.DATE)) {
            return future.get(Calendar.DATE) - present.get(Calendar.DATE);
        }
        return 0;
    }
    @Override
    public
    double calculatePayments(GregorianCalendar d) {
        int noOfDays = getNoOfDays(dateOfAgreement, d);
        double res = noOfDays * getCharges();
        return res + (getGstRate()/100) * res;
    }
}
public class SortingCollections {
    public static void main(String[] args) {
        ServiceClient customer1 = new Customer(123, "ABC", "abc@yahoo.com");
        ServiceClient customer2 = new Customer(124, "DEF", "def@rediffmail.com");
        ServiceClient business1 = new Business(456, "UVW", "uvw@gmail.com");
        ServiceClient business2 = new Business(457, "XYZ", "xyz@pqr.com");
        List<ServiceClient> clients = new ArrayList<>();
        List<Double> pendingPayments = new ArrayList<>();
        clients.add(customer1);
        clients.add(customer2);
        clients.add(business1);
        clients.add(business2);
        for (ServiceClient c : clients)
            pendingPayments.add(c.calculatePayments(new GregorianCalendar(2022, 3 - 1, 31)));
        int i = 0;
        for (ServiceClient c : clients) {
            if (pendingPayments.get(i) != 0)
                c.sendEmail(pendingPayments.get(i++));
            else
                i++;
        }
        Collections.sort(clients);
        clients.forEach(System.out::println);
        System.out.println("\n -----  Sorting with Charges in descending order, -----\n");
        Collections.sort(clients, (ServiceClient sc1, ServiceClient sc2) -> (int) (sc1.getCharges() - sc2.getCharges()));
        clients.forEach(System.out::println);

        System.out.println("\n ---- Sort According to date of Agreement ----- \n");
        Collections.sort(clients, (ServiceClient sc1,ServiceClient sc2) -> (sc1.dateOfAgreement.get(Calendar.DATE) - sc2.dateOfAgreement.get(Calendar.DATE)));
        clients.forEach(System.out::println);
    }
}
