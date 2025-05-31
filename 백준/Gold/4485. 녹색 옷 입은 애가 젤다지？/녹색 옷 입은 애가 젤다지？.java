import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;


public class Main {

    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};

    static class Node {
        private int x;
        private int y;
        private int dist;

        public Node(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t = 1;
        while (true) {
            int n = Integer.parseInt(br.readLine());
            if (n == 0) break;
            int[][] board = new int[n][n];
            int[][] distance = new int[n][n];
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    board[i][j] = Integer.parseInt(st.nextToken());
                    distance[i][j] = 1000000;
                }
            }
            PriorityQueue<Node> queue = new PriorityQueue<>(Comparator.comparing((o) -> o.dist));
            queue.add(new Node(0, 0, board[0][0]));
            distance[0][0] = board[0][0];

            while (!queue.isEmpty()) {
                Node node = queue.poll();
                int cx = node.x;
                int cy = node.y;
                int dist = node.dist;
                for (int i = 0; i < 4; i++) {
                    int nx = cx + dx[i];
                    int ny = cy + dy[i];
                    if (nx < 0 || nx >= n || ny < 0 || ny >= n) continue;

                    if (dist > distance[nx][ny]) continue;

                    if (distance[nx][ny] > board[nx][ny] + dist) {
                        distance[nx][ny] = board[nx][ny] + dist;
                        queue.add(new Node(nx, ny, distance[nx][ny]));
                    }
                }
            }

            System.out.printf("Problem %d: %d%n", t, distance[n - 1][n - 1]);
            t++;

        }
    }
}





