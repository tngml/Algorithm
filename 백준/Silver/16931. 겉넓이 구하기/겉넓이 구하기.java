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
		
		int [][] map = new int [N][M];
		for(int i = 0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int ans = 0;
		
		
		for(int i = 0; i<N; i++) {
			for(int j =0; j<M; j++) {
				if(map[i][j] > 0) {
					ans += 2;
				}
			}
		}
		
		for(int i = 0; i<N; i++) {
			ans += map[i][0];
			for(int j =1; j<M; j++) {
				ans += Math.abs(map[i][j] - map[i][j-1]);
			}
			ans += map[i][M-1];
		}
		
		for(int j = 0; j<M; j++) {
			ans += map[0][j];
			for(int i = 1; i<N; i++) {
				ans+= Math.abs(map[i][j] - map[i-1][j]);
			}
			ans+= map[N-1][j];
		}
		
		System.out.println(ans);
		
		
		
	}

}
