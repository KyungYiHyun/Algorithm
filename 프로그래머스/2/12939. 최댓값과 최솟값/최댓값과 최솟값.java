import java.util.*;

class Solution {
    public String solution(String s) {
        String answer = "";
        String[] sArr = s.split(" ");
        int max = Integer.parseInt(sArr[0]);
        int min = Integer.parseInt(sArr[0]);
        for (String a : sArr){
            int t = Integer.parseInt(a);
            max = Math.max(t, max);
            min = Math.min(t, min);
        }
        return min + " " + max;
    }
}