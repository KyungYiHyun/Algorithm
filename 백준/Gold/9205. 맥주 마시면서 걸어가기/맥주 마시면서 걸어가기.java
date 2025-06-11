import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            ArrayList<Node> nodes = new ArrayList<>();
            ArrayDeque<Integer> queue = new ArrayDeque<>();
            int n = Integer.parseInt(br.readLine());
            boolean[] visited = new boolean[n + 2];
            st = new StringTokenizer(br.readLine());
            int homeX = Integer.parseInt(st.nextToken());
            int homey = Integer.parseInt(st.nextToken());
            Node home = new Node(homeX, homey);
            nodes.add(home);
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                int conX = Integer.parseInt(st.nextToken());
                int conY = Integer.parseInt(st.nextToken());
                Node con = new Node(conX, conY);
                nodes.add(con);
            }
            st = new StringTokenizer(br.readLine());
            int penX = Integer.parseInt(st.nextToken());
            int penY = Integer.parseInt(st.nextToken());
            Node pen = new Node(penX, penY);
            nodes.add(pen);
            bfs(nodes, visited, queue);

        }


    }

    private static void bfs(ArrayList<Node> nodes, boolean[] visited, ArrayDeque<Integer> queue) {
        queue.add(0);
        visited[0] = true;

        while (!queue.isEmpty()) {
            Integer polled = queue.poll();
            if (calDist(nodes.get(polled), nodes.get(nodes.size() - 1))) {
                System.out.println("happy");
                return;
            }

            for (int i = 0; i < nodes.size() - 1; i++) {
                if (!visited[i] && calDist(nodes.get(polled), nodes.get(i))) {
                    visited[i] = true;
                    queue.add(i);
                }
            }
        }
        System.out.println("sad");
    }

    private static boolean calDist(Node start, Node end) {
        int distance = Math.abs(start.x - end.x) + Math.abs(start.y - end.y);
        if (distance > 1000) return false;
        return true;
    }

}
