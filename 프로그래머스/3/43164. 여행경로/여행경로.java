import java.util.*;

class Solution {
    static boolean[] visited;
    static List<String> candidates = new ArrayList<>();
    
    public String[] solution(String[][] tickets) {
        String[] answer = {};
        visited = new boolean[tickets.length];
        dfs(0,"ICN","ICN",tickets);
        Collections.sort(candidates);

        return candidates.get(0).split(" ");
    }
    
    public static void dfs(int depth, String start,String path,String[][] tickets){
        if (depth == tickets.length){
            candidates.add(path);
            return;
        }
        
        
        for (int i = 0; i < tickets.length; i++){
            if (!visited[i] && tickets[i][0].equals(start)){
                visited[i] = true;
                dfs(depth + 1, tickets[i][1], path + " " + tickets[i][1],tickets);
                visited[i] = false;
            }
            
        }
        return;
        
    }
}
