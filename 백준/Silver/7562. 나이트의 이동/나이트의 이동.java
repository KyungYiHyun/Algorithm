import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static int n;
    static boolean[][] visited;
    static int[] dx = {-2, -2, 2, 2, 1, -1, 1, -1};
    static int[] dy = {1, -1, 1, -1, 2, 2, -2, -2};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start_x = Integer.parseInt(st.nextToken());
            int start_y = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            int end_x = Integer.parseInt(st.nextToken());
            int end_y = Integer.parseInt(st.nextToken());
            visited = new boolean[n][n];
            System.out.println(bfs(start_x, start_y, end_x, end_y));
        }
    }

    public static int bfs(int start_x, int start_y, int end_x, int end_y) {
        Queue<Node> queue = new LinkedList<>();
        visited[start_x][start_y] = true;
        if (start_x == end_x && start_y == end_y) {
            return 0;
        }
        Node node = new Node(start_x, start_y, 0);
        queue.add(node);
        while (!queue.isEmpty()) {
            Node current = queue.poll();
            for (int i = 0; i < 8; i++) {
                int nx = current.x + dx[i];
                int ny = current.y + dy[i];
                if (nx < 0 || nx >= n || ny < 0 || ny >= n) {
                    continue;
                }
                if (!visited[nx][ny]) {
                    if (nx == end_x && ny == end_y) {
                        return current.count + 1;
                    } else {
                        visited[nx][ny] = true;
                        queue.add(new Node(nx, ny, current.count + 1));
                    }
                }

            }

        }
        return -1;
    }

    static class Node {
        int x;
        int y;
        int count;

        public Node(int x, int y, int count) {
            this.x = x;
            this.y = y;
            this.count = count;
        }
    }
}

