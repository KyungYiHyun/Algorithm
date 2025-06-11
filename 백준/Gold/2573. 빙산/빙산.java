import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int m;
    static int[][] arr;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static boolean[][] visited;
    static int t = 0;
    static int area = 0;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n][m];
        visited = new boolean[n][m];

        // 입력 받기
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        solve();
        System.out.println(t);
    }

    private static void melt() {
        t++;
        // 미리 배열을 저장하여 1회 순회로 처리
        int[][] newArr = new int[n][m];

        // 얼음이 녹을 만큼 감소시키기
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] != 0) {
                    int meltCnt = 0;
                    for (int k = 0; k < 4; k++) {
                        int nx = i + dx[k];
                        int ny = j + dy[k];
                        if (nx >= 0 && nx < n && ny >= 0 && ny < m && arr[nx][ny] == 0) {
                            meltCnt++;
                        }
                    }
                    newArr[i][j] = Math.max(0, arr[i][j] - meltCnt);
                }
            }
        }

        // 새로운 배열로 갱신
        arr = newArr;
    }

    private static int bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        visited[x][y] = true;
        queue.offer(new int[]{x, y});

        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            int curX = now[0];
            int curY = now[1];

            for (int i = 0; i < 4; i++) {
                int nx = curX + dx[i];
                int ny = curY + dy[i];

                if (nx >= 0 && nx < n && ny >= 0 && ny < m && !visited[nx][ny] && arr[nx][ny] != 0) {
                    queue.offer(new int[]{nx, ny});
                    visited[nx][ny] = true;
                }
            }
        }

        return 1;
    }

    private static void solve() {
        while (area < 2) {
            area = 0;

            // 얼음 녹이기
            melt();

            // 방문 여부 초기화
            for (int i = 0; i < n; i++) {
                Arrays.fill(visited[i], false);
            }

            // bfs로 연결된 얼음 덩어리 찾기
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (arr[i][j] != 0 && !visited[i][j]) {
                        area += bfs(i, j);
                        if (area >= 2) {
                            return;
                        }
                    }
                }
            }

            // 모든 칸이 녹았으면 종료
            int cnt = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (arr[i][j] == 0) {
                        cnt++;
                    }
                }
            }

            if (cnt == n * m) {
                t = 0;
                return;
            }
        }
    }
}
