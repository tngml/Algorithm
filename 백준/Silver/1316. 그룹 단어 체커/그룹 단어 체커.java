import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		int N = Integer.parseInt(br.readLine());
		
		
		int count = 0;
		
		for(int i = 0; i<N; i++) {
			String str = br.readLine();
			boolean [] word = new boolean[26];
			boolean group = true;
			char prev = 0;
			
			for(int j = 0; j<str.length(); j++) {
				char ch = str.charAt(j);
				
				if(ch != prev) {
					if(word[ch - 'a']) {
						group = false;
						break;
					}
					word[ch - 'a'] = true;
					
				}
				
				prev = ch;
			}
			if(group) {
				count++;
			}
		}
		
		System.out.println(count);
		
	}
	
	
	}
	
