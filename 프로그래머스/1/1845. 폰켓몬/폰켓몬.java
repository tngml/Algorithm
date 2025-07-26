import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int answer = 0;
      
        Set<Integer> set = new HashSet<>();
        for(int num : nums){
            set.add(num);
        }
        
        int pick = nums.length / 2;
        
        answer = Math.min(set.size(),pick);
        
        return answer;
    }
}