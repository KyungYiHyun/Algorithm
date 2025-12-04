import java.util.*;

class Solution {
    
    static char[] arr;
    static boolean[] used;
    static Set<Integer> set; // 중복 숫자 방지
    static int answer;
    
    public int solution(String numbers) {
        arr = numbers.toCharArray();
        used = new boolean[arr.length];
        set = new HashSet<>();
        
        dfs("");
        
        for (int n : set) {
            if (isPrime(n)) answer++;
        }
        
        return answer;
    }
    
    private void dfs(String current) {
        if (!current.equals("")) {
            set.add(Integer.parseInt(current));
        }
        
        if (current.length() == arr.length) return;
        
        for (int i = 0; i < arr.length; i++) {
            if (used[i]) continue;
            used[i] = true;
            dfs(current + arr[i]);
            used[i] = false;
        }
    }
    
    private boolean isPrime(int n) {
        if (n < 2) return false;
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }
}
