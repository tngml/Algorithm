import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] dp = new int[n + 1];  // dp[i] = i를 1로 만드는 최소 연산 횟수

        
         // 참조하여 최소값 갱신
        for (int i = 2; i <= n; i++) {
            // 기본적으로 i - 1을 한 경우
            dp[i] = dp[i - 1] + 1;

            // i가 2로 나누어 떨어질 경우
         
            if (i % 2 == 0) {
                dp[i] = Math.min(dp[i], dp[i / 2] + 1);
            }

            // i가 3으로 나누어 떨어질 경우
            if (i % 3 == 0) {
                dp[i] = Math.min(dp[i], dp[i / 3] + 1);
            }
        }

        System.out.println(dp[n]);
    }
}