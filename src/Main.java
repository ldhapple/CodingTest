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

        List<BigInteger> numList = new ArrayList<>();

        Long N = Long.parseLong(br.readLine());
        for (int i = 0; i < N; i++) {
            String str = br.readLine();

            String[] numbers = str.split("\\D");
            for (String num : numbers) {
                if (!num.equals("")) numList.add(new BigInteger(num));
            }
        }

        Collections.sort(numList);

        for (BigInteger i : numList) {
            System.out.println(i);
        }
    }
}
