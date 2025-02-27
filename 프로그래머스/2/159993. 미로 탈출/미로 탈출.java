import java.util.ArrayDeque;
import java.util.Arrays;

class Solution {
    private static class Node {
        int x, y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private static int[][] visited;
    private static final int[] dx = {-1, 1, 0, 0};
    private static final int[] dy = {0, 0, -1, 1};
    private static int r;
    private static int c;
    private static String map[];

    private static int bfs(Node s, Node e) {
        visited = new int[r][c];
        for (int[] v : visited) {
            Arrays.fill(v, -1);
        }
        ArrayDeque<Node> queue = new ArrayDeque<>();
        queue.add(s);
        visited[s.x][s.y] = 0;

        while (!queue.isEmpty()) {
            Node cur = queue.pollFirst();

            if (cur.x == e.x && cur.y == e.y) {
                return visited[e.x][e.y];
            }

            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if (nx < 0 || nx >= r || ny < 0 || ny >= c) {
                    continue;
                }
                if (visited[nx][ny] == -1 && (map[nx].charAt(ny) == 'O' || map[nx].charAt(ny) == 'E' || map[nx].charAt(ny) == 'L' || map[nx].charAt(ny) == 'S')){
                    visited[nx][ny] = visited[cur.x][cur.y] + 1;
                    queue.add(new Node(nx, ny));
                }

            }


        }

        return -1;

    }


    public int solution(String[] maps) {
        int answer = 0;
        map = maps;
        r = maps.length;
        c = maps[0].length();
        Node start = null;
        Node lever = null;
        Node end = null;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (maps[i].charAt(j) == 'S') {
                    start = new Node(i, j);
                }
                if (maps[i].charAt(j) == 'L') {
                    lever = new Node(i, j);
                }
                if (maps[i].charAt(j) == 'E') {
                    end = new Node(i, j);
                }
            }
        }

        int leverDist = bfs(start, lever);
        int endDist = bfs(lever, end);

        if (leverDist == -1 || endDist == -1){
            answer = -1;
        }
        else {
            answer = leverDist + endDist;
        }


        return answer;
    }
}