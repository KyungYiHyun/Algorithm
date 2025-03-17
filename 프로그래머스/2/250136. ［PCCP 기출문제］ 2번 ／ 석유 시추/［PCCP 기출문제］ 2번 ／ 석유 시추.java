import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    static int visited[][];
    static int r;
    static int c;
    static int[][] lands;
    static ArrayList<int[]> candidate = new ArrayList<>();
    static ArrayDeque<int[]> queue;
    static ArrayDeque<int[]> secondDeque;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int chknum = 0;

    public int solution(int[][] land) {
        lands = land;
        r = land.length;
        c = land[0].length;
        int[] ans = new int[c];
        visited = new int[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (land[i][j] == 1) {
                    candidate.add(new int[]{i, j});
                }
            }
        }

        for (int[] ints : candidate) {
            if (visited[ints[0]][ints[1]] == 0) {
                bfs(ints[0], ints[1]);
            }
        }


        for (int i = 0; i < c; i++) {
            int chk = -1;
            ArrayList<Integer> temp = new ArrayList<>();
            for (int j = 0; j < r; j++) {
                boolean flag = true;
                if (lands[j][i] != 0 && visited[j][i] != chk) {
                    for (int a : temp) {
                        if (a == visited[j][i]) {
                            flag = false;
                        }
                    }
                    if (flag) {
                        ans[i] += lands[j][i];
                        chk = visited[j][i];
                        temp.add(chk);

                    }

                }
            }
        }
    
        int result = Arrays.stream(ans).max().getAsInt();
        return result;
    }


    public void bfs(int i, int j) {
        queue = new ArrayDeque<>();
        secondDeque = new ArrayDeque<>();
        queue.add(new int[]{i, j});
        secondDeque.add(new int[]{i, j});

        int cnt = 1;
        chknum++;
        visited[i][j] = chknum;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            for (int k = 0; k < 4; k++) {
                int nx = current[0] + dx[k];
                int ny = current[1] + dy[k];
                if (nx < 0 || nx >= r || ny < 0 || ny >= c) {
                    continue;
                }
                if (visited[nx][ny] == 0 && lands[nx][ny] == 1) {
                    visited[nx][ny] = chknum;
                    queue.add(new int[]{nx, ny});
                    cnt++;
                    secondDeque.add(new int[]{nx, ny});
                }
            }

        }

        for (int[] ints : secondDeque) {
            lands[ints[0]][ints[1]] = cnt;
        }
    }

}