import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main{
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int [] wants = new int [N];
		
		
		for(int i = 0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			wants[i] = Integer.parseInt(st.nextToken());
		}
		
		
		Arrays.sort(wants);
		
		long total = 0;
		
		for(int i = 0; i<N; i++) {
			int rank = i + 1;
			total += Math.abs(wants[i] - rank);
		}
		
		System.out.println(total);
		
		
	}

}
