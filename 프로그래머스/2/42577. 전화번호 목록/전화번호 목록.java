import java.util.*;
class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        
        HashMap<String,String> map = new HashMap<>();
        for(int i = 0; i<phone_book.length; i++){
            map.put(phone_book[i], " ");
        }
        
       for (String p : phone_book) {
            for (int i = 0; i < p.length(); i++) {
                if (map.containsKey(p.substring(0, i))) {
                    answer = false;
                }
            }
        }
        return answer;
    }
}