interface Shape{
    void draw();
}

interface Polygon extends Shape{
    double getArea();

    double getPerimeter();

    boolean isPolygon();
}

class Line implements Polygon{
    double area;
    double perimeter;
    int noOfSides;

    public Line(int noOfSides) {
        this.noOfSides = noOfSides;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public double getPerimeter() {
        return perimeter;
    }

    public void setPerimeter(double perimeter) {
        this.perimeter = perimeter;
    }

    public int getNoOfSides() {
        return noOfSides;
    }
    @Override
    public void draw() {
        System.out.println("I am of " + this.getClass().getSimpleName() + " shape");
    }
    @Override
    public boolean isPolygon() {
        if (this.noOfSides <= 2)
            return false;
        return true;
    }
}

class Triangle extends Line {
    double a, b, c;
    
    public Triangle(int noOfSides, double a, double b, double c) {
        super(noOfSides);
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    public double getPerimeter() {
        this.perimeter = this.a + this.b + this.c;
        return this.perimeter;
    }

    @Override
    public double getArea() {
        double s = (this.a + this.b + this.c) / 2;
        this.area = Math.sqrt(s * (s - this.a) * (s - this.b) * (s - this.c));
        return this.area;
    }
}
class Rectangle extends Line {
    int l,b;
    
    public Rectangle(int noOfSides, int l, int b) {
        super(noOfSides);
        this.l = l;
        this.b = b;
    }
    @Override
    public double getPerimeter() {
        this.perimeter = 2 * (this.l + this.b);
        return this.perimeter;
    }
    @Override
    public double getArea() {
        this.area = this.l * this.b;
        return this.area;
    }
}
public class PloygonInterface {
    public static void main(String[] args) {
        //Triangle object
        Line l = new Line(1);
        l.draw();
        Triangle tri = new Triangle(3, 2.3, 5.6, 5.7);
        tri.draw();
        System.out.println("Area of triangle : " + tri.getArea());
        System.out.println("Perimeter of triangle:" + tri.getPerimeter());
        System.out.println("Is it is a polygon?: " + tri.isPolygon());
        // rectangle object
        Rectangle rect = new Rectangle(4, 5, 10);
        rect.draw();
        System.out.println("Area of rectangle : " + rect.getArea());
        System.out.println("Perimeter of rectangle:" + rect.getPerimeter());
        System.out.println("Is it is a polygon?: " + rect.isPolygon());
    }
}
