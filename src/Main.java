import java.io.BufferedReader;
import java.io.InputStreamReader;
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

        String str = br.readLine();
        String regexStr = br.readLine();

        Pattern pattern = Pattern.compile(regexStr);
        Matcher matcher = pattern.matcher(str);

        int cnt = 0;
//        System.out.print(matcher.find());
//        System.out.print(matcher.find());
//        System.out.print(matcher.find());
        while(matcher.find()) {
            cnt++;
        }

        System.out.print(cnt);
    }
}
