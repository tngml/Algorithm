import java.util.*;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        sb.append("<");

        Queue<Integer> queue = new LinkedList<>();
        for(int i=1;i<=n;i++){
            queue.offer(i);
        }
        int cnt = 0;
        while(queue.size()!=1){
            int data = queue.poll();
            cnt++;
            if(cnt%k == 0){
                sb.append(data).append(", ");
            }else queue.add(data);
        }

        sb.append(queue.poll()).append(">");
        System.out.println(sb);
    }
}