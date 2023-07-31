import java.awt.*;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.math.BigInteger;
import java.security.cert.CollectionCertStoreParameters;
import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int[] dx = {-1,-1,0,1,1,1,0,-1};
    static int[] dy = {0,1,1,1,0,-1,-1,-1};
    static int N, M, K, MAX_LENGTH;
    static Map<String, Integer> map = new HashMap<>();
    static char[][] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        K = Integer.parseInt(st.nextToken());

        arr = new char[N][M];
        MAX_LENGTH = 5;

        for(int i = 0; i < N; i++){
            arr[i] = br.readLine().toCharArray();
        }

        String[] string_arr = new String[K];

        for(int i = 0; i < K; i++){
            String favoriteString = br.readLine();
            //MAX_LENGTH = Math.max(MAX_LENGTH, favoriteString.length());

            map.put(favoriteString, 0);
            string_arr[i] = favoriteString;
        }

        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                dfs(i,j,1, Character.toString(arr[i][j]));
            }
        }

        for(String key : string_arr){
            sb.append(map.get(key)).append("\n");
        }

        System.out.print(sb);
    }

    public static void dfs(int x, int y, int depth, String result){
        if(map.containsKey(result)){
            map.put(result, map.get(result) + 1);
        }

        if(depth == MAX_LENGTH) return;

        for(int i = 0; i < dx.length; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx < 0) nx = N-1;
            else if(nx >= N) nx = 0;

            if(ny < 0) ny = M-1;
            else if(ny >= M) ny = 0;

            dfs(nx,ny,depth+1,result + arr[nx][ny]);
        }
    }
}