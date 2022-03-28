package Week5.taskAndOther;

import java.io.*;

public class Task1 {
    private static void writeToFile(String s,String FileName){
        try (FileWriter fw = new FileWriter(FileName)) {
            fw.write(s);
        }
        catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
    private static String insertCharacter(int index, char charToinsert,String str) {
            String s = "";
            int i = 0;
            String temp = String.valueOf(charToinsert);
            for(char ch : str.toCharArray()) {
                if (i == index - 1) {
                    s += ch + temp;
                } else
                    s += ch;
                i++;
            }
            return s;
    }
    private static String insertStringAfterWord(int noOfWords, String string,String str) {
            String s = "";
            int space = 0;
            for(char ch : str.toCharArray()) {
                if (ch == ' ') {
                    space++;
                    if (space == noOfWords) 
                        s += string + " ";
                    else
                        s += ch;
                }
                else
                    s += ch;
            }
            return s;
    }
    private static void readContentFormFile(String fileName) {
        try (FileReader fr = new FileReader(fileName);) {
            int ch;
            String s = "";
            while ((ch = fr.read()) != -1)
                s += (char) ch;
            System.out.println("String in file:" + s);
        }
        catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
    public static void main(String[] args) {
        String s = "Hello hi bye";
        String fileName ="Week5/taskAndOther/playground.txt";
        writeToFile(s, fileName);
        s = insertCharacter(5, '@',s);
        writeToFile(s, fileName);
        s = insertStringAfterWord(2, "123",s);
        writeToFile(s, fileName);
        readContentFormFile(fileName);
    }
}
