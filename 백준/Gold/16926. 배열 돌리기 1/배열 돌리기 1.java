
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main{

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        int[][] map = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int layerCount = Math.min(N, M) / 2;

        for (int layer = 0; layer < layerCount; layer++) {
            List<Integer> list = new ArrayList<>();

            int top = layer;
            int bottom = N - 1 - layer;
            int left = layer;
            int right = M - 1 - layer;

            for (int i = left; i < right; i++) list.add(map[top][i]);
            for (int i = top; i < bottom; i++) list.add(map[i][right]);
            for (int i = right; i > left; i--) list.add(map[bottom][i]);
            for (int i = bottom; i > top; i--) list.add(map[i][left]);

            int size = list.size();
            int rot = R % size;
            List<Integer> rotated = new ArrayList<>();
            rotated.addAll(list.subList(rot, size));
            rotated.addAll(list.subList(0, rot));

            int idx = 0;

            for (int i = left; i < right; i++) map[top][i] = rotated.get(idx++);
            for (int i = top; i < bottom; i++) map[i][right] = rotated.get(idx++);
            for (int i = right; i > left; i--) map[bottom][i] = rotated.get(idx++);
            for (int i = bottom; i > top; i--) map[i][left] = rotated.get(idx++);
        }

        StringBuilder sb = new StringBuilder();
        for (int[] row : map) {
            for (int val : row) {
                sb.append(val).append(" ");
            }
            sb.append("\n");
        }

        System.out.print(sb);
    }
}