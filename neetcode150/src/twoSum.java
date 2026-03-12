import java.util.Arrays;
import java.util.HashMap;

public class twoSum {
//    Two sum : leetcode 1
//    Question 3) Given an array of integers nums and a integer target , return indices of the two
//    numbers such that they add upto target.

    public static int[] bruteforce(int[] arr, int target){
        for(int i=0;i<arr.length;i++){

                int remainder = target - arr[i];
                for(int j=i+1;j<arr.length;j++){
                    if(remainder == arr[j]){
                        return new int[]{i,j};
                    }
                }
            }

        return new int[]{-1, -1};

    }

//    now do it with sorting + binary search
    public static int[] sortBSearch(int[] arr, int target){
        Arrays.sort(arr);

        for (int i=0;i<arr.length;i++){
            int remainder = target - arr[i];
            int index = Arrays.binarySearch(arr,i+1,arr.length,remainder);
            if(index>=0){
                return new int[]{i,index};
            }
        }

        return new int[]{-1, -1};
    }

//    the hashmap approch the best one
    public static int[] hashmapapproach(int[] arr,int target){
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<arr.length;i++){
            int complement = target-arr[i];

            if(map.containsKey(complement)){
                return new int[]{map.get(complement),i};
            }
            map.put(arr[i],i);
        }

        return new int[]{-1,-1};
    }



    public static void main(String[] args) {
        int[] arr = {2,5,7,1};
        int target = 9;

        int[] result = bruteforce(arr,target);
//        System.out.println(result[0]+","+result[1]); TC O(n^2)

//        binary search
        int[] bresult = sortBSearch(arr,target);
//        System.out.println(bresult[0]+","+bresult[1]); TC O(n log n)

//        hashmap
        int[] hresult = hashmapapproach(arr, target);
        System.out.println(hresult[0]+","+hresult[1]); //TC O(n)
    }
}
