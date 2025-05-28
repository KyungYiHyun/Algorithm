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

            }
            if (ans > 100) {
                ans = -1;
                break;
            }

            if (rowSize >= colSize) {
                rowSort(rowSize, colSize);
            } else {
                colSort(rowSize, colSize);
            }


        }
        System.out.println(ans);


    }

    private static void rowSort(int rowSize, int colSize) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < rowSize; i++) {
            for (int j = 0; j < colSize; j++) {
                if (board[i][j] == 0) {
                    continue;
                }
                map.put(board[i][j], map.getOrDefault(board[i][j], 0) + 1);
            }


            List<Integer> sorted = map.keySet().stream().sorted(Comparator.comparing((o1) ->
                            map.get(o1)).thenComparing(Comparator.comparingInt((o2) -> (int) o2))).limit(50)
                    .collect(Collectors.toList());
            int colIdx = 0;

            for (Integer integer : sorted) {
                board[i][colIdx] = integer;
                board[i][colIdx + 1] = map.get(integer);
                colIdx += 2;
            }
            for (int k = colIdx; k < colSize; k++) {
                board[i][k] = 0;
            }
            map.clear();

        }


    }

    private static void colSort(int rowSize, int colSize) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < colSize; i++) {
            for (int j = 0; j < rowSize; j++) {
                if (board[j][i] == 0) {
                    continue;
                }
                map.put(board[j][i], map.getOrDefault(board[j][i], 0) + 1);
            }


            List<Integer> sorted = map.keySet().stream().sorted(Comparator.comparing((o1) ->
                            map.get(o1)).thenComparing(Comparator.comparingInt((o2) -> (int) o2))).limit(50)
                    .collect(Collectors.toList());

            int rowIdx = 0;

            for (Integer integer : sorted) {
                board[rowIdx][i] = integer;
                board[rowIdx + 1][i] = map.get(integer);
                rowIdx += 2;
            }
            for (int k = rowIdx; k < rowSize; k++) {
                board[k][i] = 0;
            }
            map.clear();

        }


    }


}

