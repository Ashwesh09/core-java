package Week5.Generics;

public class Example {
    static <T> T displaySample(Integer a, T b) {
        T returnVal = null;
        if (b instanceof Integer || b instanceof Double) {
            Integer mul = a * Integer.parseInt(b.toString());
            @SuppressWarnings("unchecked") T res = (T) mul;
            return res;
        } else if (b instanceof String) {
            String s = "Cannot perform operation";
            @SuppressWarnings("unchecked") T res = (T) s;
            return res;
        } else if (b instanceof Boolean) {
            Boolean rest = false;
            @SuppressWarnings("unchecked") T res = (T) rest;
            return res;
        }
        return returnVal;
    }
public static void main(String[] args) {
    System.out.println("Multiplication : " + displaySample(2, 5));
    System.out.println("Multiplication : " + displaySample(2, "Hello"));
    System.out.println("Multiplication : " + displaySample(2, true));
    }
}
