package week4;

import java.util.Scanner;

public class StringsExample {
    
    private static boolean hasAllSubStrings(String[] str,String mainS) {
        for (int i = 0; str[i] != null; i++) {
            if(!hasSubString(str[i],mainS))   
                return false;
            System.out.println(str[i]+" is present in "+ mainS);
        }
        return true;
    }
    private static boolean hasSubString(String s, String mainS) {
        char[] c1 = s.toCharArray();
        char[] c2 = mainS.toCharArray();
        int i;
        for (i = 0; i < c2.length; i++) {
            if (c1[0] == c2[i]) {
                if (c1.length == 1)
                    return true;
                break;
            }
        }
        for(int j = 0; j < c1.length; j++,i++) {
            if(c1[j] != c2[i])
                return false;
         }
        return true;
    }
    private static String[] takeInputString() {
        String[] result = new String[20];
        try (Scanner sc = new Scanner(System.in)) {
            String str = sc.nextLine();
            int i;
            for (i = 0; !(str.matches("[0-9]")); i++) {
                result[i] = str;
                str = sc.nextLine();
            }
            return result;
        }
    }
    public static void main(String[] args) {
        String mainStr = "Impossible";
        String[] possibleStrings = new String[200];
        System.out.println("Enter inputs:(To termainate enter any digit(0-9)):");
        possibleStrings = takeInputString();
        if(hasAllSubStrings(possibleStrings,mainStr))
            System.out.println("YES");
        else
            System.out.println("NO");
    }
}
