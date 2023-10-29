import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Pattern patternJava = Pattern.compile("^[a-z]+(([A-Z])([a-z]*))*$");
        Pattern patternCpp = Pattern.compile("^[a-z]+(_[a-z]+)*$");

        String str = br.readLine();

        if (patternCpp.matcher(str).matches()) {
            String[] alp = str.split("_");
            String ans = alp[0];
            for (int i = 1; i < alp.length; i++) {
                ans += String.valueOf(alp[i].charAt(0)).toUpperCase();
                ans += alp[i].substring(1, alp[i].length());
            }

            System.out.println(ans);
        } else if (patternJava.matcher(str).matches()) {
            String ans = "";
            for (int i = 0; i < str.length(); i++) {
                if (String.valueOf(str.charAt(i)).matches("[A-Z]")) {
                    ans += "_";
                    ans += String.valueOf(str.charAt(i)).toLowerCase();
                } else {
                    ans += str.charAt(i);
                }
            }
            System.out.println(ans);
        } else {
            System.out.println("Error!");
        }
    }
}
