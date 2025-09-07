import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int N,M;
	static int [][] art;
	static boolean [][] visited;
	static int count,result;
	static int [] dr = {-1,1,0,0};
	static int [] dc = {0,0,-1,1};
	
	public static void main(String[] args) throws IOException {
	
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		art = new int [N][M];
		visited = new boolean [N][M];
		count = 0;
		result = 0;
		
		for(int i = 0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j<M; j++) {
				art[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		
		for(int i = 0; i<N; i++) {
			for(int j = 0; j<M; j++) {
				if(art[i][j]==1 && !visited[i][j]) {
					count++;
					result = Math.max(result, bfs(i,j));
					
				}
			}
		}
		System.out.println(count);
		System.out.println(result);
	}

	private static int bfs(int r, int c) {
		
		Queue<int[]> q = new LinkedList<>();
		visited[r][c] = true;
		q.add(new int[] {r,c});
		
		int area = 0;
		
		while(!q.isEmpty()) {
			int [] curr = q.poll();
			int cur1 = curr[0];
			int cur2 = curr[1];
			area++;
			
			for(int d = 0; d<4; d++) {
				int nr = cur1 + dr[d];
				int nc = cur2 + dc[d];
				
				if(nr < 0 || nr >= N || nc < 0 || nc >= M)continue;
				if(visited[nr][nc]||art[nr][nc] == 0)continue;
				
				visited[nr][nc] = true;
				q.add(new int[] {nr,nc});
			}
			
		}
		return area;
		
	}

}
