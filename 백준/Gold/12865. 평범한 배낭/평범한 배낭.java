import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int [][] items = new int [N + 1] [2];
		
		for(int i =1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			items[i][0] = Integer.parseInt(st.nextToken());
			items[i][1] = Integer.parseInt(st.nextToken());

		
		
	}
		
		int [][] dp = new int [N+1][K+1];
		
		for(int i = 1; i<=N; i++) {
			int W = items[i][0];
			int V = items[i][1];
			
			for(int j = 0; j<=K; j++) {
				if(W > j) {
					dp[i][j] = dp [i -1][j];
				}else {
					dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-W] + V);
				}
			}
		}
	
		System.out.println(dp[N][K]);
	}

}
