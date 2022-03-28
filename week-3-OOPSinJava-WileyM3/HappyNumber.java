import java.util.Scanner;

public class HappyNumber {
    boolean isHappy(int n) {
        int sum = n;
        int temp = n;
        if (temp == 1 || temp == 7)
            return true;
        while (!(sum >= 0 && sum <= 9)) {
            sum = 0;
            while (temp > 0) {
                sum += Math.pow(temp % 10, 2);
                temp /= 10;
            }
            if (sum == 1)
                return true;
            temp = sum;
        }
        return false;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HappyNumber hp = new HappyNumber();
        int k = sc.nextInt();
        for (int i = 0; i < k; i++) {
            if(hp.isHappy(i))
                System.out.println(i+" ");
        }
        sc.close();
    }
}
