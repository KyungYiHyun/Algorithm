import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    private static boolean visited[];
    private static int[][] computer;

    public int solution(int n, int[][] computers) {
        int answer = 0;
        visited = new boolean[n];
        computer = computers;
        for (int i = 0; i < n; i++){
            if (!visited[i]){
                dfs(i);
                answer++;    
            }
        }    

        return answer;
    }
    
    private static void dfs(int depth){
        
        visited[depth] = true;
        if (depth >= computer.length){
            return;
        }
        
        int[] nodes = computer[depth];
        
        
       for (int i = 0; i < nodes.length; i++){
           if (!visited[i] && nodes[i] == 1){
               dfs(i);
           }
           
       }
            
        }
                               
                               
                               
                               }
        
        
    
    
    
