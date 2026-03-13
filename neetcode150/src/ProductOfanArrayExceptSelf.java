import java.util.Arrays;

public class ProductOfanArrayExceptSelf {
//    product of an array except self : leetcode 238

//    Question 6) Given an integer array nums, return an array answer such that answer[i] is
//    equal to the product of all the elements of nums except nums[i].
//
//The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
//
//You must write an algorithm that runs in O(n) time and without using the division operation.

    public static int[] optimizedSol(int[] arr){
        int[] result = new int[arr.length];

        Arrays.fill(result,1);

        int prefix = 1, postfix =1;

        for(int i=0;i<arr.length;i++){
            result[i] = prefix;
            prefix = arr[i] * prefix;
        }

        for(int i=arr.length-1;i>=0;i--){
            result[i] = result[i]*postfix;
            postfix = arr[i] * postfix;
        }

        return result;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4};
        System.out.println(Arrays.toString(optimizedSol(arr)));
    }
}
