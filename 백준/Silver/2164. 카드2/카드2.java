
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		Queue<Integer> qu = new ArrayDeque<>();
		
		int N =sc.nextInt();
		
		for(int i =1; i<=N ;i++) {
			qu.offer(i);
		}
//		System.out.println(qu);
		
//		for(int i =1; i<=N; i++) {
////			qu.poll();
//			System.out.println(qu.poll());
//		}
		int num = 0;
		while(qu.size() != 1) {
			qu.poll();
			
			num = qu.poll();
			qu.offer(num);
			
		}
		
		//System.out.println(qu);
		System.out.println(qu.poll());
	}

}
