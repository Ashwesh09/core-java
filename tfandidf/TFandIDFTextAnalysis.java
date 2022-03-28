package tfandidf;

import java.io.*;
import java.lang.reflect.Array;
import java.text.DecimalFormat;
import java.util.*;

public class TFandIDFTextAnalysis {
    
    public static void writeInFile(String s1, String s2, String s3, String s4,String file1, String file2, String file3, String file4) {
        try (FileWriter fw1 = new FileWriter(file1);FileWriter fw2 = new FileWriter(file2);
            FileWriter fw3 = new FileWriter(file3);FileWriter fw4 = new FileWriter(file4);){
            fw1.write(s1);
            fw2.write(s2);
            fw3.write(s3);
            fw4.write(s4);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static String[] readFromFile(String file1, String file2, String file3, String file4) {
        try(FileReader fr1 = new FileReader(file1);
                FileReader fr2 = new FileReader(file2);
                FileReader fr3 = new FileReader(file3);
                FileReader fr4 = new FileReader(file4);) {
            String[] res = new String[4];
            int i = 0;
            for(String s : res) 
                res[i++] = "";
            int ch;
            while ((ch = fr1.read()) != -1)
                res[0] += (char) ch;
            while ((ch = fr2.read()) != -1)
                res[1] += (char) ch;
            while ((ch = fr3.read()) != -1)
                res[2] += (char) ch;
            while ((ch = fr4.read()) != -1)
                res[3] += (char) ch;
            return res;
            }
            catch (IOException e) {
                System.out.println(e.getMessage());
                return new String[0];
            }
    }

    public static List<String> filterString(String s) {
        String[] strArr = s.replaceAll("\\p{Punct}", "").toLowerCase().split("\\s");
        strArr = removeStopWord(strArr);
        return Arrays.asList(strArr);
    }

    public static String[] removeStopWord(String[] s) {
        String stopWords = "i, me, my, myself, we, our, ours, ourselves, you, you’re, you’ve, you’ll, you’d, your, yours, yourself, yourselves, he, most, other, some, such, no, nor, not, only, own, same, so, then, too, very, s, t, can, will, just, don, don’t, should, should’ve, now, d, ll, m, o, re, ve, y, ain, aren’t, could, couldn’t, didn’t, didn’t, the, a, by, is, of";
        String[] arr = stopWords.split(", ");
        for (String str1 : arr) {
            for (String str2 : s)
                if (str2.equals(str1)) {
                    s = remove(s, str1);
                }
        }
        return s;
    }

    public static String[] remove(String[] array, String element) {
    if (array.length > 0) {
        int index = -1;
        for (int i = 0; i < array.length; i++) {
            if (array[i].equals(element)) {
                index = i;
                break;
            }
        }
        if (index >= 0) {
            String[] copy = (String[]) Array.newInstance(array.getClass()
                    .getComponentType(), array.length - 1);
            if (copy.length > 0) {
                System.arraycopy(array, 0, copy, 0, index);
                System.arraycopy(array, index + 1, copy, index, copy.length - index);
            }
            return copy;
        }
    }
    return array;
}

    public static Set<String> getCommonWords(List<List<String>> input) {
        Set<String> res = new HashSet<>();
        for(List<String> s : input) {
             for (String x : s)
                    res.add(x);
        }
        return res;
    }

    public static double[][] wordFreqTable(Set<String> setOfCommonWords, List<List<String>> listofString) {
        double[][] tf = new double[4][setOfCommonWords.size()];
        List<String> commonWords = new ArrayList<>();
        commonWords.addAll(setOfCommonWords);
        String[][] strings = new String[4][setOfCommonWords.size()];
        int i = 0, j = 0;
        for (List<String> line : listofString)
            strings[i++] = line.toArray(new String[0]);
        for (i = 0; i < 4; i++) 
            for (j = 0; j < setOfCommonWords.size(); j++) 
                if (Arrays.asList(strings[i]).contains(commonWords.get(j))) 
                    tf[i][j]++;
        return tf;
    }

    public static double[][] normalizedTFtable(double[][] tf, int row, int col) {
        double[] sumRow = new double[row];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                sumRow[i] = sumRow[i] + tf[i][j];
            }
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                tf[i][j] /= sumRow[i];
            }
        }
        return tf;
    }

    public static double[] getIDFandDisplayIDF(double[][]  tfAndIdf, int row, int col,Set<String> setOfCommonWords){
        double[] IDF = new double[col];
        for (int i = 0; i < col; i++) {
            for (int j = 0; j < row; j++) {
                IDF[i] += tfAndIdf[j][i];
            }
        }
        DecimalFormat df = new DecimalFormat("#0.0000");
        System.out.print("IDF\t");
            for (String words : setOfCommonWords) {
            if(words.length() > 7)
                System.out.print(words + "\t");
            else    
                System.out.print(words + "\t\t");
        }
            System.out.print("\n\t");
            for (int i = 0; i < col ; i++) {
                IDF[i] = Math.log10(row / IDF[i]);
                System.out.print(df.format(IDF[i]) + "\t\t");
            }
            System.out.println("\n");
        return IDF;
    }

    public static void displayTable(double[][] tf, int n, int m, Set<String> setOfCommonWords) {
        DecimalFormat df = new DecimalFormat("#0.00000");
        System.out.print("D/W\t");
        for (String words : setOfCommonWords) {
            if(words.length() > 7)
                System.out.print(words + "\t");
            else    
                System.out.print(words + "\t\t");
        }
        System.out.println();
        for (int i = 0; i < n; i++) {
            System.out.print("D " + (i + 1) + ":\t");
            for (int j = 0; j < m; j++) {
                System.out.print(df.format(tf[i][j]) + "\t\t");
            }
            System.out.println();
        }
    }

    public static double[][] getTFandIDF(double[][] tfAndIdf, double[] idf, int row, int col) {
        for (int j = 0; j < col; j++) {
            for (int i = 0; i < row; i++)
                tfAndIdf[i][j] *= idf[j];
        }
        return tfAndIdf;
    }
    public static void main(String[] args) {
        String s1 = "My name is Groot.";
        String s2 = "My ship is a Starship.";
        String s3 = "The ship I drive, is, a Starship Benatar.";
        String s4 = "My ship is a Benatar model of Starship !!";
        String file1 = "tfandidf/doc1.txt";
        String file2 = "tfandidf/doc2.txt";
        String file3 = "tfandidf/doc3.txt";
        String file4 = "tfandidf/doc4.txt";
        /**
         * Write in File:
         */
        writeInFile(s1,s2,s3,s4,file1,file2,file3,file4);
        /**
         * Read from files:
         */
        String[] stotal = readFromFile(file1,file2,file3,file4);
        /**
         * Filter the strings:
         */
        List<List<String>> filteredString = new ArrayList<>();
        for(String s : stotal)
            filteredString.add(filterString(s));
        /**
         * Finding commom words:
         */
        Set<String> setOfCommonWords = getCommonWords(filteredString);
        /**
         * Freqency of occurrences:
         */
        double[][] tf = wordFreqTable(setOfCommonWords, filteredString);
        System.out.println("\n ---- Count table ---- \n");
        displayTable(tf, 4, setOfCommonWords.size(), setOfCommonWords);

        /**
         *  IDF and Normalize this data across the rows to sum it to one for each document to generate our final TF table.
         */
        System.out.println("\n ----  IDF Table -----\n");
        double[] idf = getIDFandDisplayIDF(tf, 4, setOfCommonWords.size(),setOfCommonWords);
        normalizedTFtable(tf, 4, setOfCommonWords.size());
        System.out.println("\n --- Normalized TF table ---- \n");
        displayTable(tf, 4, setOfCommonWords.size(), setOfCommonWords);
        /**
         * FINAL TS AND IDF table:
         */
        getTFandIDF(tf, idf, 4, setOfCommonWords.size());
        System.out.println("\n------ FINAL TF and IDF Table: ------\n");
        displayTable(tf, 4, setOfCommonWords.size(), setOfCommonWords);
    }
}

