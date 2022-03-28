package week4;

public class AnagramStrings {
    public static void main(String[] args) {
        String str1 = "peek";
        String str2 = "keep";
        str1 = str1.replaceAll("\\s", "").toLowerCase();
        str2 = str2.replaceAll("\\s", "").toLowerCase();
        int[] arr = new int[129];
        int flag = 0;
        for (char c : str1.toCharArray())
                arr[c]++;
        for (char c : str2.toCharArray())
                arr[c]--;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                flag = 1;
                break;
            }
        }
        if (flag == 0) {
            System.out.println("they are anagrams.");
            // Set<Character> s = new HashSet<>();
            // for (char c : (str1 + str2).toCharArray()) {
            //     if (!((c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z') || (c >= '0' && c <= '9')))
            //         s.add(c);
            //     System.out.println("Unique characters are : " + s.size() + " They are:" + s);
            // }
        }
        else
            System.out.println("Strings not anagrams");
    }
}