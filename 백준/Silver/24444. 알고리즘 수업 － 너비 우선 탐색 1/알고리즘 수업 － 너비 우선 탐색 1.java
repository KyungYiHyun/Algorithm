import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    static ArrayList<Integer>[] adjList;
    static int[] visited;
    static int sequence;

    static ArrayDeque<Integer> queue;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());
        visited = new int[N + 1];
        adjList = new ArrayList[N + 1];


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

        queue = new ArrayDeque<>();
        sequence = 1;
        visited[R] = sequence;

        for (int i = 1; i < N + 1; i++) {
            Collections.sort(adjList[i]);
        }
        queue.addLast(R);
        bfs(R);
        for (int i = 1; i < N + 1; i++) {
            System.out.println(visited[i]);
        }
    }

    private static void bfs(int node) {
        while (!queue.isEmpty()) {
            Integer i = queue.pollFirst();
            ArrayList<Integer> adjNodes = adjList[i];
            for (Integer adjNode : adjNodes) {
                if (visited[adjNode] == 0) {
                    visited[adjNode] = ++sequence;
                    queue.addLast(adjNode);
                }
            }

        }


    }


}
