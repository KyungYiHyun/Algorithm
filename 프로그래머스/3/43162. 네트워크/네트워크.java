import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    private static boolean visited[];
    private static int l;

    private static boolean dfs(int depth, ArrayList<Integer>[] list){

        if (depth == l){
            return true;
        }

        ArrayList<Integer> cur = list[depth];

        for (Integer i : cur) {
            if (!visited[i]){
                visited[i] = true;
                dfs(i,list);
            }
        }
        return true;
    }



    public int solution(int n, int[][] computers) {
        int answer = 0;
        l = n;
        visited = new boolean[n];
        ArrayList<Integer>[] adgList = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adgList[i] = new ArrayList<>();
        }

        for (int i = 0; i < computers.length; i++) {
            for (int j = 0; j < computers[i].length; j++) {
                if (i == j) {
                    continue;
                }
                if (computers[i][j] == 1) {
                    adgList[i].add(j);
                }

            }

        }

        for (int i = 0; i < n; i++){
            if (!visited[i] && dfs(i,adgList)){
                answer++;
            }
        }



        return answer;
    }
}