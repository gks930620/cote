import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int w, h;
    static int[][] a;
    static boolean[][] visit;
    static int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};


    static void input() {
        w = scan.nextInt();
       h = scan.nextInt();
        a = new int[w+1][h+1];
        for (int i = 1; i <= h; i++){
            for (int j = 1; j <= w; j++){
                    a[j][i] = scan.nextInt();   //    x는 가로, y는 세로
            }
        }
        visit = new boolean[w+1][h+1];
    }

    // x, y 를 갈 수 있다는 걸 알고 방문한 상태
    static void dfs(int x, int y) {
        visit[x][y]=true;

        for(int[] direction : dir){
            int nx= x+direction[0];
            int ny= y+direction[1];
            if(nx <=0  || ny<=0 || nx>w || ny>h) continue;
            if(a[nx][ny]!=1) continue;
            if(visit[nx][ny]) continue;
            dfs(nx, ny);
        }
    }

    static void pro() {
       int ans=0;
        for(int i=1 ; i<=h ; i++){
            for(int j=1 ; j<=w ; j++){
                if(!visit[j][i] && a[j][i]==1){
                    ans++;
                    dfs(j,i);
                }
            }
        }
        System.out.println(ans);
    }

    public static void main(String[] args) {
        while (true) {
            input();
            if (w == 0 && h == 0) break;
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