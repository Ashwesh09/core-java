package designPatterns;

interface Variant {
    String getTypeName();
}

class Modern implements Variant {
    /** 
     * 1. Singleton Pattern
    */
    private static volatile Modern modernInstance = null;

    private Modern() {

    }

    static Modern getModernInstance() {
        if (modernInstance == null) {
            modernInstance = new Modern();
        }
        return modernInstance;
    }

    public String getTypeName() {
        return "Modern";
    }
}

class Victorian implements Variant {
    /** 
     * 1. Singleton Pattern
    */
    private static volatile Victorian victorianInstance = null;

    private Victorian() {

    }

    static Victorian getVictorianInstance() {
        if (victorianInstance == null) {
            victorianInstance = new Victorian();
        }
        return victorianInstance;
    }

    public String getTypeName() {
        return "Victorian";
    }
}

/**
 * Builder Example Abstract Component is Product and Implementation is Variant
 */
abstract class Product {
    Variant type;

    Product(Variant type) {
        this.type = type;
    }

    abstract String getProductName();

    boolean hasLegs() {
        return !(this.type.getTypeName().equals("Modern"));
    }

    void displayLegsStatus() {
        System.out.print(this.type.getTypeName() + " " + getProductName() + " ");
        if (this.hasLegs()) {
            System.out.println("has legs.");
        } else {
            System.out.println("does not have legs");
        }
    }
}

class Chair extends Product {

    Chair(Variant type) {
        super(type);
    }

    String getProductName() {
        return "Chair";
    }

    void sitOn() {
        System.out.println("i sat on " + type.getTypeName() + " " + getProductName());
    }

}

class Sofa extends Product {

    Sofa(Variant type) {
        super(type);
    }

    String getProductName() {
        return "Sofa";
    }

    void sitOn() {
        System.out.println("i sat on " + type.getTypeName() + " " + getProductName());
    }

}

class CoffeeTable extends Product {

    CoffeeTable(Variant type) {
        super(type);
    }

    String getProductName() {
        return "Table";
    }

    void keepOn() {
        System.out.println(type.getTypeName() + " " + getProductName() + " is kept on floor");
    }

}

/**
 * Factory Method
 */
class FurnitureFactory {
    Variant type;

    FurnitureFactory(Variant type) {
        this.type = type;
    }

    Chair createChair() {
        return new Chair(this.type);
    }

    Sofa createSofa() {
        return new Sofa(this.type);
    }

    CoffeeTable createCoffeeTable() {
        return new CoffeeTable(this.type);
    }
}

class Client {
    private Chair chair;

    private Sofa sofa;
    private CoffeeTable coffeeTable;
    /**
     * Abstract factory method
     * @param factoryType
     * @return
     */
    FurnitureFactory getFactory(String factoryType) {
        Variant variant = factoryType.equals("Modern") ? Modern.getModernInstance() : Victorian.getVictorianInstance();
        return new FurnitureFactory(variant);
    }

    Client(String furnitureType) {
        FurnitureFactory factory = getFactory(furnitureType);
        this.chair = factory.createChair();
        this.sofa = factory.createSofa();
        this.coffeeTable = factory.createCoffeeTable();
    }

    void useFurniture() {
        this.chair.sitOn();
        this.sofa.sitOn();
        this.coffeeTable.keepOn();
        this.chair.displayLegsStatus();
        this.sofa.displayLegsStatus();
        this.coffeeTable.displayLegsStatus();
    }
}

public class DesginPatternAllDesigns {
    public static void main(String[] args) {
        Client client1 = new Client("Modern");
        Client client2 = new Client("Victorian");
        client1.useFurniture();
        System.out.println("-----------------------------");
        client2.useFurniture();
    }
}