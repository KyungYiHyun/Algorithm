import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main {

    static int k;
    static int[] num;

    static ArrayList<Integer> answer;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        while (true) {
            st = new StringTokenizer(br.readLine());
            k = Integer.parseInt(st.nextToken());
            if (k == 0) break;
            answer = new ArrayList<>();
            num = new int[k];
            visited = new boolean[k];
            for (int i = 0; i < k; i++) {
                num[i] = Integer.parseInt(st.nextToken());
            }

            solve(0,0);
            System.out.println();

        }
    }

    private static void solve(int depth, int start) {
        if (depth == 6) {
            for (int i = 0; i < 6; i++) {
                System.out.print(answer.get(i) + " ");
            }
            System.out.println();
            return;
        }

        for (int i = start; i < k; i++) {
            if (!visited[i]) {
                visited[i] = true;
                answer.add(num[i]);
                solve(depth + 1,i);
                answer.remove(answer.size() - 1);
                visited[i] = false;
            }

        }
    }


}