import java.util.Arrays;

class Solution {
    public String solution(String X, String Y) {
        char[] a = X.toCharArray();
        char[] b = Y.toCharArray(); 

        Arrays.sort(a);
        Arrays.sort(b);
        reverse(a);
        reverse(b);

        StringBuilder sb = new StringBuilder();
        int i = 0, j = 0;

        while (i < a.length && j < b.length) {
            if (a[i] == b[j]) {
                sb.append(a[i]);
                i++; j++;
            } else if (a[i] > b[j]) {
                i++;
            } else {
                j++;
            }
        }

        if (sb.length() == 0) return "-1";   // 공통 없음
        if (sb.charAt(0) == '0') return "0"; // 전부 0

        return sb.toString();
    }

    private void reverse(char[] arr) {
        int l = 0, r = arr.length - 1;       // r 선언/초기화
        while (l < r) {
            char tmp = arr[l];
            arr[l] = arr[r];
            arr[r] = tmp;                    // 스왑 수정
            l++; r--;
        }
    }
}