package algo.recurse;

import java.util.ArrayList;
import java.util.List;

public class StringPerm {
    public static void main(String[] args) {
       // perm("ABCD");
        System.out.println(perm2("ABC"));
       // System.out.println(perm2("AAB"));
    }

    private static void perm(String s) {
        perm(s, "");
    }

    private static void perm(String s, String permStr) {
        if (s.isEmpty()) {
            System.out.println(permStr);
        } else {
            for (int i = 0; i < s.length(); i++) {
                String curPerm = permStr + s.charAt(i);
                String remStr = s.substring(0, i) + s.substring(i + 1);
                perm(remStr, curPerm);
            }
        }
    }

    private static List<String> perm2(String s){

        if(s == null) return new ArrayList<>();
        List<String> permutations = new ArrayList<>();

        if(s.isEmpty()){
            permutations.add("");
            return permutations;
        }

        char first = s.charAt(0);

        String remaining = s.substring(1);

        List<String> permList = perm2(remaining);

        for(String word: permList){
            // insert char at every position in the word.
            insertCharIn(word, first, permutations);
        }

        return permutations;
    }

    private static void insertCharIn(String word, char first, List<String> permutations){
        for(int i=0; i <= word.length(); i++){
            String start = word.substring(0,i);
            String end = word.substring(i);
            String newWord = start+first+end;
            permutations.add(newWord);
        }
    }

}
