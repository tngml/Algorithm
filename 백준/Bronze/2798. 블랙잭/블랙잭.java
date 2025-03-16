import java.util.Scanner;

public class Main {

	static int[] card;
	static int[] choose;
	static int K = 3;
	static int N, M;
	static int max = Integer.MIN_VALUE;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();

		card = new int[N];
		for (int i = 0; i < N; i++) {
			card[i] = sc.nextInt();
		}

		comb(0, 0, 0);
		System.out.println(max);

	}

	private static void comb(int idx, int sidx, int sum) {
		if (sidx == K) {
			if (sum <= M) {
				max = Math.max(max, sum);

			}
			return;

		}
		if(idx == N)return;

		comb(idx + 1, sidx + 1, sum + card[idx]);
		comb(idx + 1, sidx,sum);
	}

}
