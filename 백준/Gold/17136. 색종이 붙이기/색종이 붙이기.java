import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int N = 10;
	static int [][] map;
	static int [] paper = {0,5,5,5,5,5};
	static int min = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		map = new int [N][N];
		
		for(int i = 0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}


				 dfs(0,0,0);
				 System.out.println(min == Integer.MAX_VALUE ? -1 : min);

	}

	private static void dfs(int x, int y, int count) {
		
		if(x >= 10) {
			min = Math.min(min, count);
			return;
		}
		
		if(count >= min) return;
		
		if(y == 10) {
			dfs(x+1,0,count);
			return;
		}
		
		if(map[x][y] == 1) {
			for(int size = 5; size >=1; size--) {
				if(paper[size] > 0) {
					boolean attach = true;
					
					if(x + size > N || y + size > N) continue;
					for(int i = x; i < x + size; i++) {
						for(int j = y; j<y + size; j++) {
							if(map[i][j] != 1) {
								attach = false;
								break;
							}
						}
						
						if(!attach) break;
						
						
					}
					if(!attach)continue;
					
						for(int i = x; i<x+size; i++) {
							for(int j = y; j<y+size; j++) {
								map[i][j] = 0;
							}
						}
						paper[size]--;
						
						dfs(x, y+1, count + 1);
						
						for(int i = x; i< x+size; i++) {
							for(int j = y; j<y+size; j++) {
								map[i][j] = 1;
							}
						}
						paper[size]++;
				}
			}
		}
			else {
				dfs(x,y+1,count);
			}
	}

}
