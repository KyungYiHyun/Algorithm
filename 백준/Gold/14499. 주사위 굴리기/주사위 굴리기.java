

import java.io.*;
import java.util.*;

public class Main {
    static int n, m, x, y, k;
    static int[][] board;
    static int[] dx = {0, 0, -1, 1}; // 동서북남
    static int[] dy = {1, -1, 0, 0};

    static class Dice {
        int top, bottom, left, right, front, back;

        public Dice() {
            top = bottom = left = right = front = back = 0;
        }

        public void roll(int dir) {
            int temp;
            switch (dir) {
                case 1: // 동쪽
                    temp = top;
                    top = left;
                    left = bottom;
                    bottom = right;
                    right = temp;
                    break;
                case 2: // 서쪽
                    temp = top;
                    top = right;
                    right = bottom;
                    bottom = left;
                    left = temp;
                    break;
                case 3: // 북쪽
                    temp = top;
                    top = front;
                    front = bottom;
                    bottom = back;
                    back = temp;
                    break;
                case 4: // 남쪽
                    temp = top;
                    top = back;
                    back = bottom;
                    bottom = front;
                    front = temp;
                    break;
            }
        }

        public int getTop() {
            return top;
        }

        public int getBottom() {
            return bottom;
        }

        public void setBottom(int value) {
            bottom = value;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        board = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        Dice dice = new Dice();
        for (int i = 0; i < k; i++) {
            int dir = Integer.parseInt(st.nextToken());
            int nx = x + dx[dir - 1];
            int ny = y + dy[dir - 1];

            if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;

            x = nx;
            y = ny;

            dice.roll(dir);

            if (board[x][y] == 0) {
                board[x][y] = dice.getBottom();
            } else {
                dice.setBottom(board[x][y]);
                board[x][y] = 0;
            }

            System.out.println(dice.getTop());
        }
    }
}
