import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	
	static long A;
	static long B;
	static int count;

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		
		count = 1;
		
		while(B > A) {
			//마지막이 1이면 
			if(B % 10 == 1) {
				B /= 10; //1을 지우기 
			}else if(B % 2 == 0) {
				B /= 2;
			}else {
				break;
			}
			count++;
		}
		
		if(B == A) {
			System.out.println(count);
		}else {
			System.out.println(-1);
		}
		
	}

}
