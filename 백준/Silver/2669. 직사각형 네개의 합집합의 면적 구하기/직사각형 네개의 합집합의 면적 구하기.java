import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	
	static int leftX,leftY,rightX,rightY;
	static boolean [][] visited;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		visited = new boolean [101][101];
		
		for(int k = 1; k<=4; k++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			leftX = Integer.parseInt(st.nextToken());
			leftY = Integer.parseInt(st.nextToken());
			rightX = Integer.parseInt(st.nextToken());
			rightY = Integer.parseInt(st.nextToken());
			
			for(int i = leftX; i<rightX; i++) {
				for(int j = leftY; j<rightY; j++) {
					visited[i][j] = true;
				}
			}
		}
		
		
		
        int area = 0;
        for (int x = 0; x <= 100; x++) {
            for (int y = 0; y <= 100; y++) {
                if (visited[x][y]) area++;
            }
        }

        System.out.println(area);
		
		
	}

}
