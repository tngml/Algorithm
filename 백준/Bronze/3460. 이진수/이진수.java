import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	static int T;
	static int N;
	
	
	public static void main(String[] args) throws IOException {
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc<= T; tc++) {
			
			N = Integer.parseInt(br.readLine());
			int idx = 0;  

			while(N > 0) {

				if(N % 2 == 1)  {
					System.out.print(idx + " ");
				}
			N /= 2;
			idx++;
			}
			
			
			
		}
	}

}
