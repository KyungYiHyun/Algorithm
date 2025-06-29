import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    static int n;
    static int maxAns;
    static int minAns;
    static int[] operator;
    static int[] nums;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        nums = new int[n];
        maxAns = Integer.MIN_VALUE;
        minAns = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            nums[i] = num;
        }
        st = new StringTokenizer(br.readLine());
        operator = new int[4];
        operator[0] = Integer.parseInt(st.nextToken());
        operator[1] = Integer.parseInt(st.nextToken());
        operator[2] = Integer.parseInt(st.nextToken());
        operator[3] = Integer.parseInt(st.nextToken());
        dfs(1, nums[0]);
        System.out.println(maxAns);
        System.out.println(minAns);


    }

    public static void dfs(int depth, int num) {

        if (depth == n) {
            minAns = Math.min(minAns, num);
            maxAns = Math.max(maxAns, num);
            return;
        }

        for (int i = 0; i < 4; i++) {

            if (operator[i] > 0) {

                operator[i]--;

                if (i == 0) {
                    dfs(depth + 1, num + nums[depth]);
                } else if (i == 1) {
                    dfs(depth + 1, num - nums[depth]);
                } else if (i == 2) {
                    dfs(depth + 1, num * nums[depth]);
                } else {
                    dfs(depth + 1, num / nums[depth]);
                }

                operator[i]++;
            }
        }


    }


}
