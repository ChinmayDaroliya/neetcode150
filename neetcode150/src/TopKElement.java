import java.util.*;

public class TopKElement {
//    Top k element : leetcode 357
//    Question 5) given an integer array nums and an integer k , return the k most frequent elements.
//    you may return the answers in any order

    public static int[] interviewApproch(int[] arr, int k){
        if(k == arr.length){
            return arr;
        }

        HashMap<Integer,Integer> count = new HashMap<>();
        for(int n:arr){
            count.put(n,count.getOrDefault(n,0)+1);
        }
//        here we can use this as comparator (a,b) -> count.get(a) - count.get(b) but the ide is suggesting this
//        Comparator.comparingInt(count::get) so we are using this one
        Queue<Integer> heap = new PriorityQueue<>(Comparator.comparingInt(count::get));

        for(int n:count.keySet()){
            heap.add(n);
            if(heap.size()>k){
                heap.poll();
            }
        }

        int[] result = new int[k];

        for(int i=0;i<k;i++){
            result[i] = heap.poll();
        }

        return result;
    }

    public static void main(String[] args){
        int[] arr = {1,1,1,2,2,3,3,3,3};
        int k = 2;

        System.out.println(Arrays.toString(interviewApproch(arr,2)));
    }
}
