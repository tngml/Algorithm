

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
		
		int [] j = new int [M];
		int max = 0;
		
		for(int i = 0 ; i<M; i++) {
		
		j[i] = Integer.parseInt(br.readLine());
		
		max = Math.max(max, j[i]);
			
		}
		
		int left = 1;
		int right = max;
		int result = max;
		
		while(left <= right) {
			int mid = (left + right )/2;
			
			int count = 0;
			
			for(int i =0; i<M; i++) {
				count += (j[i] + mid - 1) / mid;
			}
			
			if(count <= N) {
				result = mid;
				right = mid - 1;
			}else {
				left = mid + 1;
			}
		}
		
		System.out.println(result);
		
	}

}
