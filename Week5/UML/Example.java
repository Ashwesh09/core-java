package Week5.UML;

class Point {
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Point() {
    }

    public int getX() {
        return x;
    }
    
    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return "(" + x + "," + y + ")";
    }

    double distance(Point p) {
        return Math.sqrt(Math.pow((this.x - p.x),2) + Math.pow((this.y - p.y),2));
    }
}

class Line {
    Point start;
    Point end;
    public Line(Point start, Point end) {
        this.start = start;
        this.end = end;
    }

    public Line(int x1, int y1, int x2, int y2) {
        this.start.x = x1;
        this.start.y = y1;
        this.end.x = x2;
        this.end.y = y2;
    }

    public Point getStart() {
        return start;
    }

    public void setStart(Point start) {
        this.start = start;
    }

    public Point getEnd() {
        return end;
    }

    public void setEnd(Point end) {
        this.end = end;
    }

    double length() {
        return start.distance(end);
    }
}
public class Example {
    public static void main(String[] args) {
        Point start = new Point(8, 9);
        Point end = new Point(3, 6);
        Line line = new Line(start,end);
        System.out.println("Distance b/w "+start+" and "+end+" is : "+line.length());
    }
}
