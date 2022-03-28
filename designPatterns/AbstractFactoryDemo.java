package designPatterns;

/**
 * Product Family - Furniture
 * Product - Chair
 */
interface Chair {
    boolean hasLegs();

    void sitOn();
}

/**
 * Product Family - Furniture
 * Product - Sofa
 */
interface Sofa {
    boolean hasLegs();

    void sitOn();
}

/**
 * Product Family - Furniture
 * Product - CoffeeTable
 */
interface CoffeeTable {
    boolean hasLegs();

    void keepOn();
}

/**
 * Product Family - Furniture
 * Product - Chair
 * Variant Type - Victorian
 */
class VictorianChair implements Chair {
    @Override
    public boolean hasLegs() {
        return true;
    }

    public void sitOn() {
        System.out.println("I sat on a Victorian Chair");
    }
}

/**
 * Product Family - Furniture
 * Product - Sofa
 * Variant Type - Victorian
 */
class VictorianSofa implements Sofa {
    @Override
    public boolean hasLegs() {
        return true;
    }

    public void sitOn() {
        System.out.println("I sat on a Victorian Sofa");
    }
}

/**
 * Product Family - Furniture
 * Product - CoffeeTable
 * Variant Type - Victorian
 */
class VictorianCoffeeTable implements CoffeeTable {
    @Override
    public boolean hasLegs() {
        return true;
    }

    public void keepOn() {
        System.out.println("I sat on a Victorian table");
    }
}
/**
 * Product Family - Furniture
 * Product - Chair
 * Variant Type - Modern
 */
class ModernChair implements Chair {
    @Override
    public boolean hasLegs() {
        return false;
    }

    public void sitOn() {
        System.out.println("I sat on a Modern Chair");
    }
}

/**
 * Product Family - Furniture
 * Product - Sofa
 * Variant Type - Modern
 */
class ModernSofa implements Sofa {
    @Override
    public boolean hasLegs() {
        return true;
    }

    public void sitOn() {
        System.out.println("I sat on a Modern Sofa");
    }
}

/**
 * Product Family - Furniture
 * Product - CoffeeTable
 * Variant Type - Modern
 */
class ModernCoffeeTable implements CoffeeTable {
    @Override
    public boolean hasLegs() {
        return true;
    }

    public void keepOn() {
        System.out.println("I sat on a Modern table");
    }
}

/**
 * Abstract Factory
 * Product Family - Furniture
 * Products - Chair, Sofa, and CoffeeTable
 */
interface FurnitureFactory {
    Chair createChair();

    Sofa createSofa();

    CoffeeTable createCoffeeTable();
}

/**
 * Concrete Factory
 * Product Family - Furniture
 * Variant Type - Victorian
 */
class VictorianFactory implements FurnitureFactory {
    public Chair createChair() {
        return new VictorianChair();
    }

    public Sofa createSofa() {
        return new VictorianSofa();
    }

    public CoffeeTable createCoffeeTable() {
        return new VictorianCoffeeTable();
    }
}

/**
 * Concrete Factory
 * Product Family - Furniture
 * Variant Type - Modern
 */
class ModernFactory implements FurnitureFactory {
    public Chair createChair() {
        return new ModernChair();
    }

    public Sofa createSofa() {
        return new ModernSofa();
    }

    public CoffeeTable createCoffeeTable() {
        return new ModernCoffeeTable();
    }
}

class Client {
    private Chair chair;
    private Sofa sofa;
    private CoffeeTable coffeeTable;

    Client(FurnitureFactory factory) {
        this.chair = factory.createChair();
        this.sofa = factory.createSofa();
        this.coffeeTable = factory.createCoffeeTable();
    }

    void useFurniture() {
        this.chair.sitOn();
        this.sofa.sitOn();
        this.coffeeTable.keepOn();

        if(this.chair.hasLegs())
            System.out.println("Chair has legs.");
        if(this.sofa.hasLegs())
            System.out.println("Sofa has legs.");
        if(this.coffeeTable.hasLegs())
            System.out.println("CoffeeTable has legs");
    }

}

public class AbstractFactoryDemo {
    public static void main(String[] args) {
        FurnitureFactory factory1 = new ModernFactory();

        Client client1 = new Client(factory1);

        client1.useFurniture();

        FurnitureFactory factory2 = new VictorianFactory();

        Client client2 = new Client(factory2);

        client2.useFurniture();
    }
}
