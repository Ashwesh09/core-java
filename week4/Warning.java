package week4;

import java.util.Scanner;

import java.io.*;
import java.lang.StringBuilder;

public class Warning
{
    // --------------------------------------------------------------------
    // Reads student data (name, semester hours, quality points) from a
    // text file, computes the GPA, then writes data to another file
    // if the student is placed on academic warning.
    // --------------------------------------------------------------------
    public static void main (String[] args)
    {
        int creditHrs;		// number of semester hours earned
        double qualityPts;	// number of quality points earned
        double gpa;			// grade point (quality point) average
        String inputName = "week4/students.dat";
        String name;
        String outputName = "week4/warning.dat";
        String[] studentData;
        try(FileReader fr = new FileReader(inputName);Scanner sc = new Scanner(fr);FileWriter fw = new FileWriter(outputName))
        {
            while(sc.hasNextLine()){
                studentData = sc.nextLine().split("\\s");
                name = studentData[0]; 
                creditHrs = Integer.parseInt(studentData[1]);
                qualityPts = Double.parseDouble(studentData[2]);
                gpa = qualityPts / creditHrs;
                if(creditHrs < 30 && gpa < 1.5)
                    fw.write(name+" "+creditHrs+" "+qualityPts+"\n");
                else if(creditHrs < 60 && gpa < 1.75)
                    fw.write(name+" "+creditHrs+" "+qualityPts+"\n");
                else if (gpa < 2.0)
                    fw.write(name+" "+creditHrs+" "+qualityPts+"\n");
            }
        }
        catch (FileNotFoundException exception)
        {
          System.out.println ("The file " + inputName + " was not found.");
        }
        catch (IOException exception)
        {
          System.out.println (exception);
        }
        catch (NumberFormatException e)
        {
            System.out.println("Format error in input file: " + e);
        }
        System.out.println("Operation Done!");
    }
}