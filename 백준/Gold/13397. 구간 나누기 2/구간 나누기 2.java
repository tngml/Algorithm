
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		
		int M = Integer.parseInt(st.nextToken());
		
		int [] num = new int [N];
		
		st = new StringTokenizer(br.readLine());
		
		int maxV = 0;
		for(int i =0; i<N; i++) {
			num[i] = Integer.parseInt(st.nextToken());
			maxV = Math.max(maxV, num[i]);
		}
		int left = 0;
		int right = maxV;
		int result = right;
		
		while(left <= right) {
			int mid = (left + right) /2;
			
			int count = 1;
			int min = num[0];
			int max = num[0];
			
			for(int i =1; i<N; i++) {
				min = Math.min(min, num[i]);
				max = Math.max(max, num[i]);
				
				if(max - min > mid) {
					count ++;
					min = num[i];
					max = num[i];
				}
			}
			
			if(count <= M) {
				result = mid;
				right = mid - 1;
			}
			else {
				left = mid + 1;
			}
		}
		
		System.out.println(result);
	}

}
