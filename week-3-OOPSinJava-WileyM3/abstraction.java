
interface Vehicle {
    void drive();

    void steeringMechanisms();

    static void start() {
    System.out.println("Vehicle Started!");
    }

    static void stop() {
       System.out.println("Vehicle Stopped\n");
    }
}

class Bike implements Vehicle {
    public void drive() {
        System.out.println("Driving Bike");
    }

    public void steeringMechanisms() {
        System.out.println("Driving with bike Handlebars");
    }
}

class Car implements Vehicle {
    public void drive() {
        System.out.println("Driving car");
    }

    public void steeringMechanisms() {
        System.out.println("Driving with car steering wheel");
    }
}

public class abstraction implements Vehicle {
    public static void main(String[] args) {
        Bike bike = new Bike();
        Car car = new Car();
        //Bike performance test
        System.out.println("---- Bike performance test ----");
        Vehicle.start();
        bike.drive();
        bike.steeringMechanisms();
        Vehicle.stop();
        // Car performance test
        System.out.println("---- Car performance test ----");
        Vehicle.start();
        car.drive();
        car.steeringMechanisms();
        Vehicle.stop();
    }

    @Override
    public void drive() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void steeringMechanisms() {
        // TODO Auto-generated method stub
        
    }
}
