
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		Set<String>set = new HashSet<>();
		
		String [] person = new String [N];
		
		
		
		for(int i =0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String name = st.nextToken();
			String status = st.nextToken();
			
			if(status.equals("enter")) {
				set.add(name);
			}else {
				set.remove(name);
			}
		}
		
		List<String> result = new ArrayList<>(set);
		Collections.sort(result, Collections.reverseOrder());
		
		for(String name : result) {
			System.out.println(name);
		}
	}

}
