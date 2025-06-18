import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		long N = Long.parseLong(st.nextToken());	
		long P = Long.parseLong(st.nextToken());
		long Q = Long.parseLong(st.nextToken());
		
		Map<Long, Long> map = new HashMap<>();
		map.put(0L, 1L);
		
		Deque<Long> stack = new ArrayDeque<>();
		stack.push(N);
		
		while(!stack.isEmpty()) {
			long cur = stack.peek();
			if(map.containsKey(cur)) {
				stack.pop();
				continue;
			}
			long left = cur / P;
			long right = cur / Q;
			
			if(!map.containsKey(left)) {
				stack.push(left);
				continue;
			}
			
			if(!map.containsKey(right)) {
				stack.push(right);
				continue;
			}
//			
//			System.out.println("result :" + cur + " A : " + left + " B : " + right);
//			System.out.println("-> A " + left + " = " + map.get(left));
//			System.out.println("-> B " + right + " = " + map.get(right));
			
			map.put(cur, map.get(left) + map.get(right));
			stack.pop();
		}
		
		System.out.println(map.get(N));
	}

}
