import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    static boolean[] visited;
    static ArrayList<ArrayList<Integer>> adjList;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        visited = new boolean[N];
        adjList = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int i = 0; i < N; i++) {
            int parent = Integer.parseInt(st.nextToken());
            if (parent == -1) {
                continue;
            }
            adjList.get(parent).add(i);
        }

        int deleteNode = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            ArrayList<Integer> integers = adjList.get(i);
            for (int j = 0; j < integers.size(); j++) {
                if (integers.get(j) == deleteNode) {
                    integers.remove(integers.indexOf(deleteNode));
                }
            }
        }
        visited[deleteNode] = true;
        dfs(deleteNode);
        int ans = 0;
        for (int i = 0; i < N; i++) {
            if (!visited[i] && adjList.get(i).isEmpty()) {
                ans++;
            }
        }


        System.out.println(ans);


    }

    private static void dfs(int deleteNode) {

        ArrayList<Integer> nodes = adjList.get(deleteNode);
        for (Integer node : nodes) {
            visited[node] = true;
            dfs(node);
        }


    }


}


