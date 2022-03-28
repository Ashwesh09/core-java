package week4;

public class TrimingString {
    public static String trimString(String s) {
        char[] res = new char[s.length()];
        int startSpaces=0,endSpaces=0,k=0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != ' ')
                break;
            startSpaces++;
        }
        System.out.println("Start spaces are:" + startSpaces);
        for (int i = s.length() - 1; i > startSpaces; i--) {
            if (s.charAt(i) != ' ')
                break;
            endSpaces++;
        }
        System.out.println("End spaces are:" + endSpaces);
        for (int i = startSpaces; i <= (s.length() - endSpaces -1); i++)
            res[k++] = s.charAt(i);
        return new String(res);
    }
    public static void main(String[] args) {
        String sample = "   Ash   wesh  k ";
        System.out.println(trimString(sample));
    }
}
