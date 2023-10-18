import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.*;

public class Main {

    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;



    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String S = br.readLine();
        String T = br.readLine();

        if (solve(S, T)) {
            System.out.print(1);
        } else {
            System.out.print(0);
        }
    }

    public static String reverse(String str) {
        sb = new StringBuilder(str);
        sb.reverse();
        return sb.toString();
    }

    public static boolean solve(String S, String str) {
        if (str.length() == S.length()) {
            if (str.equals(S)) return true;
            return false;
        }

        if (str.charAt(str.length() - 1) == 'A') {
            if (solve(S, str.substring(0, str.length() - 1))) {
                return true;
            }
        }

        if (str.charAt(0) == 'B') {
            if (solve(S, reverse(str).substring(0, str.length() - 1))) {
                return true;
            }
        }

        return false;
    }
}
