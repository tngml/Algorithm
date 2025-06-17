
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		int N = Integer.parseInt(br.readLine());
		
		int [] A = new int [N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i=0; i<N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
			
		}
		
		int M = Integer.parseInt(br.readLine());
		int [] B = new int [M];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<M; i++) {
			B[i] = Integer.parseInt(st.nextToken());
		}
		
		List<Integer> sumA = new ArrayList<>();
		for(int i=0; i<N; i++) {
			int sum =0;
			for(int j= i; j<N; j++) {
				sum += A[j];
				sumA.add(sum);
			}
		}
		
		//System.out.println(sumA);
		
		Map<Integer,Integer>mapB = new HashMap<>();
		for(int i=0; i<M; i++) {
			int sum =0;
			for(int j =i; j<M; j++) {
				sum += B[j];
				mapB.put(sum, mapB.getOrDefault(sum, 0) + 1);
			}
		}
		
		//System.out.println(mapB);
		
		long answer = 0;
		for(int sum : sumA) {
			int a = T - sum;
			answer += mapB.getOrDefault(a, 0);
		}
		System.out.println(answer);
		
		
	}

}
