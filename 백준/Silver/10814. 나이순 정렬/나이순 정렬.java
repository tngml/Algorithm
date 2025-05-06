

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	
	
	public static void main(String[] args) throws IOException {
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		
		List<List<String>> list =  new ArrayList<>();
		
		for(int i = 0; i<201; i++) {
			list.add(new ArrayList<>());
		}
		
//		System.out.println(list);
		
		for(int i=0; i<N; i++) {
			
			st = new StringTokenizer(br.readLine());
			int age = Integer.parseInt(st.nextToken());
			String name = st.nextToken();
			
			list.get(age).add(name);
			
		}
		
//		System.out.println(list);
		
		for(int i=0; i<201; i++) {
			for(String n : list.get(i)) {
				System.out.println(i + " " + n);
			}
			
		}
		
	}

}
