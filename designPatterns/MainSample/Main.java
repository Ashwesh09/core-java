package designPatterns.MainSample;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner; 

class  UserMainCode{
    
    private UserMainCode() {
    }

    protected static int getSumOfEven(HashMap<Integer, Integer> map){
        int sum = 0;
        System.out.println("in getSumOfEven");
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            if(entry.getKey()%2 == 0)   
                sum+= entry.getValue();
            System.out.println("sum is " + sum);
        }
        return sum;
    }
}
public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        HashMap<Integer,Integer> map = new HashMap<>();
        int inputs = sc.nextInt();
        for(int i = 0; i < inputs; i++){
            map.put(sc.nextInt(),sc.nextInt());
            System.out.println("Done at " + (i+1));
        }
        System.out.println(UserMainCode.getSumOfEven(map));
    }
}
