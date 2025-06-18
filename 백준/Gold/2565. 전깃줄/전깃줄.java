import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int[][] lopes = new int[n][2];
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            lopes[i][0] = a;
            lopes[i][1] = b;
        }

        Arrays.sort(lopes, (int[] o1, int[] o2) -> o1[0] - o2[0]);

        for (int i = 0; i < n; i++) {


            for (int j = 0; j < i; j++) {
                if (lopes[j][1] < lopes[i][1]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        int max = 0;
        for (int i : dp) {
            max = Math.max(i, max);
        }

        System.out.println(n - max);

    }


}
