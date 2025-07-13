class Solution {
    boolean solution(String s) {
        boolean answer = true;
        int pcount = 0;
        int ycount = 0;
        
        for(int i = 0; i<s.length(); i++){
            char ch = Character.toLowerCase(s.charAt(i));
            if(ch == 'p'){
                pcount++;
            }else if(ch == 'y'){
                ycount++;
            }
            
        }
        
        if(pcount != ycount){
           answer = false;
        }
        

        return answer;
    }
}