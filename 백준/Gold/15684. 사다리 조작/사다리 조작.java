import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    static int[][] board;
    static int n;
    static int h;
    static int ans;


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());
        board = new int[h][n];
        ans = 4;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            board[a - 1][b - 1] = 1;
        }
        solve(0, 0);
        System.out.println(ans == 4 ? -1 : ans);
    }

    private static void solve(int depth, int idx) {

        if (depth > 3 || depth > ans) {
            return;
        }

        if (game()) {
            ans = Math.min(ans, depth);
            return;
        }

        for (int i = idx; i < h; i++) {
            for (int j = 0; j < n - 1; j++) {
                if (j == 0) {
                    if (board[i][j] == 0 && board[i][j + 1] == 0) {
                        board[i][j] = 1;
//                        System.out.println(Arrays.deepToString(board));
//                        System.out.println("depth = " + depth);
                        solve(depth + 1, i);
                        board[i][j] = 0;
                    }
                } else {
                    if (board[i][j] == 0 && board[i][j + 1] == 0 && board[i][j - 1] == 0) {
                        board[i][j] = 1;
//                        System.out.println(Arrays.deepToString(board));
//                        System.out.println("depth = " + depth);
                        solve(depth + 1, i);
                        board[i][j] = 0;
                    }
                }

            }
        }
    }

    private static boolean game() {
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            int startX = 0;
            int startY = i;
            while (true) {
//                System.out.println("startX = " + startX);
//                System.out.println("startY = " + startY);
//                System.out.println("i = " + i);
                if (board[startX][startY] == 1) {
                    startY++;
                } else if (startY > 0 && board[startX][startY - 1] == 1) {
                    startY--;
                }
                startX++;
                if (startX == h) {
//                    System.out.println("cnt = " + cnt);
                    if (startY == i) {
                        cnt++;
//                        System.out.println("cnt = " + cnt);
                        if (cnt == n) return true;
                        break;
                    } else {
                        return false;
                    }

                }

            }
        }
        return false;

    }


}





