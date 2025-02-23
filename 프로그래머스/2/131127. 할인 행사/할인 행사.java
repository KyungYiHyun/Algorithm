import java.util.HashMap;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        HashMap<String, Integer> ten = new HashMap<>();
        HashMap<String, Integer> wantNumber = new HashMap<>();
        for (int i = 0; i < want.length; i++) {
            wantNumber.put(want[i], number[i]);
        }
        for (int i = 0; i < 10; i++) {
            ten.put(discount[i], ten.getOrDefault(discount[i], 0) + 1);
        }

        for (int i = 0; i < discount.length - 9; i++) {
            boolean isTrue = true;
            for (String w : want) {
                if (ten.get(w) != wantNumber.get(w)) {
                    isTrue = false;
                    break;
                }
            }
            if (isTrue) {
                answer++;
            }
            if (i + 10 >= discount.length) {
                return answer;
            }
            ten.put(discount[i], ten.get(discount[i]) - 1);
            ten.put(discount[10 + i], ten.getOrDefault(discount[10 + i], 0) + 1);

        }


        return answer;
    }
}