import java.io.*;
import java.util.LinkedList;
import java.util.StringTokenizer;


public class Main {

    static boolean[] visited = new boolean[100001];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        if (n == k) {
            System.out.println(0);
            return;
        }
        System.out.println(bfs(n, k, 0));


    }


    public static int bfs(int n, int k, int t) {
        LinkedList<Node> queue = new LinkedList<>();
        Node node = new Node(n, t);
        queue.add(node);
        visited[n] = true;

        while (!queue.isEmpty()) {
            Node current = queue.poll();

            if (current.a == k){
                return current.t;
            }

            int next = current.a * 2;
            if (next >= 0 && next <= 100000 && !visited[next]) {
                visited[next] = true;
                queue.add(new Node(next, current.t));
            }

            int next3 = current.a - 1;
            if (next3 >= 0 && next3 <= 100000 && !visited[next3]) {
                visited[next3] = true;
                queue.add(new Node(next3, current.t + 1));
            }

            int next2 = current.a + 1;
            if (next2 >= 0 && next2 <= 100000 && !visited[next2]) {
                visited[next2] = true;
                queue.add(new Node(next2, current.t+ 1));
            }



        }
        return -1;
    }

    static class Node {
        int a;
        int t;

        public Node(int a, int t) {
            this.a = a;
            this.t = t;
        }
    }
}




