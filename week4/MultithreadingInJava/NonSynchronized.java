package week4.MultithreadingInJava;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

class ShakespeareInNonSync{  
 void writeEpicStuff(String str){
     try (FileWriter fw = new FileWriter("week4/MultithreadingInJava/play.txt",true)) {
         for (char c : str.toCharArray()) {
             fw.write(c);
         }
         fw.write("\n");
         System.out.println("File written by:"+ Thread.currentThread().getName());
         }
     catch (IOException e) {
       System.out.println(e.getMessage());
   }
 }  
}  
  
class MyThread1inNonSync extends Thread {
    private String content;
    private ShakespeareInNonSync shakespeare;

    public MyThread1inNonSync(String content, ShakespeareInNonSync shakespeare) {
        this.content = content;
        this.shakespeare = shakespeare;
    }
    @Override
    public void run() {
        this.shakespeare.writeEpicStuff(this.content);
    }
}

  
public class NonSynchronized {
    public static void main(String[] args) throws IOException {
        ShakespeareInNonSync sNs = new ShakespeareInNonSync();  
        MyThread1inNonSync t1 = new MyThread1inNonSync("Et tu, Brute?", sNs);
        MyThread1inNonSync t2 = new MyThread1inNonSync("Hamlet is a small village.", sNs);
        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
            System.out.println("Message in file with non-synchronized method is : \n"
                    + Files.readString(Paths.get("week4/MultithreadingInJava/play.txt")));
            Files.delete(Paths.get("week4/MultithreadingInJava/play.txt"));
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

