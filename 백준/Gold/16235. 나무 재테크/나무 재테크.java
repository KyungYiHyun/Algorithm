import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;


public class Main {

    static class Tree {
        private int age;
        private boolean alive;

        public Tree(int age, boolean alive) {
            this.age = age;
            this.alive = alive;
        }

        @Override
        public String toString() {
            return "Tree{" +
                    "age=" + age +
                    ", alive=" + alive +
                    '}';
        }


    }

    static ArrayList<Tree>[][] board;
    static int[][] food;
    static int[][] addFood;
    static int[] dx = {0, 0, 1, 1, 1, -1, -1, -1};
    static int[] dy = {1, -1, 0, 1, -1, 0, 1, -1};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int ans = 0;
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        board = new ArrayList[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = new ArrayList<>();
            }
        }

        food = new int[n][n];
        addFood = new int[n][n];
        // 초기 양분 5
        for (int i = 0; i < n; i++) {
            Arrays.fill(food[i], 5);
        }

        // 추가되는 양분
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                addFood[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 초기 나무
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int age = Integer.parseInt(st.nextToken());
            board[x - 1][y - 1].add(new Tree(age, true));
        }


        while (k-- > 0) {
            // 봄
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (board[i][j] == null) continue;
                    board[i][j].sort(Comparator.comparing((o) -> o.age));
                    ArrayList<Tree> trees = board[i][j];
                    for (Tree tree : trees) {
                        if (tree.alive && tree.age > food[i][j]) {
                            tree.alive = false;
                        } else if (tree.alive && tree.age <= food[i][j]) {
                            food[i][j] -= tree.age;
                            tree.age++;
                        }
                    }

                }
            }

            // 여름
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    ArrayList<Tree> trees = board[i][j];
                    for (int l = trees.size() - 1; l >= 0; l--) {
                        Tree tree = trees.get(l);
                        if (!tree.alive) {
                            food[i][j] += tree.age / 2;
                            trees.remove(l);
                        }
                    }


                }
            }


            // 가을
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    ArrayList<Tree> trees = board[i][j];
                    for (int l = 0; l < trees.size(); l++) {
                        if (trees.get(l).age % 5 == 0) {
                            for (int g = 0; g < 8; g++) {
                                int nx = i + dx[g];
                                int ny = j + dy[g];
                                if (nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
                                board[nx][ny].add(new Tree(1, true));
                            }
                        }
                    }
                }
            }

            // 겨울
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    food[i][j] += addFood[i][j];
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                ArrayList<Tree> trees = board[i][j];
                for (Tree tree : trees) {
                    if (tree.alive) {
                        ans++;
                    }
                }
            }
        }
        System.out.println(ans);
    }
}





