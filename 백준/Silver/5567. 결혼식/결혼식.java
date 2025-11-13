import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    static ArrayList<Integer>[] adjList;

    static boolean[] visited;

    static int n;

    static int ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        visited = new boolean[n + 1];
        adjList = new ArrayList[n + 1];
        for (int i = 1; i < n + 1; i++) {
            adjList[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            adjList[a].add(b);
            adjList[b].add(a);
        }
        dfs(1, 0);
        ArrayList<Integer> friends = adjList[1];
        for (Integer friend : friends) {
            visited[friend] = true;
        }

        for (Integer friend : friends) {
            dfs(friend, 1);
        }

        for (int i = 2; i < n + 1; i++) {
            if (visited[i]) {
                ans++;
            }
        }

        System.out.println(ans);
  
    }

    private static void dfs(int n, int depth) {
        if (depth > 1) {
            return;
        }
        ArrayList<Integer> lst = adjList[n];
        for (Integer i : lst) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(i, depth + 1);
            }
        }
    }
}
