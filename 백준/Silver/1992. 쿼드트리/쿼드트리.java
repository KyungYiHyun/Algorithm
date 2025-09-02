import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {

    static int[][] board;
    static int N;

    static StringBuilder sb;


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        board = new int[N][N];

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < N; j++) {
                board[i][j] = Character.getNumericValue(s.charAt(j));
            }
        }

        sb = new StringBuilder();
        solve(0, 0, N);
        System.out.println(sb);
    }

    private static void solve(int x, int y, int size) {

        if (check(x, y, size)) {
            sb.append(board[x][y]);
            return;
        }

        sb.append("(");

        solve(x, y, size / 2);
        solve(x, y + size / 2, size / 2);
        solve(x + size / 2, y, size / 2);
        solve(x + size / 2, y + size / 2, size / 2);

        sb.append(")");

    }

    private static boolean check(int x, int y, int size) {

        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if (board[x][y] != board[i][j]) {
                    return false;
                }
            }

        }

        return true;


    }


}