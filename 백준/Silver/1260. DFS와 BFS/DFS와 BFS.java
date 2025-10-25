
import java.util.*;

public class Main {

	static int N, M, V;
	static List<List<Integer>> graph;
	static boolean[] visited;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt(); // 정점 개수
		M = sc.nextInt(); // 간선 개수
		V = sc.nextInt(); // 시작점

		graph = new ArrayList<>();
		for (int i = 0; i <= N; i++) {
			graph.add(new ArrayList<>()); 
		}

		visited = new boolean[N + 1]; 

		
		for (int i = 0; i < M; i++) {
			int A = sc.nextInt();
			int B = sc.nextInt();

			graph.get(A).add(B);
			graph.get(B).add(A);
		}

		
		for (int i = 1; i <= N; i++) {
			Collections.sort(graph.get(i));
		}

		
		dfs(V);
		System.out.println();
		
		Arrays.fill(visited, false);
		bfs(V);

	}

	private static void dfs(int v) {
		visited[v] = true; 
		System.out.print(v + " ");


		for (int next : graph.get(v)) {
			if (!visited[next]) { 
				dfs(next);
			}
		}
	}
	
	private static void bfs(int v) {
		Queue<Integer> q = new LinkedList<>();
		q.add(v);
		visited[v] = true;
		
		while(!q.isEmpty()) {
			int node = q.poll();
			System.out.print(node + " ");
			
			for(int next : graph.get(node)) {
				if(!visited[next]) {
					q.add(next);
					visited[next] = true;
				}
			}
		}
	}
}
