package algo.recurse;

import java.util.ArrayList;
import java.util.List;

public class PowerSet {
    public static void main(String[] args){
      List<Integer> set = new ArrayList<>();
      set.add(1);
      set.add(2);
      set.add(3);

      System.out.println(subSets(set));
    }

    private static List<List<Integer>> subSets(List<Integer> set){
        List<List<Integer>> subSets = new ArrayList<>();
        for(int i=0; i < set.size(); i++){
            subSets(set, i, new ArrayList<>(), subSets);
        }

        return subSets;
    }

    private static void subSets(List<Integer> set, int index, List<Integer> subSet, List<List<Integer>> subSets){
        // clone the subSet before adding, else the items will be added to the existing `subSet`
        List<Integer> newSet = new ArrayList<>(subSet);
        newSet.add(set.get(index));
        subSets.add(newSet);

        for(int i=index+1; i < set.size(); i++){
            subSets(set, i, newSet, subSets);
        }
    }
}
