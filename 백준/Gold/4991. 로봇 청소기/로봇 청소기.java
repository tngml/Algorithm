import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	
	static int h,w;
	static char [][] map;
	static List<int[]> dirtyList;
	static int startR,startC; 
	static int [] dr = {-1,1,0,0};
	static int [] dc = {0,0,-1,1};
	
	static int K; 
	static int [][] points;
	static int [][] distMap; 
	
	static boolean [] visited;
	static int answer;
	
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			
			if(h == 0 && w ==0)break;
			
			map = new char[h][w];
			dirtyList = new ArrayList<>();
			
			for(int i =0; i<h; i++) {
				String str = br.readLine();
				for(int j =0; j<w; j++) {
					char c = str.charAt(j);
					map[i][j] = c;
					

					if(map[i][j] == 'o') {
						startR = i;
						startC = j;
					}
					

					if(map[i][j] == '*') {
						dirtyList.add(new int[] {i,j});
					}
								
					
				}
			}
			
			
		
		     K = dirtyList.size() + 1;  
	         points = new int[K][2];
	         

	         points[0][0] = startR;
	         points[0][1] = startC;
	         
	         

	        for(int i =1; i<K; i++) {

	        	points[i] = dirtyList.get(i-1);
	        }
	        
	        distMap = new int[K][K];
	        boolean po = true;
	        
	        for (int i = 0; i < K; i++) {

                int[][] dist = bfs(points[i][0], points[i][1]); 

                for (int j = 0; j < K; j++) {
                    int tr = points[j][0];
                    int tc = points[j][1];

                    distMap[i][j] = dist[tr][tc];

                    if (dist[tr][tc] == -1) po = false; 
                }
            }

            if (!po) {
                System.out.println(-1);
                continue;
            }
			
            
   
           visited = new boolean[K];
           answer = Integer.MAX_VALUE;
           

           visited[0] = true;
           
           perm(0,0,0); 
           System.out.println(answer);
			
		}
		
	}


	private static int[][] bfs(int sr, int sc) {
		int[][] dist = new int[h][w];
        for (int i = 0; i < h; i++) Arrays.fill(dist[i], -1);

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{sr, sc});
        dist[sr][sc] = 0;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int r = cur[0];
            int c = cur[1];

            for (int d = 0; d < 4; d++) {
                int nr = r + dr[d];
                int nc = c + dc[d];

                if (nr < 0 || nr >= h || nc < 0 || nc >= w) continue;
                if (map[nr][nc] == 'x') continue;
                if (dist[nr][nc] != -1) continue; 

                dist[nr][nc] = dist[r][c] + 1;
                q.add(new int[]{nr, nc});
            }
        }
        return dist;
	}
	

    static void perm(int depth, int now, int sum) {

        if (depth == K - 1) { 
            answer = Math.min(answer, sum);
            return;
        }

        for (int next = 1; next < K; next++) {
            if (!visited[next]) {
                visited[next] = true;
                perm(depth + 1, next, sum + distMap[now][next]);
                visited[next] = false;
            }
        }
    }
	

}
