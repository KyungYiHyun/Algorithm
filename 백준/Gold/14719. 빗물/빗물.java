
import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int h = Integer.parseInt(st.nextToken());
		int w = Integer.parseInt(st.nextToken());
		int[][] arr = new int[h][w];
		int answer = 0;
		boolean chk = false;
		
		
		st  = new StringTokenizer(br.readLine());
	
		for (int i = 0; i < w; i++) {
			int temp = Integer.parseInt(st.nextToken());
			for (int j = 0; j < temp; j++) {
				arr[j][i] = 1;
			}
			
		}
		

		for (int i = 0; i < h; i++) {
			int temp = 0;
			for (int j = 0; j < w; j++) {
				if (arr[i][j] == 1) {
					for (int k = j + 1; k < w; k++) {
						if (arr[i][k] == 0) {temp++;}
						if (arr[i][k] == 1) {
							answer += temp;
							temp = 0;
							break;
								}
					}
				
				}
				}
			}
			
		
		System.out.print(answer);
		
			
		}
		
	
}

