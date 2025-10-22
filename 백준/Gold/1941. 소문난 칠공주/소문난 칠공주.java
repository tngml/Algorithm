import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {
	 
	static int [][] map = new int [5][5];
	static int [] dr = {-1,0,1,0};
	static int [] dc = {0,1,0,-1};
	static boolean [][] selected;

	
	public static void main(String[] args) throws IOException {	
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	

	
	for(int i = 0; i<5; i++) {
		String line = br.readLine();
		for(int j = 0; j<5; j++) {
			map[i][j] = (line.charAt(j) == 'S') ? 1:0;
		}
	}
	
	int result = 0;
	

	int n = 25;
	

	int k = 7; 
	
	int [] pick = new int [k];
	

	for(int i = 0; i<k; i++) {
		pick[i] = i;
	}
	
	while(true) {

		int sCount = 0;
		for(int idx : pick) {
			int r = idx/5;
			int c = idx%5;
			if(map[r][c] == 1) {
				sCount++;
			}
		}

			if(sCount >= 4) {
				selected = new boolean[5][5];
				for(int idx : pick) {
					selected[idx / 5][idx % 5] = true;
			}
				
			int start = pick[0];
			if(bfs(start/5, start%5, selected) == 7) {
				result++;
			}
		}

			int i = k -1;
			while(i>=0 && pick[i] == i + (n-k)) {
				i--;
			}
			

			if(i<0)break;
			pick[i]++;

			for(int j = i + 1; j<k; j++) {
				pick[j] = pick[j-1] + 1;
			}
	}
	
		System.out.println(result);
		
	}




	private static int bfs(int r, int c, boolean[][] visited) {
		//bfs 기본 코드 
		//int[] 보다 integer로 하는게 좋아 ,,
		Queue<int[]> q = new ArrayDeque<>();
		q.add(new int[] {r,c});
		visited[r][c] = false;
		int cnt = 0;
		
		while(!q.isEmpty()) {
			int [] curr = q.poll();
			int rr = curr[0];
			int cc = curr[1]; 
			cnt++;
			
			for(int d = 0; d<4; d++) {
				int nr = rr + dr[d];
				int nc = cc + dc[d];
				if (nr < 0 || nr >= 5 || nc < 0 || nc >= 5) continue;
				if (!visited[nr][nc]) continue;
				visited[nr][nc] = false;
				 q.add(new int[]{nr, nc});
			}
			
			
			
		}
		return cnt;
	}

}
