package algo.recurse;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

public class StringPermNoDups {
    public static void main(String[] args){
     System.out.println(permutations("AAB"));
    }

    private static HashMap<Character, Integer> charCount(String s){
        HashMap<Character, Integer> hm = new HashMap<>();
        for(char c: s.toCharArray()){
            if(hm.containsKey(c)){
                int count = hm.get(c);
                hm.put(c, count+1);
            }
            else{
                hm.put(c, 1);
            }
        }

        return hm;
    }

    private static List<String> permutations(String s){
        HashMap<Character, Integer> charCount = charCount(s);
        List<String> permutations = new ArrayList<>();

        permutations(charCount, "", s.length(), permutations);
        return permutations;
    }

    private static void permutations(HashMap<Character, Integer> charCount,
                                     String prefix,
                                     int remainingChars,
                                     List<String> permutations){
        if(remainingChars == 0){
            permutations.add(prefix);
            return;
        }

        for(char c : charCount.keySet()){
            if(charCount.get(c) > 0){
                int count = charCount.get(c);
                charCount.put(c, count-1);
                permutations(charCount, prefix+c, remainingChars-1, permutations);
                // put the count back again, for the next iteration.
                charCount.put(c, count);
            }
        }
    }
}
