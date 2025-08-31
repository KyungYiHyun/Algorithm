import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        StringBuilder sb = new StringBuilder(s);
        int M = Integer.parseInt(br.readLine());
        int cursor = sb.length();
       
        String letter;
        while (M-- > 0) {
            String[] commands = br.readLine().split(" ");
            String command = commands[0];

            if (command.equals("P")) {
                letter = commands[1];
                sb.insert(cursor, letter);
                cursor++;
            } else if (command.equals("L")) {
                if (cursor != 0) {
                    cursor--;
                }
            } else if (command.equals("D")) {
                if (cursor != sb.length()) {
                    cursor++;
                }
            } else {
                if (cursor != 0) {
                    sb.deleteCharAt(cursor - 1);
                    cursor--;
                }
            }
        }

        System.out.println(sb);

    }


}