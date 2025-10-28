import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;


public class Main {

    static ArrayList<Integer>[] friends;
    static int N;
    static int M;

    static boolean[] visited;

    static boolean chk;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        visited = new boolean[N];
        friends = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            friends[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            friends[b].add(a);
            friends[a].add(b);
        }

        for (int i = 0; i < N; i++) {
            dfs(0, i);
        }

        if (chk) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }

    }

    private static void dfs(int depth, int current) {

        if (chk) {
            return;
        }

        if (depth == 5) {
            chk = true;
            return;
        }

        ArrayList<Integer> currentFriends = friends[current];

        for (Integer currentFriend : currentFriends) {
            if (!visited[currentFriend]) {
                visited[currentFriend] = true;
                dfs(depth + 1, currentFriend);
                visited[currentFriend] = false;
            }

        }


    }
}
