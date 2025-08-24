import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main {

    static int[][] board;
    static int N;
    static boolean[] check;
    static int ans = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        board = new int[N + 1][N + 1];
        check = new boolean[N + 1];
        for (int i = 1; i < N + 1; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j < N + 1; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        combinations(0, 1);
        System.out.println(ans);
    }

    private static void combinations(int depth, int start) {

        if (depth == N / 2) {
            int startTeam = 0;
            int linkTeam = 0;
            for (int i = 1; i < N + 1; i++) {
                for (int j = 1; j < N + 1; j++) {

                    if (check[i] && check[j]) {
                        startTeam += board[i][j];
                    } else if (!check[i] && !check[j]) {
                        linkTeam += board[i][j];
                    }
                }
            }
            ans = Math.min(ans, Math.abs(startTeam - linkTeam));
            return;
        }

        for (int i = start; i < N + 1; i++) {
            check[i] = true;
            combinations(depth + 1, i + 1);
            check[i] = false;
        }
    }


}