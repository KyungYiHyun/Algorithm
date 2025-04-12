import java.util.*;

public class Solution {
    public ArrayDeque solution(int []arr) {
        ArrayDeque<Integer> stk = new ArrayDeque<>();
        for (int n : arr){
            if (stk.isEmpty()){
                stk.addLast(n);
            }
            if (!stk.isEmpty() && stk.peekLast() != n){
                stk.addLast(n);
            }
        }
      
        


        return stk;
    }
}