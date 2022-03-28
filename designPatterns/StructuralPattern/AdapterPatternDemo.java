package designPatterns.StructuralPattern;

interface Bird {
    public void fly();

    public void makeSound();
}

class Sparrow implements Bird {
    public void fly() {
        System.out.println("Flying...");
    }

    public void makeSound() {
        System.out.println("Chirp chirp");
    }
}

class Duck implements Bird {
    public void fly() {
        System.out.println("Flying...");
    }

    public void makeSound() {
        System.out.println("Quack quack");
    }
}

interface ToyBird {
    public void squeak();
}


class ToyDuck implements ToyBird {
    public void squeak() {
        System.out.println("Squeaking noise");
    }
}
class ToySparrow implements ToyBird{
    public void squeak() {
        System.out.println("Sparrow noise");
    }
}
class BirdAdapter implements ToyBird {
    Bird bird;

    public BirdAdapter(Bird bird) {
        this.bird = bird;
    }

    public void squeak() {
        bird.makeSound();
    }
}

public class AdapterPatternDemo {
    public static void main(String[] args) {
        Bird duck = new Duck();
        Bird sparrow = new Sparrow();
        ToyBird toySparrow = new ToySparrow();
        ToyBird toyDuck = new ToyDuck();

        // Wrap a bird in a birdAdapter so that it behaves like a toy bird
        BirdAdapter birdAdapterDuck = new BirdAdapter(duck);
        BirdAdapter birdAdapterForSparrow = new BirdAdapter(sparrow);

        System.out.println("Demonstrating a real bird duck::");
        duck.fly();
        duck.makeSound();

        System.out.println("Demonstrating a toy bird duck::");
        toyDuck.squeak();

        System.out.println("Making a toy bird duck behave like a real bird duck via bird adapter::");
        birdAdapterDuck.squeak();

        System.out.println("Demonstrating a real bird sparrow::");
        sparrow.fly();
        sparrow.makeSound();

        System.out.println("Demonstrating a toy bird sparrow::");
        toySparrow.squeak();

        System.out.println("Making a toy bird sparrow behave like a real sparrow bird via bird adapter::");
        birdAdapterForSparrow.squeak();
    }
}
