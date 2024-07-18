package simulation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.*;

public class Main_21608 { //상어 초등학교

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int N;
    static int[][] map;
    static int[] dy = {1, -1, 0, 0};
    static int[] dx = {0, 0, 1, -1};
    static List<Integer>[] favorites;
    static int answer;
    static List<Seat> seats;

    public static class Seat {
        public int favoriteStudentCnt;
        public int emptyCnt;
        public int y;
        public int x;

        public Seat(int favoriteStudentCnt, int emptyCnt, int y, int x) {
            this.favoriteStudentCnt = favoriteStudentCnt;
            this.emptyCnt = emptyCnt;
            this.y = y;
            this.x = x;
        }
    }

    public static void main(String[] args) throws Exception {
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        favorites = new List[N * N + 1];

        for (int i = 0; i < N * N + 1; i++) {
            favorites[i] = new ArrayList<>();
        }

        for (int i = 0; i < N * N; i++) {
            st = new StringTokenizer(br.readLine());
            int student = Integer.parseInt(st.nextToken());

            for (int j = 0; j < 4; j++) {
                favorites[student].add(Integer.parseInt(st.nextToken()));
            }

            seats = new ArrayList<>();
            setSeat(student);
        }

        answer = 0;

        for (int y = 0; y < N; y++) {
            for (int x = 0; x < N; x++) {
                int student = map[y][x];
                int favoriteCnt = 0;

                for (int d = 0; d < 4; d++) {
                    int ny = y + dy[d];
                    int nx = x + dx[d];

                    if (ny < 0 || nx < 0 || ny >= N || nx >= N) continue;

                    if (favorites[student].contains(map[ny][nx])) {
                        favoriteCnt++;
                    }
                }

                switch (favoriteCnt) {
                    case 1:
                        answer += 1;
                        break;

                    case 2:
                        answer += 10;
                        break;

                    case 3:
                        answer += 100;
                        break;

                    case 4:
                        answer += 1000;
                        break;
                }
            }
        }

        System.out.println(answer);
    }

    public static void setSeat(int student) {
        for (int y = 0; y < N; y++) {
            for (int x = 0; x < N; x++) {

                if (map[y][x] != 0) continue;

                checkSeat(y, x, student);
            }
        }

        Collections.sort(seats, (a, b) -> {
            if (b.favoriteStudentCnt == a.favoriteStudentCnt) {
                if (b.emptyCnt == a.emptyCnt) {
                    if (a.y == b.y) {
                        return a.x - b.x;
                    }

                    return a.y - b.y;
                }
                return b.emptyCnt - a.emptyCnt;
            }

            return b.favoriteStudentCnt - a.favoriteStudentCnt;
        }); //활용도

        Seat seat = seats.get(0);

        map[seat.y][seat.x] = student;
    }

    public static void checkSeat(int y, int x, int student) {
        int favoriteCnt = 0;
        int emptyCnt = 0;

        for (int d = 0; d < 4; d++) {
            int ny = y + dy[d];
            int nx = x + dx[d];

            if (ny < 0 || nx < 0 || ny >= N || nx >= N) continue;

            if (favorites[student].contains(map[ny][nx])) {
                favoriteCnt++;
            } else if (map[ny][nx] == 0) {
                emptyCnt++;
            }
        }

        seats.add(new Seat(favoriteCnt, emptyCnt, y, x));
    }
}
