package Week6;

public class ReverseIndWords {
    static String rev(String s){
        StringBuilder sb = new StringBuilder();
        sb.append(s);
        sb.reverse();
        return sb.toString();
    }
    public static void main(String[] args) {
        String input = "My name is Ashwesh";
        String[] arrS = input.split("\\s");
        for(String s : arrS) {
            System.out.print(rev(s)+" ");
        }
    }
}
