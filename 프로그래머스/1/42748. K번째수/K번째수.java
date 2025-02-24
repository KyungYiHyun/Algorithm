import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Solution {
    public ArrayList<Integer> solution(int[] array, int[][] commands) {
        ArrayList<Integer> answer = new ArrayList<>();
        for (int[] c : commands){
            ArrayList<Integer> nums = new ArrayList<>();
            for (int i = c[0]; i <= c[1]; i++){
                nums.add(array[i - 1]);
            }
//            nums.sort((a,b)->a.compareTo(b));
            List<Integer> collect = nums.stream().sorted(Comparator.comparing(Integer::valueOf)).collect(Collectors.toList());
            answer.add(collect.get(c[2] - 1));
        }
        
        return answer;
    }
}