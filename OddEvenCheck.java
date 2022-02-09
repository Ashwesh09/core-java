public class OddEvenCheck {
    void OddEvenCheck(int a){
        if(a%2 == 0)  System.out.println(a+" is Even number.");
        else System.out.println(a+ " is Odd number.");

    }
    public static void main(String[] args) {
        OddEvenCheck oeC = new OddEvenCheck();
        int a = 67;
        oeC.OddEvenCheck(a);
    }
    
}
