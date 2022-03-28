package Week5.GarbageCollectorInJava;

class Sample {
    int data;

    public Sample(int data) {
        this.data = data;
    }
    @Override
    public void finalize() {
        System.out.println("Finalize invoked");
    }
    
}
public class example {
    public static void main(String[] args) {
        Sample s = new Sample(1);
        s = null;
        System.gc();
    }
}
