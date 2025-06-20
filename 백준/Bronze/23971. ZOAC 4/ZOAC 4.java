import java.io.*;
import java.util.*;

public class Main {
	
	static int n;
	static long arr[];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	
		StringTokenizer st = new StringTokenizer(br.readLine());
		int h = Integer.parseInt(st.nextToken());
		int w = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int ans = 0;
		int x =  h / (n + 1);
		int y = w / (m + 1);
		if (h % (n + 1) != 0) {
			x = h / (n + 1);
			x++;
		}
		
		if (w % (m + 1) != 0) {
			y = w / (m + 1);
			y++;
		}

		for (int i = 0; i < x; i++) {
			for (int j = 0; j < y; j++) {
				ans++;
			}
		
		}
		
		System.out.print(ans);
	}
}
