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
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());

        plan = new int[N][2];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            plan[i][0] = Integer.parseInt(st.nextToken());
            plan[i][1] = Integer.parseInt(st.nextToken());
        }

        dfs(0, 0);
        System.out.println(ans);

    }

    private static void dfs(int day, int money) {

        if (day >= N) {
            ans = Math.max(ans, money);
            return;
        }

        if (day + plan[day][0] <= N) {
            dfs(day + plan[day][0], money + plan[day][1]);
        } else {
            dfs(day + plan[day][0], money);
        }

        dfs(day + 1, money);
    }


}