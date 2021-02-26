package leetHard;

import java.util.*;

public class FibSeqSplit {
    public List<Integer> splitIntoFibonacci(String S) {
        List<Integer> result = new ArrayList<>();
        backtrack(S, result, 0);
        return result;
    }

    public boolean backtrack(String s, List<Integer> result, int idx) {
        if (s.length() == idx) {
            return result.size() > 2;
        }
        int num = 0;
        for (int i = idx; i < s.length(); i++) {
            num = (num * 10) + (s.charAt(i) - '0');
            if (result.size() < 2 || result.get(result.size() - 1) + result.get(result.size() - 2) == num) {
                result.add(num);
                if (backtrack(s, result, i + 1)) return true;
                result.remove(result.size() - 1);
            }
            if (i == idx && s.charAt(i) == '0') return false;
        }
        return false;
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Set<List<Integer>> result = new HashSet<>();
        recur(candidates, 0, target, new ArrayList<Integer>(), result);
        return new ArrayList<>(result);
    }

    public void recur(int[] candidates, int start, int target, List<Integer> list, Set<List<Integer>> result) {
        if (target < 0) return;
        if (target == 0) {
            Collections.sort(list);
            result.add(new ArrayList<>(list));
        }

        for (int i = start; i < candidates.length; i++) {
            list.add(candidates[i]);
            recur(candidates, i + 1, target - candidates[i], list, result);
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        FibSeqSplit fibSeqSplit = new FibSeqSplit();
        String s = "123456579";
        // System.out.println(fibSeqSplit.splitIntoFibonacci(s));

        int[] arr = {2, 5, 2, 1, 2};
        int target = 5;
        System.out.println(fibSeqSplit.combinationSum2(arr, target));

    }
}
