import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[][] board;
    static int minusOne;
    static int zero;
    static int one;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        board = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        minusOne = 0;
        zero = 0;
        one = 0;
        recur(0, 0, N);
        System.out.println(minusOne);
        System.out.println(zero);
        System.out.println(one);

    }

    private static void recur(int row, int col, int size) {

        int cri = board[row][col];
        if (check(row, col, size, cri)) {
            if (cri == 0) {
                zero++;
            } else if (cri == 1) {
                one++;
            } else {
                minusOne++;
            }
            return;
        }

        int newSize = size / 3;
        recur(row, col, newSize);
        recur(row, col + newSize, newSize);
        recur(row, col + newSize * 2, newSize);

        recur(row + newSize, col, newSize);
        recur(row + newSize, col + newSize, newSize);
        recur(row + newSize, col + newSize * 2, newSize);

        recur(row + newSize * 2, col, newSize);
        recur(row + newSize * 2, col + newSize, newSize);
        recur(row + newSize * 2, col + newSize * 2, newSize);


    }

    private static boolean check(int row, int col, int size, int cri) {
        for (int i = row; i < row + size; i++) {
            for (int j = col; j < col + size; j++) {
                if (board[i][j] != cri) {
                    return false;
                }
            }
        }
        return true;
    }


}
