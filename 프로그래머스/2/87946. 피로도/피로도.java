class Solution {
    private static int[][] dungeon;
    private static int answer;
    private static boolean[] visited;

    private static void backtrack(int cur, int cnt) {

        for (int i = 0; i < dungeon.length; i++) {
            if (!visited[i] && cur >= dungeon[i][0]) {
                visited[i] = true;
                backtrack(cur - dungeon[i][1], cnt + 1);
                visited[i] = false;
                answer = Math.max(answer, cnt + 1);
            }


        }


    }


    public int solution(int k, int[][] dungeons) {
        answer = -1;
        dungeon = dungeons;
        visited = new boolean[dungeons.length];
        backtrack(k, 0);
        return answer;
    }
}