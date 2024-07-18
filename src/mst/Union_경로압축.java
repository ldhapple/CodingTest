package mst;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//기존 방법은 타고타고 올라가서 부모를 찾게 되었는데, 바로 부모를 찾을 수 있도록 하도록 바꾼다. (findSet 수정)
public class Union_경로압축 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int V, E; //정점, 간점
    static int[] parent;

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        parent = new int[V + 1];
        makeSet();

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            union(x, y);
        }

        for (int i = 1; i <= V; i++) {
            System.out.print(findSet(i) + " ");
        }
        System.out.println();

        for (int i = 1; i <= V; i++) {
            System.out.print(parent[i] + " ");
        }
        System.out.println();
    }

    static void makeSet() {
        /*
        자료 구조를 집합 관계로 만든다.
        각 정점은 모두 서로소인 상태 (공통 원소가 없는 두 집합 = 자기자신끼리 하나의 집합이 되면)
        ex) parent[3] = 4의 의미는
        3이라는 정점은 4가 부모인 집합을 포함한다는 뜻
         */
        for (int i = 1; i <= V; i++) {
            parent[i] = i;
        }
    }

    /*
    1 2 3 4 5 6
    1 1 2 2 4 6

    위와 같은 상태라면 3은 2를 부모로 갖고 2는 1을 부모로 갖는 것.
    6빼고 전부 1을 부모로 갖게되고 같은 집합에 있다는 뜻.
     */

    static int findSet(int x) {
        /*
        주어진 정점의 부모를 찾는 메서드
        x의 부모
         */
        if (parent[x] == x) return x;

        return parent[x] = findSet(parent[x]); //집합관계 타고 올라감 자기 자신과 똑같은 것이 부모다
    }

    static void union(int x, int y) {
        /*
        두 정점을 하나의 집합으로 만든다.
        두 부모의 수 중 작은 수를 부모로 만드는 것으로 한다.
        위의 예시라고 치면 3과 6을 합쳤을 때
        3의 부모는 1, 6의 부모는 6이므로
        3의 부모와 6의 부모가 연결된다.
         */

        int px = findSet(x);
        int py = findSet(y);

        if (px < py) {
            parent[py] = px;
        } else {
            parent[px] = py;
        }
    }
}
