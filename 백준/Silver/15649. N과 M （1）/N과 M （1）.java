import java.util.Arrays;
import java.util.Scanner;

public class Main {
	
	static int [] arr;
	static int N;
	static int M;
	static int [] result;
	static boolean[] visited;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		
		arr= new int [N];
		for (int i = 0; i < N; i++) {
			arr[i] = i + 1;  // 1부터 N까지 값 저장
		}

		result = new int [N];
		visited = new boolean [N];
		
		perm(0);
		
		
	}

	public static void perm(int idx) {
		if(idx == M) {
			for(int i =0; i<M; i++) {
				System.out.print(result[i] + " ");
			}
			System.out.println();
			return;
		}
		
		for(int i =0; i<N; i++) {
			if(visited[i]) continue;
			result[idx] = arr[i];
			visited[i]= true;
			perm(idx+1);
			visited[i]=false;
		}
	}
}
