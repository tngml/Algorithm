

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	
	static int N;
	static int money;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		money = Integer.parseInt(st.nextToken());
		
		int [] coins = new int [N];
		
		for(int i = 0 ; i<N; i++) {
			coins[i] = Integer.parseInt(br.readLine());
		}
		
		int [] dp = new int [money + 1];
		dp[0] = 1;
		
		for(int coin : coins) {
			for(int i = coin; i<=money; i++) {
				dp[i] += dp[i - coin];
			}
		}
		
		System.out.println(dp[money]);
		
		
		
	}

}
