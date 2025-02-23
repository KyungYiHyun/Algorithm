import java.util.HashMap;
import java.util.HashSet;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        HashMap<String, Integer> completionMap = new HashMap();
        for (String s : completion) {
            if (completionMap.containsKey(s)) {
                completionMap.put(s, completionMap.get(s) + 1);

            } else {
                completionMap.put(s, 1);
            }

        }

        for (String p : participant) {
            if (completionMap.getOrDefault(p, 0) == 0) {
                answer = p;
                return answer;
            }
            completionMap.put(p, completionMap.get(p) - 1);
        }
        
        return answer;
    }
}