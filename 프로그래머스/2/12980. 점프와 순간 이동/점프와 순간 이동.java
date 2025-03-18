import java.util.*;

public class Solution {
    public int solution(int n) {
        int ans = 0;

        while (true){
            if (n % 2 == 0){
                n /= 2;
            }
            else {
                ans++;
                n -= 1;
                if (n == 0) {
                    break;
                }
                n /= 2;
                
            }


        }

        return ans;
    }
}