import java.awt.*;
import java.awt.image.AreaAveragingScaleFilter;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.math.BigInteger;
import java.security.cert.CollectionCertStoreParameters;
import java.sql.Array;
import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        String check = br.readLine();

        Stack<Character> stack = new Stack<>();

        for(int i = 0; i < str.length(); i++){
            stack.push(str.charAt(i));

            if(stack.size() >= check.length()){
                boolean flag = true;

                for(int j = 0; j < check.length(); j++){
                    if(stack.get(stack.size() - check.length() + j) != check.charAt(j)){
                        flag = false;
                        break;
                    }
                }

                if(flag){
                    for(int j = 0; j < check.length(); j++){
                        stack.pop();
                    }
                }
            }
        }

        for(Character c : stack){
            sb.append(c);
        }

        if(sb.toString().equals("")){
            sb.append("FRULA");
        }
        System.out.print(sb);
    }

}
