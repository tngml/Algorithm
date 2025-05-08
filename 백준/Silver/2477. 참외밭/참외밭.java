

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main{
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//참외수 
		int cucumisMelo = Integer.parseInt(br.readLine());
		
		int [][] info = new int [6][2];
		
		for(int i = 0; i<6; i++) {
			String [] input = br.readLine().split(" " );
			info[i][0] = Integer.parseInt(input[0]);
			info[i][1] = Integer.parseInt(input[1]);
		}
		
		int maxWidth = 0;
		int maxHeight =0;
		int maxWidx = 0;
		int maxHidx =0;
		
		for(int i =0; i<6; i++) {
			int dir = info[i][0];
			int len = info[i][1];
			
			if(dir == 1 || dir == 2) {
				if(len > maxWidth) {
					maxWidth = len;
					maxWidx = i;
				}
			}else {
				if(len > maxHeight) {
					maxHeight = len;
					maxHidx = i;
				}
			}
		}
		
		int smallW = Math.abs(info[(maxHidx + 5) % 6][1] - info[(maxHidx + 1) % 6][1]);
		int smallH = Math.abs(info[(maxWidx + 5) % 6][1] - info[(maxWidx + 1) % 6][1]);

		
		int bigbox = maxWidth * maxHeight;
		int smallbox = smallW * smallH;
		
		int result = (bigbox - smallbox) * cucumisMelo;
		
		System.out.println(result);
		
		
		
		
	}

}
