import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[n + 1];
        int[] grapes = new int[n + 1];
        for (int i = 1; i < n + 1; i++) {
            grapes[i] = Integer.parseInt(br.readLine());
        }


        for (int i = 1; i < n + 1; i++) {
            if (i == 1) dp[i] = grapes[i];
            else if (i == 2) dp[i] = grapes[i - 1] + grapes[i];
            else {
                dp[i] = Math.max(dp[i - 1], Math.max(dp[i - 2] + grapes[i], grapes[i] + dp[i - 3] + grapes[i - 1]));
            }
        }

        System.out.println(dp[n]);


    }


}