package week4;

import java.util.Arrays;

public class ConcatinateStrings {
    private static String mergerCharArr(String s1, String s2) {
        String res = s1 + s2;
        char[] c = res.toCharArray();
        Arrays.sort(c);
        return new String(c);
    }
    public static void main(String[] args) {
        String str1 = "java";
        String str2 = "python";
        System.out.println(mergerCharArr(str1, str2));
    }
}
