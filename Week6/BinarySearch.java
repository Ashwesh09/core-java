package Week6;

import java.util.Arrays;

public class BinarySearch {
    private static int binarySearch(int[] a, int low , int high,int find) {
        if (high >= low) {
            int mid = (low + high) / 2;
            if(a[mid] == find)
                return mid;
            else if(a[mid] < find)
                return binarySearch(a, mid + 1, high, find);
            else if(a[mid] > find)
                return binarySearch(a, low, mid - 1, find);
        }
        return -1;
    }
    private static void merge(int[] a,int left,int right, int mid){
        int n1 = mid - left + 1;
        int n2 = right - mid;
  
        /* Create temp arrays */
        int L[] = new int[n1];
        int R[] = new int[n2];
  
        /*Copy data to temp arrays*/
        for (int i = 0; i < n1; ++i)
            L[i] = a[left + i];
        for (int j = 0; j < n2; ++j)
            R[j] = a[mid + 1 + j];
        int i = 0 ,j = 0;
        int k = left;
        while(i < n1 && j < n2){
            if(L[i] <= R[j])
                a[k++] = L[i++];
            else
                a[k++] = R[j++];
        }
        while(i < n1){
            a[k++] = L[i++];
        }
        while(j < n2){
            a[k++] = R[j++];
        }
    }
    private static void mergeSort(int[] a, int left,int right){
        if(left < right){
            int mid = left + (right -left )/ 2;
            mergeSort(a,left,mid);
            mergeSort(a,mid+1,right);
            merge(a,left,right,mid);
        }
    }
    public static void main(String[] args) {
        int[] a = {9,8,7,6,5,4,3,2,1};
        mergeSort(a,0,a.length-1);
        System.out.println(Arrays.toString(a));
    }
}
