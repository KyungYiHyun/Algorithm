import java.util.*;

class Solution {
    static int[][] visited;
    static int[] dx = {0,0,-1,1};
    static int[] dy = {1,-1,0,0};
    
    public int solution(int[][] maps) {
        int answer = 0;
        int r = maps.length;
        int c = maps[0].length;
        visited = new int[maps.length][maps[0].length];
        for (int[] v : visited){
            Arrays.fill(v,-1);
        }
        answer = bfs(maps, visited,r ,c);
        
        return answer;
    }
    
    private static int bfs(int[][] maps, int[][] visited, int r, int c){
        Queue<int[]> queue = new ArrayDeque<>();
        visited[0][0] = 1;
        queue.add(new int[]{0,0});
        while(!queue.isEmpty()){
            
            int[] cors = queue.poll();
            int cx = cors[0];
            int cy = cors[1];
        
            for (int i = 0; i < 4; i++){
                int nx = cx + dx[i];
                int ny = cy + dy[i];
                if (nx < 0 || nx >= r || ny < 0 || ny >= c)continue;
                if (visited[nx][ny] == -1 && maps[nx][ny] == 1){
                    visited[nx][ny] = visited[cx][cy] + 1;
                    queue.add(new int[]{nx,ny});
                }
                if (nx == r - 1&& ny == c- 1){
                    return visited[nx][ny];
                }
                
            }
            
        }
        
        return -1;
    }
}