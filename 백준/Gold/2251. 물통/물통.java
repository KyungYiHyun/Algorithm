import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    static int a1;
    static int b1;
    static int c1;

    static boolean[][][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        a1 = Integer.parseInt(st.nextToken());
        b1 = Integer.parseInt(st.nextToken());
        c1 = Integer.parseInt(st.nextToken());
        visited = new boolean[201][201][201];
        PriorityQueue<Integer> ansQueue = new PriorityQueue<>();

        ArrayDeque<Busket> queue = new ArrayDeque<>();
        queue.add(new Busket(0, 0, c1));


        while (!queue.isEmpty()) {

            Busket busket = queue.poll();

            if (visited[busket.a][busket.b][busket.c]) {
                continue;
            }
            visited[busket.a][busket.b][busket.c] = true;
            if (busket.a == 0) {
                ansQueue.add(busket.c);
            }


            // A -> B
            if (busket.a + busket.b > b1) {
                queue.add(new Busket(busket.a - (b1 - busket.b), b1, busket.c));
            }
            if (busket.a + busket.b <= b1) {
                queue.add(new Busket(0, busket.b + busket.a, busket.c));
            }

            // B -> A
            if (busket.b + busket.a > a1) {
                queue.add(new Busket(a1, busket.b - (a1 - busket.a), busket.c));
            }
            if (busket.b + busket.a <= a1) {
                queue.add(new Busket(busket.a + busket.b, 0, busket.c));
            }

            // A -> C
            if (busket.a + busket.c > c1) {
                queue.add(new Busket(busket.a - (c1 - busket.c), busket.b, c1));
            }
            if (busket.a + busket.c <= c1) {
                queue.add(new Busket(0, busket.b, busket.a + busket.c));
            }

            // C -> A
            if (busket.c + busket.a > a1) {
                queue.add(new Busket(a1, busket.b, busket.c - (a1 - busket.a)));
            }
            if (busket.c + busket.a <= a1) {
                queue.add(new Busket(busket.a + busket.c, busket.b, 0));
            }

            // B -> C
            if (busket.b + busket.c > c1) {
                queue.add(new Busket(busket.a, busket.b - (c1 - busket.c), c1));
            }
            if (busket.b + busket.c <= c1) {
                queue.add(new Busket(busket.a, 0, busket.b + busket.c));
            }

            // C -> B
            if (busket.b + busket.c > b1) {
                queue.add(new Busket(busket.a, b1, busket.c - (b1 - busket.b)));
            }
            if (busket.b + busket.c <= b1) {
                queue.add(new Busket(busket.a, busket.b + busket.c, 0));
            }

        }


        while (!ansQueue.isEmpty()) {
            System.out.print(ansQueue.poll() + " ");
        }

    }

    public static class Busket {
        private int a;
        private int b;
        private int c;

        public Busket(int a, int b, int c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }
    }


}