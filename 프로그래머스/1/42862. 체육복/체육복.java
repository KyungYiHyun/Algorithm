import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        boolean[] people = new boolean[n + 2];
        ArrayList<Integer> arr = new ArrayList<>();
        Arrays.fill(people, true);
        Arrays.sort(reserve);

        for (int l : lost) {
            people[l] = false;
        }

        for (int r : reserve){
            boolean flag = false;
            for (int l : lost){
                if (l == r){
                    people[l] = true;
                    flag = true;
                }
            }
            if (!flag){
                arr.add(r);
            }

        }

        for (int num : arr) {
            if (!people[num]) {
                people[num] = true;
                continue;
            }
            if (num == 1) {
                if (!people[num + 1]) {
                    people[num + 1] = true;
                }
                continue;
            }

            if (num == n) {
                if (!people[num - 1]) {
                    people[num - 1] = true;
                }
                continue;
            }
            if (!people[num - 1]) {
                people[num - 1] = true;
                continue;
            }
            if (!people[num + 1]) {
                people[num + 1] = true;
            }


        }

        for (boolean b : people) {
            if (b) {
                answer++;
            }
        }

        return answer - 2;
    }
}