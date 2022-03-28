package week4.MultithreadingInJava;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

class ShakespeareInSync{  
 synchronized void writeEpicStuff(String str){
     try (FileWriter fw = new FileWriter("week4/MultithreadingInJava/play.txt", true)) {
         for (char c : str.toCharArray()) {
             fw.write(c);
         }
         fw.write("\n");
         System.out.println("File Written by:"+Thread.currentThread().getName());
     }
     catch (IOException e) {
       System.out.println(e.getMessage());
   }
 }  
}  
  
class MyThread1inSync extends Thread {
    private String content;
    private ShakespeareInSync shakespeare;

    public MyThread1inSync(String content, ShakespeareInSync shakespeare) {
        this.content = content;
        this.shakespeare = shakespeare;
    }
    @Override
    public void run() {
        this.shakespeare.writeEpicStuff(this.content);
    }
}

  
public class Synchronization {
    public static void main(String[] args) throws IOException {
        ShakespeareInSync s = new ShakespeareInSync();  
        MyThread1inSync t1 = new MyThread1inSync("Et tu, Brute?", s);
        MyThread1inSync t2 = new MyThread1inSync("Hamlet is a small village.", s);
        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
            System.out.println("Message in file with synchronized method is : \n"
                    + Files.readString(Paths.get("week4/MultithreadingInJava/play.txt")));
           // Files.delete(Paths.get("week4/MultithreadingInJava/play.txt"));
            
        }
        catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }
}

