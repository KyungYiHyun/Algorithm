import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String problem = br.readLine();
        Stack<Character> stack = new Stack<>();

        int result = 0;
        int temp = 1;

        for (int i = 0; i < problem.length(); i++) {
            char current = problem.charAt(i);

            switch (current) {
                case '(':
                    stack.push(current);
                    temp *= 2;
                    break;
                case '[':
                    stack.push(current);
                    temp *= 3;
                    break;
                case ')':
                    if (stack.isEmpty() || stack.peek() != '(') {
                        System.out.println(0);
                        return;
                    } else if (problem.charAt(i - 1) == '(') {
                        result += temp;

                    }
                    temp /= 2;
                    stack.pop();
                    break;

                case ']':
                    if (stack.isEmpty() || stack.peek() != '[') {
                        System.out.println(0);
                        return;
                    } else if (problem.charAt(i - 1) == '[') {
                        result += temp;

                    }
                    temp /= 3;
                    stack.pop();
                    break;
            }


        }
        if (!stack.isEmpty()) {
            System.out.println(0);
            return;
        }
        System.out.println(result);


    }

}
