

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());


        parent = new int[N + 1];
        int[] route = new int[M + 1];
        for (int i = 1; i < N + 1; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int a = Integer.parseInt(st.nextToken());
                if (a == 1) {
                    union(i + 1, j + 1);
                }
            }
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < M + 1; i++) {
            int a = Integer.parseInt(st.nextToken());
            route[i] = find(a);
        }

        boolean chk = false;
        int start = find(route[1]);
        for (int i = 2; i < M + 1; i++) {
            if (start != route[i]) {
                System.out.println("NO");
                chk = true;
                break;
            }
        }

        if (!chk) {
            System.out.println("YES");
        }


    }

    private static int find(int n) {
        if (n == parent[n]) {
            return parent[n];
        }

        return parent[n] = find(parent[n]);
    }

    private static void union(int a, int b) {
        int x = find(a);
        int y = find(b);

        if (x != y) {
            if (x < y) {
                parent[y] = x;
            } else {
                parent[x] = y;
            }
        }

    }


}
