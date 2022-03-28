package week4;

class Enterprenure {
    private final String name;
    private final String companyName;
    private final String companyAddress;
    public Enterprenure(String name, String companyName, String companyAddress) {
        this.name = name;
        this.companyName = companyName;
        this.companyAddress = companyAddress;
    }

    public String getName() {
        return name;
    }

    public final Enterprenure setName(String name,String companyName,String companyAddress) {
        return new Enterprenure(name, companyName, companyAddress);
    }
    public String getCompanyName() {
        return companyName;
    }

    public String getCompanyAddress() {
        return companyAddress;
    }
    @Override
    public String toString() {
        return "\nPerson Name : \t\t" + name + "\nCompany Owned : \t" + companyName +"\nCompany Address : \t" + companyAddress;
    }
    
}
public class ImmutableClass {
    public static void main(String[] args) {
        Enterprenure aG = new Enterprenure("Ashneer Grover", "BharatPe", "Delhi, India");
        System.out.println("Enterprenure is an immutable class.\n Its is object: " + aG);
        System.out.println("Hash code: "+aG.hashCode());
        System.out.println("Now after changing values in it with set name method it creats a new object:");
        aG = aG.setName("Anupan Mittal", "Shaddi.com", "Ahmadabad Gujrat");
        System.out.println("Enterprenure is an immutable class.\n Its is object: " + aG);
        System.out.println("Hash code now:"+ aG.hashCode());
    }
}
