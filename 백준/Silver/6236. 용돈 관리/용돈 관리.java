

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int [] money = new int [N];
		
		int dayMax = 0;
		int daySum = 0;
		
		
		for(int i = 0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			money[i] = Integer.parseInt(st.nextToken());
			dayMax = Math.max(dayMax, money[i]);
			daySum += money[i];
		}
		
		int left = dayMax;
		int right = daySum;
		int result = daySum;
		
		while(left <= right) {
			int mid = (left + right) / 2;
			
			int count = 1;
			int re = mid;
			
			for(int i =0; i<N; i++) {
				if(re < money[i]) {
					count++;
					re = mid;
					
				}
				re -= money[i];
			}
			
			if(count <= M) {
				result = mid;
				right = mid - 1;
				
			}else {
				left = mid + 1;
				
			}
		}
		
		System.out.println(result);
	}

}
