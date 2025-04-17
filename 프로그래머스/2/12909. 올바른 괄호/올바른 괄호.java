import java.util.*;

class Solution {
    boolean solution(String s) {
        boolean answer = true;
        ArrayDeque<Character> stk = new ArrayDeque<>();
        char[] s2 = s.toCharArray();
        for (char g : s2){
            stk.addLast(g);
            if (!stk.isEmpty() && stk.peekLast().equals(')')){
                if (stk.size() == 1){
                    return false;
                } 
                stk.pollLast();
                stk.pollLast();
            }
           
        }
        if (stk.isEmpty()){
            return true;
        } else {
            return false;
        }
        

    
    }
}