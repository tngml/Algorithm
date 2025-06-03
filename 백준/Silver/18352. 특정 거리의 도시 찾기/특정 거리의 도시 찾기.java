import java.io.*;
import java.util.*;

public class Main {
    static List<Integer>[] graph;
    static int[] distance;
    static int n, m, k, x;

    public static void main(String[] args) throws IOException {
       
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken()); // 도시 수
        m = Integer.parseInt(st.nextToken()); // 도로 수
        k = Integer.parseInt(st.nextToken()); // 거리 정보
        x = Integer.parseInt(st.nextToken()); // 출발 도시

        
        graph = new ArrayList[n + 1];
        distance = new int[n + 1];
        Arrays.fill(distance, -1);

        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            graph[from].add(to); 
        }

        bfs(x);

       
        StringBuilder sb = new StringBuilder();
        boolean found = false;

        for (int i = 1; i <= n; i++) {
            if (distance[i] == k) {
                sb.append(i).append("\n");
                found = true;
            }
        }

        if (found) {
            System.out.print(sb);
        } else {
            System.out.println(-1);
        }
    }

    static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        distance[start] = 0;

        while (!queue.isEmpty()) {
            int current = queue.poll();
            for (int next : graph[current]) {
                if (distance[next] == -1) {
                    distance[next] = distance[current] + 1;
                    queue.offer(next);
                }
            }
        }
    }
}
