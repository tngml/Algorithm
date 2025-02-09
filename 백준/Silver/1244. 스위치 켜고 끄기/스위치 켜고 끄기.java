import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();  // 스위치 개수 입력
        int[] switchs = new int[N];

        // 스위치 상태 입력
        for (int i = 0; i < N; i++) {
            switchs[i] = sc.nextInt();
        }

        int M = sc.nextInt();  // 학생 수 입력

        for (int i = 0; i < M; i++) {
            int gender = sc.nextInt();
            int num = sc.nextInt();

            if (gender == 1) {  // 남학생 
                for (int j = num - 1; j < N; j += num) {
                    switchs[j] = (switchs[j] == 1) ? 0 : 1;
                }
            } else if (gender == 2) {  // 여학생 
                int index = num - 1;
                int left = index - 1;
                int right = index + 1;

                
                switchs[index] = (switchs[index] == 1) ? 0 : 1;

                // 좌우 대칭이면서 범위를 벗어나지 않는 경우 변경
                while (left >= 0 && right < N && switchs[left] == switchs[right]) {
                    switchs[left] = (switchs[left] == 1) ? 0 : 1;
                    switchs[right] = (switchs[right] == 1) ? 0 : 1;
                    left--;
                    right++;
                }
            }
        }

        //(20개씩 줄바꿈)
        for (int i = 0; i < N; i++) {
            System.out.print(switchs[i] + " ");
            if ((i + 1) % 20 == 0) {  
                System.out.println();
            }
        }
        System.out.println(); 

        sc.close();
    }
}
