import java.util.HashSet;

class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        HashSet<Integer> numSet = new HashSet<>();
        for (int num : nums){
            numSet.add(num);
        }
        int n = nums.length / 2;
        if (numSet.size() >= n){
            answer = n;
        }
        else {
            answer = numSet.size();
        }
        return answer;
    }
}