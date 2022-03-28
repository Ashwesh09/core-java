import java.util.Scanner;

public class ArrayUnion {
    static boolean binarySearch(int[] arr, int k, int f, int l) {
        if (l >= f) {
            int m = f + (l - f) / 2;
            if (k == arr[m])
                return true;
            else if (k < arr[m])
                return binarySearch(arr, k, f, m - 1);
            return binarySearch(arr, k, m + 1, l);
        }
        return false;
    }

    static int findMergedArrCount(int[] a, int[] b, int n, int m) {
        int count = n;
        for (int i = 0; i < m; i++) {
            if (binarySearch(a, b[i], 0, m - 1))
                continue;
            count++;
        }
        return count;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] a = new int[n];
        int[] b = new int[m];
        for (int i = 0; i < n; i++) 
            a[i] = sc.nextInt();
        for (int i = 0; i < m; i++)
            b[i] = sc.nextInt();
        System.out.println(findMergedArrCount(a, b, n, m));
        sc.close();
    }
}