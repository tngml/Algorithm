
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int [][] map;
	static boolean [][] visited;
	static int M,N,K;
	
	static int [] dr = {-1,1,0,0};
	static int [] dc = {0,0,-1,1};
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		 
		for(int tc = 1; tc<=T; tc++) { 
			StringTokenizer st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			
			map = new int [N][M];
			visited = new boolean [N][M];
			
			for(int i=0; i<K; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				map[y][x] = 1;
			}
			
			int count =0;
			
			for(int i=0; i<N; i++) {
				for(int j =0; j<M; j++) {
					if(map[i][j] == 1 && !visited[i][j]) {
						dfs(i,j);
						count++;
					}
				}
			}
			
			System.out.println(count);
			
		}
		
		
	}

	private static void dfs(int i, int j) {
		visited[i][j] = true;
		
		for(int d =0; d<4; d++) {
			int nr = i + dr[d];
			int nc = j + dc[d];
			
			if(nr >= 0 && nc>=0 && nr < N && nc <M) {
				if(map[nr][nc] == 1 && !visited[nr][nc]) {
					dfs(nr,nc);
				}
			}
		}
		
	}
}
