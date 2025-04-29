import java.util.*;

class Solution
{
    public int solution(int []A, int []B) {
        int answer = 0;
        Integer[] boxedArray = Arrays.stream(B)
                              .boxed()
                              .toArray(Integer[]::new);
        Arrays.sort(A);
        Arrays.sort(
        boxedArray, ((a,b) -> {
            return b-a;
        }));
        
        for (int i = 0; i < A.length; i++){
            answer += A[i] * boxedArray[i];
        }
        return answer;
    }
}