public class validAnagram {
//    leetcode 242
//    Question 2) given 2 strings s and t , return true if t is an anagram of sand false otherwise.

    public static boolean bruteforceapproach(String s, String t){
        if(s.length() != t.length()){
            return false;
        }

        char[] arr = t.toCharArray();

        for(int i=0;i<s.length();i++){
            boolean found = false;
            for (int j= 0; j<t.length() ;j++){
                if(s.charAt(i) == t.charAt(j)){
                    arr[j] = '#';
                    found = true;
                    break;
                }
            }
            if(!found){
                return  false;
            }
        }

        return true;


    }

    public static boolean usingArray(String s, String t){

        if(s.length() != t.length()){
            return false;
        }

//        as english alphabets has 26 letters
        int[] charCount = new int[26];

//        s will increase its alphates and t will decrese its , in the end it the charcount array
//        value remains 0 then both the string has same characers
        for(int i=0;i<s.length() ; i++){
            charCount[s.charAt(i) - 'a']++;
            charCount[t.charAt(i) - 'a']--;
        }

        for(int count: charCount){
            if(count != 0){
                return false;
            }
        }

        return true;


    }

    public static void main() {
        String s = "cart";
        String t = "trac";

//        System.out.println(bruteforceapproach(s,t)); TC O(n^2)
//        System.out.println(usingArray(s,t)); TC O(n)
    }
}

