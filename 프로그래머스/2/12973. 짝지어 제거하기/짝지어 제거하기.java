import java.util.*;

class Solution {
    public int solution(String s){
        int answer = -1;
        ArrayDeque<Character> stk = new ArrayDeque<>();
        for(int i = 0; i < s.length(); i++){
            if(!stk.isEmpty() && s.charAt(i) == stk.peekLast()){
                stk.pollLast();
            } else {
                stk.add(s.charAt(i));
            }
            
        }
        if (stk.isEmpty()){
            answer = 1; 
        } else {
            answer = 0;
        }

        

        return answer;
    }
}