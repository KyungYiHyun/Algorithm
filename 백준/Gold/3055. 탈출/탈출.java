import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Node {
        int x, y;
        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    
    static char[][] board;
    static boolean[][] visited;
    static int R, C;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    static Queue<Node> hedgehog = new ArrayDeque<>();
    static Queue<Node> water = new ArrayDeque<>();
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        
        board = new char[R][C];
        visited = new boolean[R][C];
        
        for (int i = 0; i < R; i++) {
            String s = br.readLine();
            for (int j = 0; j < C; j++) {
                board[i][j] = s.charAt(j);
                if (board[i][j] == 'S') {
                    hedgehog.add(new Node(i, j));
                    visited[i][j] = true;
                } else if (board[i][j] == '*') {
                    water.add(new Node(i, j));
                }
            }
        }
        
        int time = 0;
        while (!hedgehog.isEmpty()) {
            time++;
            
            // 물 확장
            expandWater();
            
            // 고슴도치 이동
            if (moveHedgehog()) {
                System.out.println(time);
                return;
            }
        }
        
        System.out.println("KAKTUS");
    }
    
    private static void expandWater() {
        int size = water.size();
        for (int i = 0; i < size; i++) {
            Node curr = water.poll();
            for (int d = 0; d < 4; d++) {
                int nx = curr.x + dx[d];
                int ny = curr.y + dy[d];
                
                if (nx < 0 || nx >= R || ny < 0 || ny >= C) continue;
                if (board[nx][ny] == '.' || board[nx][ny] == 'S') {
                    board[nx][ny] = '*';
                    water.add(new Node(nx, ny));
                }
            }
        }
    }
    
    private static boolean moveHedgehog() {
        int size = hedgehog.size();
        for (int i = 0; i < size; i++) {
            Node curr = hedgehog.poll();
            for (int d = 0; d < 4; d++) {
                int nx = curr.x + dx[d];
                int ny = curr.y + dy[d];
                
                if (nx < 0 || nx >= R || ny < 0 || ny >= C) continue;
                if (visited[nx][ny] || board[nx][ny] == 'X' || board[nx][ny] == '*') continue;
                
                if (board[nx][ny] == 'D') {
                    return true;
                }
                
                visited[nx][ny] = true;
                hedgehog.add(new Node(nx, ny));
            }
        }
        return false;
    }
}