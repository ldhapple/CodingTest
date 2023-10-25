import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.*;

public class Main {

    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static final String REGEX = "^[A-F]?A+F+C+[A-F]?$";
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        for (int t = 0; t < N; t++) {
            String str = br.readLine();
            if (str.matches(REGEX)) {
                System.out.println("Infected!");
            } else {
                System.out.println("Good");
            }
        }
    }
}
