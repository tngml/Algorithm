
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt(); //자리 
		int M = sc.nextInt(); //공을 받은 수
		int L = sc.nextInt(); // 몇 번째
		
		//N은 3보다 크거나 같고 50보다 작거나 같은 자영수
		//M은 50보다 작거나 같은 자연수
		//L은 N-1보다 작거나 같은 자연수
		
		//1번부터 인덱스를 사용하고 싶다면 N+1을 해줘야함
		//공을 받은 횟수저장하는 공간
		int arr[] = new int[N+1];
		//공을 던진 횟수
		int count = 0;
		
		//가지고 있는 사람 번호
		//1번 사람이 먼저 받고 시작 
		int num = 1;
		arr[1] = 1;
		
		
		//자리
		while(true) {
			//공을 받을 때마다 그사람이 받은 횟수가 저장
			if(arr[num] == M) {
				break;
			}
			count++;
			
			if(arr[num] % 2 == 0) {
				//짝수이면 오른쪽 L칸 이동 반시계
				num -= L;
				
				if(num <1) {
					num += N; //배열 범위
				}
			}else {
				num += L;
				if(num >N) {
					num -= N;
				}
			}
			
			//새로 공을 받을 친구의 횟수 증가
			arr[num]++;
			
			
		}
		
		System.out.println(count);

	}
}
