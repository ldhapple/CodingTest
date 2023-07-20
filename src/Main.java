import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.math.BigInteger;
import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    static Node root = new Node();
    static class Node{
        HashMap<String, Node> child;
        public Node(){
            child = new HashMap<>();
        }
    }
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            int K = Integer.parseInt(st.nextToken());
            Node cur = root;
            for(int j=0;j<K;j++){
                String temp = st.nextToken();
                if(!cur.child.containsKey(temp)){
                    cur.child.put(temp, new Node());
                }
                cur = cur.child.get(temp);
            }
        }
        print(root, "");
        System.out.print(sb);
    }

    static void print(Node cur, String s){
        //현재 방에 자식 구조 가져오기
        ArrayList<String> list = new ArrayList<>(cur.child.keySet());
        Collections.sort(list);		//사전 순 정렬
        //정렬 이후 사전 순으로 표시 후 탐색
        for(String str : list){
            sb.append(s).append(str).append("\n");
            print(cur.child.get(str), s +"--");
        }
    }
}