import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    static boolean[][] square;

    static int M;
    static int N;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        ArrayList<Integer> areaSize = new ArrayList<>();
        int areaCount = 0;

        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        square = new boolean[M][N];

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int y1 = Integer.parseInt(st.nextToken());
            int x1 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            for (int j = x1; j < x2; j++) {
                for (int k = y1; k < y2; k++) {
                    square[j][k] = true;
                }
            }
        }


        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (!square[i][j]) {
                    areaCount++;
                    areaSize.add(bfs(i, j, 1));
                }
            }
        }
        areaSize.sort((o1, o2) -> o1 - o2);
        System.out.println(areaCount);
        for (Integer i : areaSize) {
            System.out.print(i + " ");
        }


    }

    private static int bfs(int x, int y, int areaSize) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{x, y});

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int cx = poll[0];
            int cy = poll[1];
            square[cx][cy] = true;
            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];
                if (nx < 0 || nx >= M || ny < 0 || ny >= N) continue;
                if (!square[nx][ny]) {
                    square[nx][ny] = true;
                    areaSize++;
                    queue.add(new int[]{nx, ny});
                }
            }


        }

        return areaSize;

    }


}