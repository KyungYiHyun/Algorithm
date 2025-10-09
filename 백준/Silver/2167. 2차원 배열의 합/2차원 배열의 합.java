import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] board = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 1; j < M; j++) {
                board[i][j] += board[i][j - 1];
            }
        }

        int K = Integer.parseInt(br.readLine());
        for (int i = 0; i < K; i++) {
            int sum = 0;
            st = new StringTokenizer(br.readLine());
            int rowA = Integer.parseInt(st.nextToken());
            int colA = Integer.parseInt(st.nextToken());
            int rowB = Integer.parseInt(st.nextToken());
            int colB = Integer.parseInt(st.nextToken());

            for (int j = rowA - 1; j < rowB; j++) {
                if (colA == 1) {
                    sum += board[j][colB - 1];
                } else {
                    sum += board[j][colB - 1] - board[j][colA - 2];
                }

            }
            System.out.println(sum);
        }

    }


}
