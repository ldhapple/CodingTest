import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.*;
import java.util.regex.Pattern;

public class Main {

    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String pt = br.readLine();
        int starIndex = pt.indexOf("*");
        String start = pt.substring(0, starIndex);
        String end = pt.substring(starIndex+1, pt.length());
        Pattern pattern = Pattern.compile("^(" + start + ")+[a-z]*(" + end + ")+$");

        for (int i = 0; i < N; i++) {
            String str = br.readLine();

            if (pattern.matcher(str).matches()) {
                System.out.println("DA");
            } else {
                System.out.println("NE");
            }
        }
    }
}
