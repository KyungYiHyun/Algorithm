import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, -1, 1};


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        char[][] map = new char[N][M];
        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = input.charAt(j);
            }
        }

        int[][] visited = new int[N][M];


        int ans = 0;

        Queue<int[]> queue = new ArrayDeque<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 'L') {
                    for (int l = 0; l < N; l++) {
                        Arrays.fill(visited[l], -1);
                    }
                    queue.offer(new int[]{i, j});
                    visited[i][j] = 0;

                    while (!queue.isEmpty()) {
                        int[] poll = queue.poll();
                        int cx = poll[0];
                        int cy = poll[1];

                        for (int k = 0; k < 4; k++) {
                            int nx = cx + dx[k];
                            int ny = cy + dy[k];
                            if (nx < 0 || nx >= N || ny < 0 || ny >= M) {
                                continue;
                            }

                            if (map[nx][ny] == 'L' && visited[nx][ny] == -1) {
                                queue.offer(new int[]{nx, ny});
                                visited[nx][ny] = visited[cx][cy] + 1;
                                ans = Math.max(ans, visited[nx][ny]);
                            }

                        }

                    }


                }

            }
        }

        System.out.println(ans);


    }


}
