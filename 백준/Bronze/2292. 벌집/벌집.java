
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		//몇 번 방까지 있느지
		int N = sc.nextInt();
		
		if(N == 1) {
			System.out.println(1);
			return;
		}
		
		int floor = 1; //현재 층
		int last = 1; //마지막 숫자
		
		while(last<N) {
			last += 6*floor; //다음 층의 마지막 숫자
			floor++;
		}
		
		System.out.println(floor);
	}

}
