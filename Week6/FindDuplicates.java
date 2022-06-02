package Week6;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class FindDuplicates {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7};
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;
        boolean hasDuplicates = false;
        for(int i = 0; i < arr.length; i++){
            if(map.containsKey(arr[i])){
                count = map.get(arr[i]);
                map.put(arr[i],count + 1);
            }
            else{
                map.put(arr[i],1);
            }
        }
        for(Entry<Integer,Integer> entrySet : map.entrySet()){
                if(entrySet.getValue()>1){
                    System.out.println(entrySet.getKey()+" ");
                    hasDuplicates = true;
                }
        }
        if (!hasDuplicates) {
            System.out.println("Array does not have duplicates");
        }
    }
}
