import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashSet;
//leetcode 217
// QUESTION: 1) given an integer array nums, return true if any value  appears atleast twice in
// the array and return false if every element is distinct.

public class containsDuplicate {
    public static boolean bruteForceApproach(int[] nums){
        for(int i=0;i<nums.length;i++){
            for (int j=i+1 ; j<nums.length;j++){
                if(nums[i]==nums[j]){
                    return true;
                }
            }
        }
        return  false;
    }

    public static boolean sortArray(int[] nums){
//        TC of sort is nlogn
        Arrays.sort(nums);
        for (int i=0 ; i<nums.length-1;i++){
            if (nums[i] == nums[i+1]){
                return true;
            }
        }
        return false;
    }

    public static boolean usinghashset(int[] nums){
//        creating a hashset
        HashSet<Integer> hasharray = new HashSet<>();
        for(int i:nums){
            if(hasharray.contains(i)){
                return true;
            }
            hasharray.add(i);
        }

        return false;
}

    public static void main() {
        int[] nums = {1,2,3,4,3};
//        System.out.println(bruteForceApproach(nums)); TC O(n^2)
//        System.out.println(sortArray(nums)); TC O(nlogn)
          System.out.println(usinghashset(nums)); //TC )(n) best approach

    }
}
