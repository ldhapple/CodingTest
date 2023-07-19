import java.math.BigInteger;
import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    static int N;
    static int M;
    static long[] time;
    static final long INF = Integer.MAX_VALUE;

    static Bus busArr[];
    public static class Bus{
        public int start;
        public int end;
        public int weight;

        public Bus(int start, int end, int weight){
            this.start = start;
            this.end = end;
            this.weight = weight;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 도시의 개수
        M = Integer.parseInt(st.nextToken()); // 버스 노선의 개수

        busArr = new Bus[M];
        time = new long[N+1];

        Arrays.fill(time, INF);

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            busArr[i] = new Bus(start, end, weight);
        }

        if(bellmanFord()){
            for(int i = 2; i <= N; i++){
                if(time[i] == INF){
                    sb.append(-1).append("\n");
                }
                else{
                    sb.append(time[i]).append("\n");
                }
            }
        }else{
            sb.append(-1);
        }

        System.out.print(sb);
    }

    private static boolean bellmanFord(){
        time[1] = 0; //시작점

        for(int i = 1; i < N; i++){
            for(int j = 0; j < M; j++){
                Bus bus = busArr[j];

                if(time[bus.start] != INF && time[bus.end] > time[bus.start] + bus.weight){
                    time[bus.end] = time[bus.start] + bus.weight;
                }
            }
        }

        //음수 사이클 확인
        for(int i = 0; i < M; i++){
            Bus bus = busArr[i];

            if(time[bus.start] != INF && time[bus.end] > time[bus.start] + bus.weight){
                return false;
            }
        }
        return true;
    }

}