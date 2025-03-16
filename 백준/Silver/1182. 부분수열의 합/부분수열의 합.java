import java.util.Scanner;

public class Main {

	static int[] arr;
	static int N, S;
	static int count;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		S = sc.nextInt();

		arr = new int[N];

		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}

		count = 0;
		perm(0, 0);

//		System.out.println();
		System.out.println(S == 0 ? count - 1 :count);

	}

	private static void perm(int idx, int totalSum) {
		if (idx == N) {
			if (totalSum == S) 
				count++;
			return;
			
		}
		perm(idx + 1, totalSum);
		perm(idx + 1, totalSum + arr[idx]);

	}
}
