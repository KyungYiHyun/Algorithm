import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        ArrayList<Integer> finds = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        LinkedList<Integer> numbers = new LinkedList<>();
        int count = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            finds.add(Integer.parseInt(st.nextToken()));
        }

        for (int i = 1; i <= n; i++) {
            numbers.add(i);
        }

        for (Integer find : finds) {
            int targetIdx = numbers.indexOf(find);

            int halfIdx;

            if (numbers.size() % 2 == 0) {
                halfIdx = numbers.size() / 2 - 1;
            } else {
                halfIdx = numbers.size() / 2;
            }

            if (targetIdx <= halfIdx) {
                for (int i = 0; i < targetIdx; i++) {
                    numbers.addLast(numbers.pollFirst());
                    count++;
                }
                numbers.pollFirst();
            } else {
                for (int j = 0; j < numbers.size() - targetIdx; j++) {
                    numbers.addFirst(numbers.pollLast());
                    count++;
                }
                numbers.pollFirst();
            }

        }

        System.out.println(count);


    }
}