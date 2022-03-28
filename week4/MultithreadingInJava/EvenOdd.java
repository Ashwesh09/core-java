package week4.MultithreadingInJava;

class TheOperation {
    int i = 1;

    public void printEven() {
        System.out.println("outside synch box ");
        synchronized (this){
        while (this.i <= 50) {
            if (i % 2 == 0) {
                System.out.println("Even :" + this.i++);
                notifyAll();
            }
            else {
                try {
                    wait();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
            // try{
            //     Thread.sleep(200);
            // }
            // catch (InterruptedException e) {
            //     System.out.println(e.getMessage());
            // }
        }
    }
        //System.out.println("\nDone with printing even numbers.");
    }

    public void printOdd() {
        System.out.println("Outside synch box of odd");
        synchronized (this) {
            while (this.i <= 50) {
                if (i % 2 != 0) {
                    System.out.println("Odd : " + this.i++);
                    notifyAll();
                } else {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                    }
                }
            }
            // try{
            //     Thread.sleep(200);
            // }
            // catch (InterruptedException e) {
            //     System.out.println(e.getMessage());
            // }
        }
        
    }
}

    public class EvenOdd {
        public static void main(String[] args) {
            TheOperation op = new TheOperation();
            new Thread() {
                public void run() {
                    op.printOdd();
                }
            }.start();
            new Thread() {
                public void run() {
                    op.printEven();
                }
            }.start();
            // long startTime = System.nanoTime();
            // long endTime = System.nanoTime();
            // long timeElapsed = endTime - startTime;
            // System.out.println("Execution time in nanoseconds: " + timeElapsed);
            // System.out.println("Execution time in milliseconds: " + timeElapsed / 1000000);
        }
    }