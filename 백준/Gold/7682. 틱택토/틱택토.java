import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb;

        while (true) {
            String input = br.readLine();
            if (input.equals("end")) break;
            sb = new StringBuilder();
            for (int i = 0; i < 9; i++) {
                sb.append(input.charAt(i));
            }
            char[] charArray = sb.toString().toCharArray();
            if (solve(charArray)) {
                System.out.println("valid");
            } else {
                System.out.println("invalid");
            }

        }


    }

    private static boolean win(char unit, char[] chars) {

        for (int i = 0; i < 3; i++) {
            if (chars[i] == unit && chars[i] == chars[i + 3] && chars[i + 3] == chars[i + 6]) {
                return true;
            }
            if (chars[i * 3] == unit && chars[i * 3] == chars[i * 3 + 1] && chars[i * 3 + 1] == chars[i * 3 + 2]) {
                return true;
            }
        }
        if (chars[0] == unit && chars[0] == chars[4] && chars[4] == chars[8]) {
            return true;
        }
        if (chars[2] == unit && chars[2] == chars[4] && chars[4] == chars[6]) {
            return true;
        }
        return false;
    }

    private static boolean solve(char[] chars) {

        int xCnt = 0;
        int oCnt = 0;

        // 개수 세기
        for (char c : chars) {
            if (c == 'X') xCnt++;
            if (c == 'O') oCnt++;
        }

        // O가 X보다 많음
        if (xCnt < oCnt) return false;
        // X가 O보다 2개이상 많음
        if (xCnt >= oCnt + 2) return false;

        // 둘다 이김
        if (win('X', chars) && win('O', chars)) return false;

        // 꽉찼을때
        if (xCnt + oCnt == 9) {
            // X가 이김
            if (win('X', chars)) return true;
            // 무승부
            if (!win('X', chars) && !win('O', chars)) return true;
            // O가 이김
            if (win('O', chars)) return false;
        }

        // X 승리
        if (win('X', chars)) {
            if (xCnt - 1 == oCnt) {
                return true;
            }
        }

        // O 승리
        if (win('O', chars)) {
            if (xCnt == oCnt) {
                return true;
            }
        }

        return false;

    }
}





