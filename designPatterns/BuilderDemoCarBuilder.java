package designPatterns;

import java.util.Scanner;

interface CarBuildPlan{
    void reset();
    void setSeats(int number);
    void setEngine(Engine engine);
    void setTripComputer();
    void setGPS();
}
class Engine{
    double volume;
    double mileage;
    String transmission;
    public Engine(double volume, double mileage, String transmission) {
        this.volume = volume;
        this.mileage = mileage;
        this.transmission = transmission;
    }
    @Override
    public String toString() {
        return " volume - " + volume + " mileage - " + mileage + "\nTransmission: "+ transmission;
    }
    
}
class Car implements CarBuildPlan{
    private int noOfSeats;
    private Engine engine;
    private String tripComputer;
    private String carGPS;
    private String carName;

    @Override
    public void reset() {
        this.noOfSeats = 0;
        this.engine = null;
        this.tripComputer = null;
        this.carGPS = null;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    @Override
    public void setSeats(int noOfSeats) {
        this.noOfSeats = noOfSeats;
    }
    @Override
    public void setEngine(Engine engine) {
        this.engine = engine;
    }
    @Override
    public void setTripComputer() {
        this.tripComputer = "Functional";
    }
    @Override
    public void setGPS() {
        this.carGPS = "Functional";
    }
    public String getCarName() {
        return carName;
    }

    @Override
    public String toString() {
        return "\nType of car:" + carName + "\nCount of seats: " + noOfSeats + "\nEngine: " + engine + "\nTripCounter: " 
        + tripComputer + "\nGPS Navigator: " + carGPS + "\n";
    }
}


class Manual implements CarBuildPlan{
    private int noOfSeats;
    private Engine engine;
    private String tripComputer;
    private String carGPS;
    private String carName;

    @Override
    public void reset() {
        this.noOfSeats = 0;
        this.engine = null;
        this.tripComputer = null;
        this.carGPS = null;
    }

    @Override
    public void setSeats(int noOfSeats) {
        this.noOfSeats = noOfSeats;
    }
    @Override
    public void setEngine(Engine engine) {
        this.engine = engine;
    }
    @Override
    public void setTripComputer() {
        this.tripComputer = "Functional";
    }
    @Override
    public void setGPS() {
        this.carGPS = "Functional";
    }
    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    @Override
    public String toString() {
        return "\nType of car:" + carName + "\nCount of seats: " + noOfSeats + "\nEngine: " + engine + "\nTripCounter: " 
        + tripComputer + "\nGPS Navigator: " + carGPS + "\n";
    }
}

interface CarBuilder{
    void reset();
    void buildSeats();
    void buildEngine();
    void builTripComputer();
    void buildGPS();
    Car getResult();
}
interface CarManualBuilder{
    void reset();
    void buildSeats();
    void buildEngine();
    void builTripComputer();
    void buildGPS();
    Manual getResult();
}

class SUVcarBuilder implements CarBuilder{
    private Car car;
    private Manual manual;
    public Manual getManual() {
        return manual;
    }
    public SUVcarBuilder() {
        this.car = new Car();
        this.manual = new Manual();
        this.car.setCarName("SUV");
        this.manual.setCarName("SUV");
    }
    @Override
    public void reset() {
        this.car = new Car();
        this.car.setCarName("SUV");
        this.manual.setCarName("SUV");
    }
    @Override
    public void buildSeats(){
        car.setSeats(4);
        manual.setSeats(4);
    }
    @Override
    public void buildEngine() {
        Engine eg = new Engine(1.0,24.0,"AUTOMATIC");
        car.setEngine(eg);
        manual.setEngine(eg);
    }
    @Override
    public void builTripComputer() {
        car.setTripComputer();
        manual.setTripComputer();
    }
    @Override
    public void buildGPS() {
        car.setGPS();
        manual.setGPS();
    }
    @Override
    public Car getResult() {
        return car;
    }
} 

class SportsCarBuilder implements CarBuilder{
    private Car car;
    private Manual manual;
    
    public Manual getManual() {
        return manual;
    }
    public void setManual(Manual manual) {
        this.manual = manual;
    }
    public SportsCarBuilder() {
        this.car = new Car();
        this.car.setCarName("SPORTS_CAR");
        this.manual.setCarName("SPORTS_CAR");
    }
    @Override
    public void reset() {
        this.car = new Car();
        this.car.setCarName("SPORTS_CAR");
        this.manual.setCarName("SPORTS_CAR");
    }
    @Override
    public void buildSeats(){
        car.setSeats(2);
        manual.setSeats(2);
    }
    @Override
    public void buildEngine() {
        Engine eg = new Engine(3.0,0.0,"SEMI_AUTOMATIC");
        car.setEngine(eg);
        manual.setEngine(eg);
    }
    @Override
    public void builTripComputer() {
        car.setTripComputer();
        manual.setTripComputer();
    }
    @Override
    public void buildGPS() {
        car.setGPS();
        manual.setGPS();
    }
    @Override
    public Car getResult() {
        return car;
    }
}

class CarMechanic{
    private CarBuilder car;
    public CarMechanic(CarBuilder car) {
        this.car = car;
    }

    public void makeCar() {
        this.car.reset();
        this.car.buildSeats();
        this.car.buildEngine();
        this.car.builTripComputer();
        this.car.buildGPS();
    }
    public Car getCar() {
        return this.car.getResult();
    }
}


class CarBuilderFactory {
    public CarBuilder getBuilderInstance(String b) {
        if (b.equals("SUV")) {
            return new SUVcarBuilder();
        } else if (b.equals("SPORTS_CAR")) {
            return new SportsCarBuilder();
        } else {
            throw new IllegalArgumentException("Invalid input " + b);
        }
    }
}



public class BuilderDemoCarBuilder {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Car built:");
        String carName = sc.nextLine();
        sc.close();
        CarBuilderFactory carBuilderFactory = new CarBuilderFactory();
        CarBuilder carBuilder = carBuilderFactory.getBuilderInstance(carName);
        CarMechanic carMechanic = new CarMechanic(carBuilder);
        carMechanic.makeCar();
        Car customer1 = carMechanic.getCar();
        System.out.println(customer1);
    }
}
