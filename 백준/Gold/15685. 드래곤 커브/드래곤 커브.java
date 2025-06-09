import java.awt.image.RasterOp;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int result = 0;
        int[] dx = new int[]{0, -1, 0, 1};
        int[] dy = new int[]{1, 0, -1, 0};
        int[][] board = new int[101][101];
        int N = Integer.parseInt(br.readLine());
        while (N-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            ArrayList<Integer> directions = new ArrayList<>();
            int y = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int g = Integer.parseInt(st.nextToken());

            directions.add(d);
            board[x][y] = 1;
            while (g-- > 0) {
                for (int i = directions.size() - 1; i >= 0; i--) {
                    directions.add((directions.get(i) + 1) % 4);
                }
            }

            for (int i = 0; i < directions.size(); i++) {
                x += dx[directions.get(i)];
                y += dy[directions.get(i)];
                if (x < 0 || x >= 101 || y < 0 || y >= 101) continue;
                board[x][y] = 1;
            }


        }

        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                if (board[i][j] == 1 && board[i + 1][j] == 1 && board[i][j + 1] == 1 && board[i + 1][j + 1] == 1) {
                    result += 1;
                }
            }
        }
        System.out.println(result);

    }

}
