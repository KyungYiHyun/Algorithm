import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        ArrayList<String> arr = new ArrayList<>();
        HashSet<String> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            arr.add(s);
         
        }

        arr.sort(Comparator.comparing(String::length)
                .thenComparing(String::toString));

        for (int i = 0; i < n; i++) {
            if (set.contains(arr.get(i))){
                continue;
            }
            System.out.println(arr.get(i));
            set.add(arr.get(i));
        }

    }
}