import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line;
		
		while((line = br.readLine()) != null) {
			
			int n = Integer.parseInt(line);
			
			int remain = 0;
			int length = 0;
			
			while(true) {
				remain = (remain * 10 + 1) % n;
				length++;
				
				if(remain == 0) {
					System.out.println(length);
					break;
				}
			}
		}
	}

}
