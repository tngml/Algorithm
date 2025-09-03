import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int N,M;
	static int u,v;
	static int count;
	static boolean []visited;
	static int [][] map;
	
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		visited = new boolean[N+1];
		map = new int [N+1][N +1];
		
		for(int i = 1; i<M+1; i++) {
			st = new StringTokenizer(br.readLine());
			u = Integer.parseInt(st.nextToken());
			v = Integer.parseInt(st.nextToken());
			map[u][v] = map[v][u] = 1;
			
		}
		
		for(int i = 1; i<N+1; i++) {
			if(!visited[i]) {
				dfs(i);
				count++;
			}
		}
		System.out.println(count);
		
	}


	private static void dfs(int a) {
		visited[a] = true;
		
		for(int i = 1; i<N+1; i++) {
			if(!visited[i] && map[a][i] == 1) {
				dfs(i);
			}
		}
		
	}




}
