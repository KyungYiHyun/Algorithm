import java.util.ArrayList;

class Solution {
    public int[] solution(String s) {
        int[] answer = new int[2];
        String ex = s;
        int cnt = 0;
        while (true){
            cnt++;
            int l = deleteZero(ex);
            ex =  toBinary(l);
            if (ex.equals("1")){
                break;
            }

        }
        answer[0] = cnt;
        answer[1] = zero;
        return answer;
    }

    static private int zero = 0;

    // 0을 없애고 길이 리턴 , 없애는 0 카운트
    public int deleteZero(String num) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < num.length(); i++) {
            if (num.charAt(i) != '0') {
                sb.append(num.charAt(i));
            } else {
                zero++;
            }
        }

        return sb.length();
    }


    // 길이가 들어오면 이진수로 바꿔주고 리턴
    public String toBinary(int num) {
        StringBuilder sb = new StringBuilder();

        while (num > 0) {
            sb.append(num % 2);  // 🔹 나머지를 바로 추가
            num /= 2;
        }

        return sb.reverse().toString();  // 🔹 한 번만 뒤집어서 반환
    }



}