import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[N + 1];
        if (N % 2 == 1) {
            System.out.println(0);
            return;
        }

        dp[2] = 3;

        for (int i = 4; i <= N; i += 2) {
            dp[i] = dp[i - 2] * 3 + 2;
            for (int j = i - 2; j >= 4; j -= 2) {
                dp[i] += 2 * dp[i - j];
            }
        }

        System.out.println(dp[N]);


    }


}


