import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Permutations {

    public static List<List<Integer>> permutationsBackTrack(List<Integer> currentPermutation, List<Integer> possible, List<List<Integer>> myPermutations){
        if (possible.size() == 0){
            myPermutations.add(currentPermutation);
            return myPermutations;
        }
        for (Integer i: possible){
            ArrayList<Integer> newPossible= new ArrayList<>(possible);
            ArrayList<Integer> realPermutation = new ArrayList<>(currentPermutation);
            newPossible.remove(i);
            realPermutation.add(i);
            permutationsBackTrack(realPermutation, newPossible, myPermutations);
        }
        return myPermutations;
    }

    public static List<List<Integer>> permutations(List<Integer> A) {
        List<List<Integer>> myPremutations = new ArrayList<List<Integer>>();
        List<Integer> current = new ArrayList<>();

        myPremutations = permutationsBackTrack(current, A, myPremutations);


        return myPremutations;
    }

}
