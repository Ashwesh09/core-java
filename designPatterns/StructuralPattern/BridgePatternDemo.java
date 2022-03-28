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
public class BridgePatternDemo {
    public static void main(String[] args) {
        Variant victorian = new Victorian();
        Variant modern = new Modern();
        Product victorianChair = new Chair(victorian);
        Product victorianSofa = new Sofa(victorian);
        Product victorianCoffeeTable = new CoffeeTable(victorian);
        Product modernChair = new Chair(modern);
        Product modernSofa = new Sofa(modern);
        Product modernCoffeeTable = new CoffeeTable(modern);


        victorianChair.buildProduct();
        System.out.println();

        victorianSofa.buildProduct();
        System.out.println();

        victorianCoffeeTable.buildProduct();
        System.out.println();

        modernChair.buildProduct();
        System.out.println();

        modernSofa.buildProduct();
        System.out.println();

        modernCoffeeTable.buildProduct();
    }
}