import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int [] line = new int [N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i<N; i++) {
			
			line[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(line);
		
		int sum = 0;
		int total = 0;
		
		for(int i = 0; i<N; i++) {
			sum += line[i];
			total += sum;
		}

		//System.out.println(Arrays.toString(line));
		System.out.println(total);
	}

}
