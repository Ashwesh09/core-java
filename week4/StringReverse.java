package week4;

import java.util.ArrayList;

public class StringReverse {
    public static void main(String[] args) {
        String in = "India Is my country";
        ArrayList<Integer> space = new ArrayList<>();
        for (int i = 0; i < in.length(); i++) {
            if (in.charAt(i) == ' ')
                space.add(i);
        }
        String temp = in.replaceAll("\\s", "");
        StringBuilder res = new StringBuilder("");
        for (int i = 0; i < temp.length(); i++) {
            res.append(temp.charAt(temp.length() - i - 1));
        }
        for (int i = 0; i < space.size(); i++) {
            res.insert(space.get(i), " ");
        }
        System.out.println(res);
    }
}
