import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class BOJ4963섬의개수 {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N, M;
    static int[][] a;
    static boolean[][] visit;
    static int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};

    static void input() {
        M=scan.nextInt();

        N=scan.nextInt();

        a=new int[N+1][M+1];            //N이 가로, M이 세로
        visit=new boolean[N+1][M+1];
        for(int i=1 ; i<=N; i++){
            for(int j=1 ; j<=M ; j++){
                a[i][j]=scan.nextInt();
            }
        }
    }

    // x, y 를 갈 수 있다는 걸 알고 방문한 상태
    static void dfs(int x, int y) {
        visit[x][y]=true;
        for(int[] direction : dir){
            int nx= x+direction[0];
            int ny= y+direction[1];
            if(nx <=0 || ny<=0 || nx>N || ny>M) continue;
            if (a[nx][ny] == 0) continue;
            if(visit[nx][ny]) continue;
            dfs(nx,ny);
        }
    }

    static void pro() {
        int ans = 0;
        //초기화
        for(int i=1 ; i<=N; i++){
            for(int j=1 ; j<=M ; j++){
                visit[i][j]=false;
            }
        }
        for(int i=1 ; i<=N; i++){
            for(int j=1 ; j<=M ; j++){
                if(visit[i][j]==false && a[i][j]==1){
                    dfs(i,j);
                    ans++;  //dfs한번 할 때마다 섬 증가.    dfs로 인해 방문한 섬은 다음 for문에서 dfs 안함
                }
            }
        }
        System.out.println(ans);
    }

    public static void main(String[] args) {
        while (true) {
            input();
            if (N == 0 && M == 0) break;
            pro();
        }
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