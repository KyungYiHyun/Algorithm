import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] scores = new int[N];
        for (int i = 0; i < N; i++) {
            int n = Integer.parseInt(br.readLine());
            scores[i] = n;
        }
        int ans = 0;
        for (int i = N - 1; i > 0; i--) {
            if (scores[i] <= scores[i - 1]) {
                ans += scores[i - 1] - scores[i] + 1;
                scores[i - 1] = scores[i] - 1;
            }
        }

        System.out.println(ans);

    }


}


