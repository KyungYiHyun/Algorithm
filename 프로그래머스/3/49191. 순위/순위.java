import java.util.Arrays;

class Solution {
    public int solution(int n, int[][] results) {
        int answer = 0;
        int[][] board = new int[n][n];
        for (int[] game : results){
            board[game[0] - 1][game[1] - 1] = 1;
            board[game[1] - 1][game[0] - 1] = -1;
        }
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                for (int k = 0; k < n; k++){
                    if (board[j][i] == 1 && board[i][k] == 1){
                        board[j][k] = 1;
                        board[k][j] = -1;
                    }
                    if (board[i][j] == 1 && board[k][i] == 1){
                        board[k][j] = 1;
                        board[j][k] = -1;
                    }
                }
            }
        }
        for (int i = 0; i < n; i++){
            System.out.println(Arrays.toString(board[i]));
        }

        for (int i = 0; i < n; i++){
            int chk = 0;
            for (int j : board[i]){
                if (j != 0){
                    chk++;
                }
            }
            if (chk == n - 1){
                answer++;
            }
        }



        return answer;
    }
}