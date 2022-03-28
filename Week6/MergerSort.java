package Week6;

public class MergerSort {
    public static int[] mergeArray(int[] a, int[] b) {
        int[] m = new int[a.length + b.length];
        int i = 0, j = 0, k =0;
        while (i < a.length && j < b.length) {
            if (a[i] <= b[j])
                m[k++] = a[i++];
            else
                m[k++] = b[j++];
        }
        while (i < a.length)
            m[k++] = a[i++];
        while (j < b.length) 
            m[k++] = b[j++];
        return m;
    }
    public static void main(String[] args) {
        int[] a = {56,22,11,89,63,14};
    }
}