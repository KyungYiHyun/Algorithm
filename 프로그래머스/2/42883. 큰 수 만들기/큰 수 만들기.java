import java.util.Stack;

class Solution {
    public static String solution(String number, int k) {
        String answer = "";
        Stack<Integer> stk = new Stack<>();
        stk.add(number.charAt(0) - '0');
            for (int i = 1; i < number.length(); i++) {
                int current = number.charAt(i) - '0';
                if (!stk.isEmpty() && stk.peek() < current) {
                    while (true) {
                        if (stk.peek() >= current) {
                            break;
                        }
                        stk.pop();
                        k--;
                        if (k == 0){
                            break;
                        }
                        if (stk.isEmpty()) {
                            break;
                        }
                    }
                }

                stk.add(current);
                if (k == 0){
                    for (int j = i + 1; j < number.length(); j++){
                        stk.add(number.charAt(j) - '0');
                    }
                    break;

                }

            }
            if (k > 0){
                while (k != 0){
                    stk.pop();
                    k--;
                }
            }

            for (int i = 0; i < stk.size(); i++){
                answer += stk.get(i);
            }

        return answer;
    }


}