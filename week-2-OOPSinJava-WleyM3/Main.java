import java.util.Scanner;

class Client {
    int clientId;
    String clientName;
    String passportNumber;

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getPassportNumber() {
        return passportNumber;
    }

    public void setPassportNumber(String passportNumber) {
        this.passportNumber = passportNumber;
    }
}

class Agent extends Client {
    String agencyName;

    public String getAgencyName() {
        return agencyName;
    }

    public void setAgencyName(String agencyName) {
        this.agencyName = agencyName;
    }
    
    public String displayDetails() {
        return "Cl" + clientId + ", clientName=" + clientName + ", passportNumber=" + passportNumber
                + "]";
    }
    
}
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Agent agent = new Agent();
        agent.setClientId(sc.nextInt());
        agent.setClientName(sc.nextLine());
        agent.setPassportNumber(sc.nextLine());
        agent.setAgencyName(sc.nextLine());

    }
}
