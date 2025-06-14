
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		long K = Integer.parseInt(br.readLine());
		
		
		int len = 1;
		long count = 2;
		
		while(K > count) {
			K -= count;
			len++;
			count *= 2;
			
		}
		
		K--;
		
		String str = Long.toBinaryString(K);
		
		while(str.length() < len) {
			str = "0" + str;
		}
		
		String result = str.replace('0', 'x').replace('1', '7').replace('x', '4');
		
		System.out.println(result);
	}

}
