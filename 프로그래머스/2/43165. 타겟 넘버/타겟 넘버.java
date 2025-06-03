class Solution {
    static int answer = 0;
    public int solution(int[] numbers, int target) {
       
        int current = numbers[0];
        
        dfs(1,target,current,numbers);
        dfs(1,target, -1 * current,numbers);
        
        return answer;
    }
    
    private static void dfs(int depth, int target, int value,int[] numbers){
        
        // 종료

        if (depth == numbers.length)
            if (value == target){
                 System.out.println(value);
            answer++;
            return;
            } else {
            return;
            }
        
        // 수행
        dfs(depth + 1, target,value + numbers[depth],numbers);
        dfs(depth + 1, target, value - numbers[depth],numbers);
        
    }
}