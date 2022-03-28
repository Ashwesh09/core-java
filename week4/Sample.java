package week4;

import java.util.*;
 
public class Sample
{
    // Function to find a pair in an array with a given sum using hashing
    public static void findDuplicates(int[] nums)
    {
        // create an empty HashMap
        List<Integer> map = Arrays.asList(nums);
 
        // do for each element
        for (int i = 0; i < nums.length; i++)
        {
            // check if pair (nums[i], target-nums[i]) exists
 
            // if the difference is seen before, print the pair
            if (map.remove(nums[i]) == -1)
            {
                System.out.printf("Duplicate element (%d)%n",
                    nums[map.get(i)]);
                //return;
            }
 
            // store index of the current element in the map
            map.put(nums[i], i);
        }
 
        // we reach here if the pair is not found
        //System.out.println("Pair not found");
    }
 
    public static void main (String[] args)
    {
        int[] nums = {11,1,10,7,3,9,7,4,8,11 };
 
        findDuplicates(nums);
    }
}