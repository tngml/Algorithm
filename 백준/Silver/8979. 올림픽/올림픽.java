import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
	
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		
		int[][] arr = new int [N][4];
		
		 int kGold = 0, kSilver = 0, kBronze = 0;
		
		for(int i =0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			int id = Integer.parseInt(st.nextToken());
            int gold = Integer.parseInt(st.nextToken());
            int silver = Integer.parseInt(st.nextToken());
            int bronze = Integer.parseInt(st.nextToken());
            
            arr[i][0] = id;
            arr[i][1] = gold;
            arr[i][2] = silver;
            arr[i][3] = bronze;
            
            if(id == K) {
            	kGold = gold;
            	kSilver = silver;
            	kBronze = bronze;
            }
			
		}
		
		int rank = 1;
		
		for(int i = 0; i<N; i++) {
			if(arr[i][1] > kGold) {
				rank++;
			}else if(arr[i][1] == kGold && arr[i][2] > kSilver) {
				rank++;
			}else if(arr[i][1] == kGold && arr[i][2] == kSilver && arr[i][3] >kBronze) {
				rank++;
			}
		}
		
		System.out.println(rank);
		
		
	}

}
