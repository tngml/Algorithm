import java.util.*;
class Solution {
    public int[] solution(int[] array, int[][] commands) {

        List<Integer> list = new ArrayList<>();
        for(int i = 0; i<commands.length; i++){
            int start = commands[i][0] -1;
            int end = commands[i][1];
            int k = commands[i][2] -1;
            
            int [] tmp = Arrays.copyOfRange(array, start, end);
            
            Arrays.sort(tmp);
            list.add(tmp[k]);
        }
        
        int [] answer = list.stream().mapToInt(i->i).toArray();
        return answer;
}
}