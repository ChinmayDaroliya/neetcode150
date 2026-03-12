import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class groupAnagrams {

//    Group anagram : leetcode 49
//    Question 4) given an array of strings strs, group the anagrams together you can return the answer
//    in any order.

    public static List<List<String>> groupAnagram(String[] arr){
        if(arr.length == 0){
            return new ArrayList<>();
        }

        HashMap<String,List<String>> map = new HashMap<>();

        int[] count = new int[26];

        for(String s:arr){
            Arrays.fill(count,0);
            for(char c: s.toCharArray()){
                count[c-'a']++;
            }

            StringBuilder sb = new StringBuilder();

            for(int i=0;i<26;i++){
                sb.append("#");
                sb.append(count[i]);
            }

            String key = sb.toString();

            if(!map.containsKey(key)){
                map.put(key,new ArrayList<>());
            }
            map.get(key).add(s);
        }

        return new ArrayList<>(map.values());
    }

    public static void main() {
        String[] arr = {"eat","tea","tan","ate","nat","bat"};

        List<List<String>> l = groupAnagram(arr);
        System.out.println(l);

    }
}
