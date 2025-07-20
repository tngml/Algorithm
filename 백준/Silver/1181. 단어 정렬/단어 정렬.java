import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Main {
	

	    public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);
	        int N = sc.nextInt();
	        sc.nextLine();

	        Set<String> set = new HashSet<>();

	        for (int i = 0; i < N; i++) {
	            set.add(sc.nextLine());
	        }

	        List<String> list = new ArrayList<>(set);

	        Collections.sort(list, new Comparator<String>() {
	            public int compare(String s1, String s2) {
	                if (s1.length() != s2.length()) {
	                    return s1.length() - s2.length(); 
	                }
	                return s1.compareTo(s2);
	            }
	        });

	        for (String word : list) {
	            System.out.println(word);
	        }
	    }
	}

