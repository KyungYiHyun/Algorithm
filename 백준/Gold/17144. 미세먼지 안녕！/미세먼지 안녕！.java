import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());

        int[][] board = new int[R][C];

        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < C; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        int sx1 = 0;
        int sx2 = 0;
        int cnt = 0;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (board[i][j] == -1 && cnt == 0) {
                    sx1 = i;
                    cnt++;
                }
                if (board[i][j] == -1 && cnt == 1) {
                    sx2 = i;
                }
            }
        }

        int[] dx = new int[]{0, 0, -1, 1};
        int[] dy = new int[]{1, -1, 0, 0};


        while (T > 0) {
            T--;
            int[][] boardSum = new int[R][C];

            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    if (board[i][j] == 0){
                        continue;
                    }
                    int tempCnt = 0;
                    for (int k = 0; k < 4; k++) {
                        int nx = i + dx[k];
                        int ny = j + dy[k];
                        if (nx < 0 || nx >= R || ny < 0 || ny >= C) {
                            continue;
                        }
                        if (board[nx][ny] != -1) {
                            tempCnt++;
                        }
                        boardSum[nx][ny] += board[i][j] / 5;
                    }
                    board[i][j] = board[i][j] -(board[i][j] / 5 * tempCnt);
                }
            }

            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    board[i][j] += boardSum[i][j];
                }
            }

            int[][] newBoard = new int[R][C];
            newBoard[sx1][1] = 0;
            for (int j = 2; j < C; j++) {
                newBoard[sx1][j] = board[sx1][j - 1];
            }
            for (int j = sx1 - 1; j >= 0; j--) {
                newBoard[j][C - 1] = board[j + 1][C - 1];
            }
            for (int j = C - 2; j >= 0; j--) {
                newBoard[0][j] = board[0][j + 1];
            }

            for (int j = 1; j < sx1; j++) {
                newBoard[j][0] = board[j - 1][0];
            }

            newBoard[sx2][1] = 0;
            for (int j = 2; j < C; j++) {
                newBoard[sx2][j] = board[sx2][j - 1];
            }

            for (int j = sx2 + 1; j < R; j++) {
                newBoard[j][C - 1] = board[j - 1][C - 1];
            }
            for (int j = C - 2; j >= 0; j--) {
                newBoard[R - 1][j] = board[R - 1][j + 1];
            }
            for (int j = R - 2; j > sx2; j--) {
                newBoard[j][0] = board[j + 1][0];
            }



            for (int i = 1; i < sx1; i++) {
                for (int j = 1; j < C - 1; j++) {
                    newBoard[i][j] = board[i][j];
                }
            }

            for (int i = sx2 + 1; i < R - 1; i++) {
                for (int j = 1; j < C - 1; j++) {
                    newBoard[i][j] = board[i][j];
                }
            }

            board = newBoard;


         
        }
        int ans = 0;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                ans += board[i][j];
            }
        }
        System.out.println(ans);



    }
}