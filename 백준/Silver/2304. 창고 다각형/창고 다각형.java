import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] height = new int[1001];

        int minP = 1001;
        int maxP = 0;
        int maxH = 0;
        int maxPos = 0;

       
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int pos = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());
            height[pos] = h;

            if (pos < minP) minP = pos;
            if (pos > maxP) maxP = pos;
            if (h > maxH) {
                maxH = h;
                maxPos = pos;
            }
        }

        int area = 0;

       
        int leftMax = 0;
        for (int i = minP; i < maxPos; i++) {
            if (height[i] > leftMax) {
                leftMax = height[i];
            }
            area += leftMax;
        }

        
        int rightMax = 0;
        for (int i = maxP; i > maxPos; i--) {
            if (height[i] > rightMax) {
                rightMax = height[i];
            }
            area += rightMax;
        }

        
        area += maxH;

        System.out.println(area);
    }
}