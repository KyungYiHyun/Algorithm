import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static class Node {
        int x, y;
        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        ArrayList<Node> cors = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            cors.add(new Node(x, y));
        }

        // Shoelace 공식 적용
        long sum1 = 0;
        long sum2 = 0;
        for (int i = 0; i < n; i++) {
            Node cur = cors.get(i);
            Node next = cors.get((i + 1) % n); // 마지막 점은 첫 번째 점과 이어져야 함
            sum1 += (long) cur.x * next.y;
            sum2 += (long) cur.y * next.x;
        }

        double area = Math.abs(sum1 - sum2) / 2.0;
        System.out.printf("%.1f\n", area);
    }
}
