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

        String firstRegex = ".*[aeiou]+.*"; //모음 하나를 반드시 포함하여야 한다.

        while(true) {
            String str = br.readLine();
            boolean flag = true;

            if (str.equals("end")) {
                break;
            }

            if (!str.matches(firstRegex)) {
                flag = false;
            }

            int cnt = 1;
            boolean isAeiou = isAeiouu(str.charAt(0));
            for (int i = 1; i < str.length(); i++) {
                char c = str.charAt(i);

                if (isAeiouu(c)) {
                    if (isAeiou) {
                        cnt++;
                    } else if (!isAeiou) {
                        isAeiou = true;
                        cnt = 1;
                    }
                } else if (!isAeiouu(c)){
                    if (!isAeiou) {
                        cnt++;
                    } else if (isAeiou) {
                        isAeiou = false;
                        cnt = 1;
                    }
                }

                if (cnt == 3) {
                    flag = false;
                }

                if (c == str.charAt(i - 1)) { //연속으로 두 번 오면 안됨.
                    String check = String.valueOf(c) + String.valueOf(str.charAt(i-1));
                    if (!check.equals("ee") && !check.equals("oo")) {
                        flag = false;
                    }
                }
            }

            if (flag) {
                System.out.println("<" + str + "> " + "is acceptable.");
            } else if (!flag) {
                System.out.println("<" + str + "> " + "is not acceptable.");
            }
        }
    }

    private static boolean isAeiouu(char c) {
        return String.valueOf(c).matches("[aeiou]");
    }
}
