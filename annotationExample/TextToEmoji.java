package annotationExample;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TextToEmoji {
    private static List<String> getEmojieText(String text) {
        boolean contains = false;
        List<String> emojiNames = List.of("##smile","##laugh","##angry");
        List<String> res = new ArrayList<>();
        for(String emoji : emojiNames){
            if(text.contains(emoji)){
                contains = true;
                res.add(emoji.replace("##",""));
            }
        }
        if(contains)
            return res;
        else
            return Collections.emptyList();
    }
    public static void main(String[] args) {
        String text = "hello world ##smile, what a good day!##laugh";
        List<String> emoji = TextToEmoji.getEmojieText(text);
        System.out.println(text);
        if(emoji.isEmpty())
            System.out.println(text);
        else{
            System.out.println(emoji);
            for(String s : emoji){
                text = text.replaceAll("##"+s,"<img src='"+s+".jpg'/>");
            }
            System.out.println(text);
        }
    }
}
