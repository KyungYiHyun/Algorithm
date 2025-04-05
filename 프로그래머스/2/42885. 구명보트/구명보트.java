import java.util.*;
class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        int start = 0;
        int end = people.length - 1;
        Arrays.sort(people);
        while(start <= end){
            int current = people[end];
            if (current + people[start] > limit){
                end--;
                answer++;
                
            } else {
                start++;
                end--;
                answer++;
                
            }
            
            
        }
        
        
        
        
        return answer;
    }
}