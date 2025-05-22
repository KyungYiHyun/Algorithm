import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    static int a1;
    static int b1;
    static int c1;

    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        a1 = Integer.parseInt(st.nextToken());
        b1 = Integer.parseInt(st.nextToken());
        c1 = Integer.parseInt(st.nextToken());
        visited = new boolean[1501][1501];
        System.out.println(solve());

    }

    private static int solve() {
        ArrayDeque<Busket> queue = new ArrayDeque<>();

        queue.add(new Busket(a1, b1, c1));

        while (!queue.isEmpty()) {

            Busket busket = queue.poll();

            if (busket.a == busket.b && busket.b == busket.c) {
                return 1;
            }


            // A < B
            if (busket.a < busket.b) {
                if (!visited[busket.a][busket.b]) {
                    queue.add(new Busket(busket.a * 2, busket.b - busket.a, busket.c));

                }

            }
            // A > B
            if (busket.a > busket.b) {
                if (!visited[busket.a][busket.b]) {
                    queue.add(new Busket(busket.a - busket.b, busket.b * 2, busket.c));
                    visited[busket.a][busket.b] = true;
                }

            }
            // B > C
            if (busket.b > busket.c) {
                if (!visited[busket.b][busket.c]) {
                    queue.add(new Busket(busket.a, busket.b - busket.c, busket.c * 2));
                    visited[busket.b][busket.c] = true;
                }

            }
            // C > B
            if (busket.c > busket.b) {
                if (!visited[busket.b][busket.c]) {
                    queue.add(new Busket(busket.a, busket.b * 2, busket.c - busket.b));
                    visited[busket.b][busket.c] = true;
                }
            }
            // A > C
            if (busket.a > busket.c) {
                if (!visited[busket.a][busket.c]) {
                    queue.add(new Busket(busket.a - busket.c, busket.b, busket.c * 2));
                    visited[busket.a][busket.c] = true;
                }

            }
            // C > A
            if (busket.c > busket.a) {
                if (!visited[busket.a][busket.c]) {
                    queue.add(new Busket(busket.a * 2, busket.b, busket.c - busket.a));
                    visited[busket.a][busket.c] = true;
                }
            }

        }

        return 0;
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