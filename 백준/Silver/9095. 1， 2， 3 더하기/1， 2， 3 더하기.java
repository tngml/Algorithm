import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int tc = Integer.parseInt(br.readLine());
		
			
			
			
		
			int [] dp = new int [11];
			dp[1] = 1;
			dp[2] = 2;
			dp[3] = 4;
			
			for(int i = 4; i<=10; i++) {
				dp[i] = dp[i-1] + dp[i-2] +dp[i-3];
			}
			
			
			for(int T = 1; T<= tc; T++) {
				
				int num = Integer.parseInt(br.readLine());
				sb.append(dp[num]).append('\n');
			}
			
			System.out.println(sb);
		
		
	}

}
