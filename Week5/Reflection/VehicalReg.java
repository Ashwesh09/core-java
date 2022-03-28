package Week5.Reflection;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.lang.reflect.*;
class Vehicle {
    String brandName;
    int noOfWheels;
    boolean isRegistered = false;
    
    public String getBrand() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public int getNoOfWheels() {
        return noOfWheels;
    }

    public void setNoOfWheels(int noOfWheels) {
        this.noOfWheels = noOfWheels;
    }

    public boolean isRegistered() {
        return isRegistered;
    }

    public void setRegistered(boolean isRegistered) {
        this.isRegistered = isRegistered;
    }

    private void displayDriveringOrentaion() {
        System.out.println("Vehicle is left hand drive.");
    }

    void register(String brandName, int noOfWheels) {
        this.brandName = brandName;
        this.noOfWheels = noOfWheels;
        this.isRegistered = true;
        GregorianCalendar gcal = new GregorianCalendar();
        String dateOfRegistraion = gcal.get(Calendar.DATE) + "/" + (gcal.get(Calendar.MONTH) + 1) + "/"
                + gcal.get(Calendar.YEAR);
        System.out.println("Regsitration success!\nDate of regiration is:" + dateOfRegistraion);
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName()+"\nBrand Name: \t\t" + brandName + "\nIs Registered? : \t" + isRegistered + "\nNo Of Wheels: \t\t" + noOfWheels;
    }
    
}

class Car extends Vehicle {
    String carModelName;
    int yearOfManufacturing ;
    
    public Car(String carModelName) {
        this.carModelName = carModelName;
    }
    public String getCarModelName() {
        return carModelName;
    }
    public void setCarModelName(String carModelName) {
        this.carModelName = carModelName;
    }
    public int getYearOfManufacturing() {
        return yearOfManufacturing;
    }
    public void setYearOfManufacturing() {
        this.yearOfManufacturing = 2021;
    }
    @Override
    void register(String brankdName, int noOfWheels) {
        super.register(brankdName, 4);
    }
    @Override
    public String toString() {
        return super.toString() + "\nCar Model: \t\t" + carModelName + "\nYear Of Manufacturing: \t"
                + yearOfManufacturing;
    }
    void displayDriveringOrentaion() {
        System.out.println("Left hand drive.");
    }
}
public class VehicalReg {
    public static void main(String[] args) throws Exception {
        Car car = new Car("S-Class");
        car.register("Mercedes-Benz", 4);
        car.setYearOfManufacturing();
        System.out.println("Driving oreantation:");
        car.displayDriveringOrentaion();
        System.out.println();
        Class carClass = car.getClass();
        Class carSuperClass = carClass.getSuperclass();
        // Class Name:
        System.out.println("Name of Class : " + carClass.getName());
        // Super Class Name:
        System.out.println();
        System.out.println("Name of super class: " + carSuperClass.getName());
        // Constructors:
        System.out.println();
        System.out.println("Constructors:");
        Constructor[] constructors = carClass.getDeclaredConstructors();
        for (Constructor c : constructors) {
            System.out.println("Constructor name: " + c.getName());
        }
        //Methods :
        System.out.print("\nMethods:\n");
        Method[] methods = carClass.getDeclaredMethods();
        for (Method m : methods) {
            System.out.println("Method name: " + m.getName());
        }
        // Reflection
        System.out.println();
        Field feildOfcarModel = carClass.getDeclaredField("carModelName");
        Field feildOfisRegistered = carSuperClass.getDeclaredField("isRegistered");
        System.out.println("Car model name: "+ feildOfcarModel.get(car));
        System.out.println("Is registered?: " + feildOfisRegistered.get(car));
        // Altering fields:
        System.out.println();
        feildOfcarModel.set(car, "C-Class");
        feildOfisRegistered.set(car, false);
        System.out.println("Car model name: (after altering ) "+ feildOfcarModel.get(car));
        System.out.println("Is registered?: (after altering ) " + feildOfisRegistered.get(car));
        // Printing Obejct :
        System.out.println();
        System.out.println("Object info:\n"+car);
    }
}
