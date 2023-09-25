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

        for(int i = 0; i < N; i++){
            String str = br.readLine();

            System.out.println(isPalindrome(str));
        }
    }

    public static int isPalindrome(String str){
        int left = 0;
        int right = str.length() - 1;
        int check_count = 0;

        while(left <= right){
            if(str.charAt(left) == str.charAt(right)){
                left++;
                right--;
            }else{
                left++;
                if(str.charAt(left) == str.charAt(right)){
                    check_count++;
                    left++;
                    right--;
                }else{
                    left--;
                    right--;

                    if(str.charAt(left) == str.charAt(right)){
                        check_count++;
                        left++;
                        right--;
                    } else{
                        return 2;
                    }
                }
            }
        }

        if(check_count == 1) return 1;
        else if(check_count == 0) return 0;
        else return 2;
    }
}
