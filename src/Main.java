import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N, M;
    static String[] a;
    static int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    static boolean[][] visit;
    static int[][] dist_water, dist_hedgehog;


    static void input() {
        N=scan.nextInt();  //행
        M= scan.nextInt(); //열   for문은 행이 바깥
        a=new String[N];
        for(int i=0 ; i<N ; i++){
            a[i]=scan.next();
        }
        visit=new boolean[N][M];
        dist_water=new int[N][M];
        dist_hedgehog=new int[N][M];
    }

    // 모든 물들을 시작으로 동시에 BFS 시작!
    static void bfs_water() {
        Queue<Integer> que=new LinkedList<>();
        //모든 물이 start 지역
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                dist_water[i][j] = -1;
                visit[i][j] = false;
                if (a[i].charAt(j) == '*') {
                    que.add(i);
                    que.add(j);
                    dist_water[i][j] = 0;
                    visit[i][j] = true;
                }
            }
        }
        while (!que.isEmpty()){
            int x = que.poll();
            int y=que.poll();

            for(int[] direction : dir){
                int nx=direction[0]+x;
                int ny=direction[1]+y;
                if(nx <0 || ny<0 || nx>=N || ny>=M) continue;
                if( visit[nx][ny]  )continue;
                if( a[nx].charAt(ny)=='D'  || a[nx].charAt(ny)=='X' ) continue;

                que.add(nx);
                que.add(ny);
                dist_water[nx][ny]=dist_water[x][y]+1;
            }

        }
    }

    // 고슴도치를 시작으로 동시에 BFS 시작!
    static void bfs_hedgehog() {
        //dist[][]값을 보고  물이 먼저 차 있으면 못 가는 것으로 판단
        Queue<Integer> que=new LinkedList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                dist_hedgehog[i][j] = -1;
                visit[i][j] = false;
                if (a[i].charAt(j) == 'S') {
                    que.add(i);
                    que.add(j);
                    dist_hedgehog[i][j] = 0;
                    visit[i][j] = true;
                }
            }
        }

        while (!que.isEmpty()){
            int x = que.poll();
            int y=que.poll();
            for(int[] direction : dir){
                int nx=direction[0]+x;
                int ny=direction[1]+y;
                if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;  // 지도를 벗어나는 곳으로 가는가?
                if (a[nx].charAt(ny) != '.' && a[nx].charAt(ny) != 'D') continue;  // 갈 수 있는 칸인지 확인해야 한다.
                if (dist_water[nx][ny] != -1 && dist_water[nx][ny] <= dist_hedgehog[x][y] + 1) continue;  // 물에 잠기지는 않는가?
                if (visit[nx][ny]) continue;  // 이미 방문한 적이 있는 곳인가?
                que.add(nx);
                que.add(ny);
                visit[nx][ny] = true;
                dist_hedgehog[nx][ny] = dist_hedgehog[x][y] + 1;
            }

        }


    }

    static void pro() {


        //물이 먼저.. 먼저가있는곳에 고슴도치는 못가니까..
        bfs_water();
        bfs_hedgehog();

    }

    public static void main(String[] args) {
        input();
        pro();
    }


    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        public FastReader(String s) throws FileNotFoundException {
            br = new BufferedReader(new FileReader(new File(s)));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}