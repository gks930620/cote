import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N, M;
    static String[] a;
    static int[][] dist;
    static boolean[][] visit;
    static int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    static ArrayList<Integer> group;

    static void input() {
        N = scan.nextInt();
        M = scan.nextInt();
        a = new String[N];
        for (int i = 0; i < N; i++)
            a[i] = scan.nextLine();
        visit = new boolean[N][M];
        dist = new int[N][M];
    }



    // x, y 를 갈 수 있다는 걸 알고 방문한 상태
    static void bfs(int x, int y) {
        // dist 배열 초기화
        /* TODO */
        for(int i=0 ; i<N ; i++){
            for(int j=0 ; j<M ; j++){
                dist[i][j]=-1;   //거리  일단 다 못가는걸로 초기화.
            }
        }
        // (x, y)를 Q에 넣어주고, visit 표시와 dist 값 초기화
        /* TODO */
        Queue<Integer> que= new LinkedList<>();
        que.add(x);
        que.add(y);  //이번엔 state안쓰고.
        visit[x][y]=true;
        dist[x][y]=1;  //시작점이 1이다..  0,0은 이해가 되는데 왜?   ..  는 dfs가 아니라 0,0만 1로 표기한다는거임. 나머지는 while문에서 처리됨
        // BFS 과정 시작
        /* TODO */
        while (!que.isEmpty()){
             x=que.poll();
             y=que.poll();
             for(int[] direction : dir){
                 int nx=x+direction[0];
                 int ny=y+direction[1];
                 if(nx<0 || ny<0 || nx>=N || ny>=M )continue;;
                 if(a[nx].charAt(ny)=='0')  continue;;
                 if(visit[nx][ny]) continue;
                 visit[nx][ny]=true;
                 que.add(nx);
                 que.add(ny);
                 dist[nx][ny]=dist[x][y]+1;   //애 Math.min 안 써도 될까??   bfs자체가  이동횟수가 적은게 먼저 옴.  즉 dist[nx][ny]에 기존에 더 오래걸려서 오는 경우는 visit에 걸림.
             }
        }
    }

    static void pro() {
        // 시작점이 (0, 0)인 탐색 시작
        /* TODO */
        bfs(0,0);



        // (N-1, M-1)까지 필요한 최소 이동 횟수 출력
        /* TODO */
        System.out.println(dist[N-1][M-1]);
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