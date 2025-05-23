import java.util.*;
import java.io.*;

public class Main {
    static int dx[] = new int[]{-1, 1, 0, 0};
    static int dy[] = new int[]{0, 0, -1, 1};
    static int N;
    static int L;
    static int R;
    static boolean[][] visited;
    static int[][] board;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        board = new int[N][N];


        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int day = 0;
        while (true) {
            visited = new boolean[N][N];
            int cnt = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (!visited[i][j]) {
                        if (bfs(i, j)) {
                            cnt += 1;
                        }
                    }
                }
            }
            if (cnt == 0) {
                break;
            }
            day += 1;
        }
        System.out.println(day);

    }

    private static boolean bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, y});
        int temp = 0;
        visited[x][y] = true;
        List<int[]> team = new ArrayList<>();
        team.add(new int[]{x, y});

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];
                if (nx < 0 || nx >= N || ny < 0 || ny >= N) {
                    continue;
                }
                int diff = Math.abs(board[nx][ny] - board[cur[0]][cur[1]]);
                if (!visited[nx][ny] && diff <= R && diff >= L) {
                    visited[nx][ny] = true;
                    queue.offer(new int[]{nx, ny});
                    team.add(new int[]{nx, ny});
                }
            }
        }
        if (team.size() <= 1) {
            return false;
        }
        for (int i = 0; i < team.size(); i++) {
            temp += board[team.get(i)[0]][team.get(i)[1]];
        }
        for (int[] pos : team) {
            board[pos[0]][pos[1]] = temp / team.size();
        }
        return true;
    }
}




