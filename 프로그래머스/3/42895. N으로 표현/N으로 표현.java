import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

class Solution {
    private static void unionSet(Set<Integer> unionSet, Set<Integer> s1, Set<Integer> s2) {
        for (int n1 : s1) {
            for (int n2 : s2) {
                unionSet.add(n1 + n2);
                unionSet.add(n1 - n2);
                unionSet.add(n1 * n2);
                if (n2 != 0) {
                    unionSet.add(n1 / n2);
                }
            }
        }
    }


    public int solution(int N, int number) {
        ArrayList<Set<Integer>> dp = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            dp.add(new HashSet<>());
        }
        dp.get(1).add(N);
        if (N == number){
            return 1;
        }
        for (int i = 2; i < 9; i++) {
            for (int j = 1; j <= i / 2; j++) {
                unionSet(dp.get(i), dp.get(j), dp.get(i - j));
                unionSet(dp.get(i), dp.get(i - j), dp.get(j));
            }
            String n = Integer.toString(N);
            dp.get(i).add(Integer.parseInt(n.repeat(i)));

            for (int num : dp.get(i)) {
                if (num == number) {
                    return i;
                }
            }
        }
        return -1;
    }
}