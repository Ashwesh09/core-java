package Week5.Generics;
class NumberClass<T extends Number> {
    T num;

    public NumberClass(T num) {
        this.num = num;
    }

    double square() {
        return num.doubleValue() * num.doubleValue();
    }

    boolean absEquals(NumberClass<?> obj) {
        return (Math.abs(this.num.doubleValue()) == Math.abs(obj.num.doubleValue()));
    }
}
public class NumberClassInGenerics {
    public static void main(String[] args) {
        NumberClass<Integer> obj = new NumberClass<>(3);
        System.out.println(obj.square());
        NumberClass<Double> objCompare = new NumberClass<>(-3.0);
        System.out.println("Are they equals?: " + obj.absEquals(objCompare));
    }
}
