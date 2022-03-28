abstract class Shape {
    String name;
    double perimeter;
    double area;

    public Shape() {
        this.name = "Generic Shape";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPerimeter() {
        return perimeter;
    }

    public void setPerimeter(double perimeter) {
        this.perimeter = perimeter;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    abstract void draw();

    abstract double calculatePerimeter();
    abstract double calculateArea();
}

class rectangle extends Shape {
    double l, b;
    
    public rectangle(double l, double b) {
        this.name = "reactangle";
        this.l = l;
        this.b = b;
    }

    void draw() {
        System.out.println("Reactangle Drawn.");
    }

    double calculateArea() {
        return this.l * this.b;
    }

    double calculatePerimeter() {
        return this.l * 2 + this.b * 2;
    }
}
class square extends Shape {
    double a;
    
    public square(double a) {
        this.name = "Square";
        this.a = a;
    }

    void draw() {
        System.out.println("Reactangle Drawn.");
    }

    double calculateArea() {
        return this.a * this.a;
    }

    double calculatePerimeter() {
        return this.a * 4;
    }
}
class Circle extends Shape {
    double r;

    public Circle(double r) {
        this.name = "Circle";
        this.r = r;
    }

    void draw() {
        System.out.println("Cricle Drawn.");
    }

    double calculatePerimeter() {
        return 2 * this.r * Math.PI;
    }

    double calculateArea() {
        return Math.PI * this.r * this.r;
    }
}
public class abstarctionofShape {
    public static void main(String[] args) {
        //rectangle object
        rectangle rec = new rectangle(5.2, 2.3);
        rec.draw();
        System.out.println("Perimeter of reactangle is:"+rec.calculatePerimeter()); 
        System.out.println("Area of reactangle is:"+rec.calculateArea());
        //cicle object
        System.out.println("");
        Circle cir = new Circle(3.6);
        cir.draw();
        System.out.println("Perimeter of Circle is:"+cir.calculatePerimeter()); 
        System.out.println("Area of Circle is:" + cir.calculateArea());
        System.out.println("");
        // square object
        square sqr = new square(3.6);
        sqr.draw();
        System.out.println("Perimeter of Square is:"+sqr.calculatePerimeter()); 
        System.out.println("Area of Square is:"+sqr.calculateArea());

    }
}
