import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int [] num = new int [N];
		
		int point = 0;
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i = 0; i<N; i++) {
			
			int a = Integer.parseInt(st.nextToken());
			
			int idx = Arrays.binarySearch(num, 0,point,a);
			
			if(idx < 0) idx = -(idx + 1);
			
			num[idx] = a;
			
			if(idx == point) point++;
		}
		
		System.out.println(point);
		
	}

}
