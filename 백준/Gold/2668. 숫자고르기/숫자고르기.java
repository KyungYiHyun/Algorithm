import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    static int[] table;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        table = new int[N + 1];

        for (int i = 1; i < N + 1; i++) {
            int n = Integer.parseInt(br.readLine());
            table[i] = n;
        }

        ArrayList<Integer> answers = new ArrayList<>();
        boolean[] visited = new boolean[N + 1];
        for (int i = 1; i < N + 1; i++) {
            dfs(i, i, answers, visited);
            Arrays.fill(visited, false);
        }


        System.out.println(answers.size());
        Collections.sort(answers);
        for (Integer answer : answers) {
            System.out.println(answer);
        }


    }

    private static void dfs(int first, int cur, ArrayList<Integer> answers, boolean[] visited) {
        // first = 1
        // cur = 1
        // num = 3
        if (visited[cur]) {
            return;
        }
        int num = table[cur];
        if (first == num) {
            answers.add(first);
            return;
        }
        visited[cur] = true;
        dfs(first, num, answers, visited);


    }
}


