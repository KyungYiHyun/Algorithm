import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class Main {

    static int[][] board;


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        board = new int[100][100];

        st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        for (int i = 0; i < 3; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int ans = 0;
//        System.out.println(Arrays.deepToString(board));


//        System.out.println(board[r - 1][c - 1]);
        while (board[r - 1][c - 1] != k) {
            ans++;
            int rowSize = 0;
            int colSize = 0;
            for (int i = 0; i < 100; i++) {
                int rowCnt = 0;
                int colCnt = 0;
                for (int j = 0; j < 100; j++) {
                    if (board[i][j] > 0) {
                        colCnt++;
                    }
                    if (board[j][i] > 0) {
                        rowCnt++;
                    }
                }

                colSize = Math.max(colCnt, colSize);
                rowSize = Math.max(rowCnt, rowSize);
//                System.out.println("rowSize = " + rowSize);
//                System.out.println("colSize = " + colSize);
            }
            if (ans > 100) {
                ans = -1;
                break;
            }
//            System.out.println("rowSize = " + rowSize);
//            System.out.println("colSize = " + colSize);
            if (rowSize >= colSize) {
                rowSort();
//                System.out.println(1);
            } else {
                colSort();
//                System.out.println(0);
            }

//            System.out.println(Arrays.deepToString(board));
        }
        System.out.println(ans);
//        System.out.println(Arrays.deepToString(board));

    }

    private static void rowSort() {
        for (int i = 0; i < 100; i++) {
            HashMap<Integer, Integer> map = new HashMap<>();

            for (int j = 0; j < 100; j++) {
                if (board[i][j] == 0) {
                    continue;
                }
                map.put(board[i][j], map.getOrDefault(board[i][j], 0) + 1);
            }


            List<Integer> sorted = map.keySet().stream().sorted(Comparator.comparing((o1) ->
                            map.get(o1)).thenComparing(Comparator.comparingInt((o2) -> (int) o2))).limit(50)
                    .collect(Collectors.toList());
            int colIdx = 0;
//            System.out.println("sorted = " + sorted);
            for (Integer integer : sorted) {
                board[i][colIdx] = integer;
                board[i][colIdx + 1] = map.get(integer);
                colIdx += 2;
            }
            for (int k = colIdx; k < 100; k++) {
                board[i][k] = 0;
            }

        }

//        System.out.println(Arrays.deepToString(board));
    }

    private static void colSort() {
        for (int i = 0; i < 100; i++) {
            HashMap<Integer, Integer> map = new HashMap<>();
            for (int j = 0; j < 100; j++) {
                if (board[j][i] == 0) {
                    continue;
                }
                map.put(board[j][i], map.getOrDefault(board[j][i], 0) + 1);
            }


            List<Integer> sorted = map.keySet().stream().sorted(Comparator.comparing((o1) ->
                            map.get(o1)).thenComparing(Comparator.comparingInt((o2) -> (int) o2))).limit(50)
                    .collect(Collectors.toList());
//            System.out.println(sorted);
            int rowIdx = 0;
//            System.out.println("sorted = " + sorted);;
            for (Integer integer : sorted) {
                board[rowIdx][i] = integer;
                board[rowIdx + 1][i] = map.get(integer);
                rowIdx += 2;
            }
            for (int k = rowIdx; k < 100; k++) {
                board[k][i] = 0;
            }

        }
//        System.out.println(Arrays.deepToString(board));

    }


}

