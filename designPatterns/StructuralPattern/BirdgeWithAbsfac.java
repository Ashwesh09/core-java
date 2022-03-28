package designPatterns.StructuralPattern;

/**
 * Product Family
 */
abstract class Product{
    Variant variant;
    abstract void buildProduct();

    Product(Variant variant) {
        this.variant = variant;
    }
}
/**
 * Variant Family
 */
interface Variant {
    boolean hasLegs();

    void sitOn();
}

/**
 * Product Family - Furniture
 * Product - Chair
 */
class Chair extends Product{
    Product product;
    Chair(Variant variant) {
        super(variant);
    }
    @Override
    void buildProduct() {
       variant.sitOn();
       if(variant.hasLegs())
        System.out.println(this.getClass().getSimpleName() +" has legs.");
       else
        System.out.println(this.getClass().getSimpleName() +" not has legs.");
    }
}

/**
 * Product Family - Furniture
 * Product - Sofa
 */
class Sofa extends Product{

    Sofa(Variant variant) {
        super(variant);
    }

    @Override
    void buildProduct() {
       variant.sitOn();
       if(variant.hasLegs())
        System.out.println(this.getClass().getSimpleName() +" has legs.");
       else
        System.out.println(this.getClass().getSimpleName() +" not has legs.");
    }
}

/**
 * Product Family - Furniture
 * Product - CoffeeTable
 */
class CoffeeTable extends Product{

    CoffeeTable(Variant variant) {
        super(variant);
    }
    @Override
    void buildProduct() {
       variant.sitOn();
       if(variant.hasLegs())
        System.out.println(this.getClass().getSimpleName() +" has legs.");
       else
        System.out.println(this.getClass().getSimpleName() +" not has legs.");
    }
}

/**
 * Product Family - Furniture
 * Variant Type - Victorian
 */
class Victorian implements Variant {

    @Override
    public boolean hasLegs() {
        return true;
    }

    public void sitOn() {
        System.out.println("Product varaint is Victorian");
    }
}

/**
 * Product Family - Furniture
 * Variant Type - Modern
 */
class Modern implements Variant {

    @Override
    public boolean hasLegs() {
        return false;
    }

    public void sitOn() {
        System.out.println("Product varaint is Modern");
    }
}

/**
 * Abstract Factory
 * Product Family - Furniture
 * Products - Chair, Sofa, and CoffeeTable
 */
interface FurnitureFactory {
    Product createChair();

    Product createSofa();

    Product createCoffeeTable();
}

/**
 * Concrete Factory
 * Product Family - Furniture
 * Variant Type - Victorian
 */
class VictorianFactory implements FurnitureFactory {
    public Product createChair() {
        return new Chair(new Victorian());
    }

    public Product createSofa() {
        return new Sofa(new Victorian());
    }

    public Product createCoffeeTable() {
        return new CoffeeTable(new Victorian());
    }
}

/**
 * Concrete Factory
 * Product Family - Furniture
 * Variant Type - Modern
 */
class ModernFactory implements FurnitureFactory {
    public Product createChair() {
        return new Chair(new Modern());
    }

    public Product createSofa() {
        return new Sofa(new Modern());
    }

    public Product createCoffeeTable() {
        return new CoffeeTable(new Modern());
    }
}

class Client {
    private Product chair;
    private Product sofa;
    private Product coffeeTable;

    Client(FurnitureFactory factory) {
        this.chair = factory.createChair();
        this.sofa = factory.createSofa();
        this.coffeeTable = factory.createCoffeeTable();
    }

    void useFurniture() {
        this.chair.buildProduct();
        this.sofa.buildProduct();
        this.coffeeTable.buildProduct();
    }
}

public class BirdgeWithAbsfac {
    public static void main(String[] args) {
        FurnitureFactory factoryOfModern = new ModernFactory();

        Client client1 = new Client(factoryOfModern);

        client1.useFurniture();

        System.out.println();
        
        FurnitureFactory factoryOfVictorian = new VictorianFactory();

        Client client2 = new Client(factoryOfVictorian);

        client2.useFurniture();
    }
}
