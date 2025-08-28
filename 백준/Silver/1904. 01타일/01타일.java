import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main {

    static int[][] plan;

    static int N;
    static int ans = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[N];

        for (int i = 0; i < N; i++) {
            if (i == 0) {
                dp[i] = 1;
                continue;
            }
            if (i == 1) {
                dp[i] = 2;
                continue;
            }
            dp[i] = (dp[i - 1] % 15746 + dp[i - 2] % 15746) % 15746;
        }

        System.out.println(dp[N - 1]);

    }


}