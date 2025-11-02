import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;


public class Main {

    static ArrayList<Integer>[] adjList;
    static boolean[] visited;

    static int[] sequence;
    static int number;

    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        adjList = new ArrayList[N + 1];
        visited = new boolean[N + 1];
        sequence = new int[N + 1];
        number = 1;
        sequence[R] = number;

        for (int i = 1; i < N + 1; i++) {
            adjList[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            adjList[a].add(b);
            adjList[b].add(a);
        }
        dfs(0, R);

        for (int i = 1; i < N + 1; i++) {
            System.out.println(sequence[i]);
        }
    }

    private static void dfs(int depth, int node) {

        if (depth == N) {
            return;
        }

        ArrayList<Integer> adj = adjList[node];
        Collections.sort(adj, Collections.reverseOrder());
        visited[node] = true;

        for (Integer n : adj) {
            if (!visited[n]) {
                visited[n] = true;
                sequence[n] = ++number;
                dfs(depth + 1, n);
            }
        }

    }
}
