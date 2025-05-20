import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

class Main {
    static int n;
    static int m;
    static Node[][] board;

    static int[] dx = {0, -1, -1, -1, 0, 1, 1, 1};
    static int[] dy = {-1, -1, 0, 1, 1, 1, 0, -1};

    static int[] daegakDx = {1, 1, -1, -1};
    static int[] daegakDy = {1, -1, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());


        board = new Node[n][n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                boolean first = false;
                if (i == n - 1 && j == 0) {
                    first = true;
                }
                if (i == n - 2 && j == 1) {
                    first = true;
                }
                if (i == n - 1 && j == 1) {
                    first = true;
                }
                if (i == n - 2 && j == 0) {
                    first = true;
                }
                board[i][j] = new Node((Integer.parseInt(st2.nextToken())), first);
            }
        }

        // 자기 위치 + 이동할 거리 % n = 현재 위치


        for (int i = 0; i < m; i++) {
            StringTokenizer st3 = new StringTokenizer(br.readLine());
            Integer direction = Integer.parseInt(st3.nextToken());
            Integer distance = Integer.parseInt(st3.nextToken());
            ArrayList<int[]> cors = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                for (int l = 0; l < n; l++) {
                    if (board[j][l].isCloud()) {
                        int nx = (j + dx[direction - 1] * distance) % n;
                        int ny = (l + dy[direction - 1] * distance) % n;
                        nx = (nx + n) % n;
                        ny = (ny + n) % n;
                        cors.add(new int[]{nx, ny});
                    }
                }
            }

            for (int j = 0; j < n; j++) {
                for (int l = 0; l < n; l++) {
                    board[j][l].cloud = false;
                }
            }

            for (int[] cor : cors) {
                board[cor[0]][cor[1]].cloud = true;
            }


            for (int j = 0; j < n; j++) {
                for (int l = 0; l < n; l++) {
                    if (board[j][l].isCloud()) {
                        board[j][l].value++;
                    }
                }
            }

            for (int j = 0; j < n; j++) {
                for (int l = 0; l < n; l++) {
                    if (board[j][l].isCloud()) {
                        for (int a = 0; a < 4; a++) {
                            int nx = j + daegakDx[a];
                            int ny = l + daegakDy[a];
                            if (nx < 0 || nx >= n || ny < 0 || ny >= n) {
                                continue;
                            }
                            if (board[nx][ny].value > 0) {
                                board[j][l].value++;
                            }
                        }
                    }

                }
            }

            for (int j = 0; j < n; j++) {
                for (int l = 0; l < n; l++) {
                    if (board[j][l].cloud) {
                        board[j][l].cloud = false;
                    } else if (!board[j][l].cloud && board[j][l].value >= 2) {
                        board[j][l].cloud = true;
                        board[j][l].value -= 2;

                    }


                }
            }

        }
        int answer = 0;
        for (int j = 0; j < n; j++) {
            for (int l = 0; l < n; l++) {
                answer += board[j][l].value;
            }
        }
        System.out.println(answer);

    }

    public static class Node {
        public int value;
        public boolean cloud;

        public Node(int value, boolean cloud) {
            this.value = value;
            this.cloud = cloud;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "value=" + value +
                    ", cloud=" + cloud +
                    '}';
        }

        public boolean isCloud() {
            return cloud;
        }
    }

}