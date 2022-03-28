package week4;

import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
public class FileHandelingEg {
    public static void main(String[] args) throws IOException {
        /**
         * With FileReader
         */
        try (BufferedWriter bw1= new BufferedWriter(new FileWriter("week4/Test1.txt"));) {
            bw1.write("File coping example.");
        }
        catch (IOException e) {
            System.out.println("File not exists.");
        }
        try(BufferedWriter bw1= new BufferedWriter(new FileWriter("week4/Test1.txt"));) {
            bw1.write("Hello i appended here.");
            System.out.println("Done!");
        }
        catch (IOException e) {
            System.out.println("File not exists.");
        }
        /**
         *  With nio
         * */
        // try{
        // Files.writeString(Paths.get("week4/Test2.txt"), "Writing with nio file handler");
        // Files.writeString(Paths.get("week4/Test1.txt"), Files.readString(Paths.get("week4/Test2.txt"))) ;
        // } catch (IOException e) {
        //     System.out.println(e);
        // }
    }
    
}
