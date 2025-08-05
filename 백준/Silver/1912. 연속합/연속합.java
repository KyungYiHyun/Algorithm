import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;



public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int[] numbers = new int[n];
        int[] dp = new int[n];


        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }
        dp[0] = numbers[0];
        int ans = numbers[0];


        for (int i = 1; i < n; i++) {
            dp[i] = Math.max(numbers[i], dp[i - 1] + numbers[i]);
            ans = Math.max(dp[i], ans);
        }

        System.out.println(ans);


    }
}