import java.io.*;
import java.util.*;

public class Main {
	
	static int n;
	static long arr[];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr = new long[n];
		long a1 = 0;
		long a2 = 0;
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			long num = Long.parseLong(st.nextToken());
			arr[i] = num;
		}
		

		long prev = Long.MAX_VALUE;
		for (int s = 0; s < n; s++) {
			int idx = binary_search(s + 1, n - 1, arr[s]);
				if(idx != -1) {
				long sum = arr[s] + arr[idx];
				
				if (Math.abs(sum) < prev) {
					prev = Math.abs(sum);
					a1 = arr[s];
					a2 = arr[idx];
					
				}
		}
				}
		System.out.println(a1 + " " + a2);
		
	}
	
	private static int binary_search(int start, int end, long c) {
		int result = -1;
		long closest = Long.MAX_VALUE;
		

		while(start<=end) {
			int mid = (start + end) / 2;
			long sum = c + arr[mid];
			
			if (Math.abs(sum) < closest) {
				closest = Math.abs(sum);
				result = mid;
			}
			
			if (sum == 0) {
				return mid;
			}
			
			if (sum > 0) {
				end = mid - 1;
				
			}
			
			else if(sum < 0) {
				start = mid + 1;
			}
			
		}
		
		return result;
		
		
	}
}
