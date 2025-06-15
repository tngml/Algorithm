import java.io.*;

public class Main {
    static char[][] map;

    public static void draw(int x, int y, int size) {
        
        for (int i = 0; i < size; i++) {
            map[x][y + i] = '*'; // 위쪽
            map[x + size - 1][y + i] = '*'; // 아래쪽
            map[x + i][y] = '*'; // 왼쪽
            map[x + i][y + size - 1] = '*'; // 오른쪽
        }

        
        if (size <= 4) return;

        
        draw(x + 2, y + 2, size - 4);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int size = 4 * n - 3;
        map = new char[size][size];

        
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                map[i][j] = ' ';
            }
        }

        draw(0, 0, size);

        
        StringBuilder sb = new StringBuilder();
        for (char[] row : map) {
            for (char c : row) {
                sb.append(c);
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }
}