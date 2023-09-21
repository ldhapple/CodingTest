import javax.print.attribute.IntegerSyntax;
import java.math.BigInteger;
import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        HashSet<Long> sosu = new HashSet<>();

        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < N; i++){
            BigInteger bi = new BigInteger(st.nextToken());

            if(bi.isProbablePrime(10)){
                sosu.add(Long.parseLong(bi.toString()));
            }
        }

        if(sosu.isEmpty()){
            System.out.print(-1);
        }else{
            long answer = 1;
            for(Long num : sosu){
                answer *= num;
            }
            System.out.print(answer);
        }
    }
}
