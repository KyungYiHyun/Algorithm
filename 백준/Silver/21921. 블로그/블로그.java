import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        ArrayList<Integer> visited = new ArrayList<>();
        int maxVisited = -1;
        int numberOfMaxVisited = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int c = Integer.parseInt(st.nextToken());
            visited.add(c);
        }

        int start = 0;
        int end = x - 1;
        int tempVisited = 0;
        int startMax = 0;
        for (int i = 0; i < x; i++) {
            tempVisited += visited.get(i);
            startMax += visited.get(i);
        }
        maxVisited = tempVisited;
        while (end < n - 1) {
            tempVisited -= visited.get(start++);
            tempVisited += visited.get(++end);
            if (tempVisited > maxVisited) {
                numberOfMaxVisited = 1;
                maxVisited = tempVisited;
            } else if (tempVisited == maxVisited) {
                numberOfMaxVisited++;
            }

        }
        if (maxVisited == startMax) numberOfMaxVisited++;

        System.out.println(maxVisited == 0 ? "SAD" : maxVisited + "\n" + numberOfMaxVisited);

    }


}



