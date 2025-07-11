import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int [] give = new int [N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i = 0; i<N; i++) {
			give[i] = Integer.parseInt(st.nextToken());
		}
		
		//System.out.println(Arrays.toString(give));
		
		int M = Integer.parseInt(br.readLine());
		
		int [] number = new int [M];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i<M; i++) {
			number[i] = Integer.parseInt(st.nextToken());
			
		}
		
		//System.out.println(Arrays.toString(number));
		
		Arrays.sort(give);
		
		StringBuilder sb = new StringBuilder();
		
		for(int i =0;i<M; i++) {
			
			int target = number[i];
			int left = 0;
			int right = N -1;
			boolean find = false;
			
			while(left <= right) {
				int mid = (left + right) / 2;
				
				if(give[mid] == target) {
					find = true;
					break;
				}else if(give[mid] < target) {
					left = mid + 1;
				}else {
					right = mid - 1;
				}
			}
			
			sb.append(find ? 1 : 0).append(" ");

		}
		System.out.println(sb.toString().trim());
		
		
	
	}

}
