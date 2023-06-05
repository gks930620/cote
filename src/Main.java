import javax.sound.sampled.Line;
import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N, M, K;
    static int[][] a;
    static boolean[][] visit;
    static int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    static void input() {
        M = scan.nextInt();  //가로
        N = scan.nextInt();  //세로
        K = scan.nextInt();  //배추
        a = new int[N][M];  //  세로, 가로   for문은 세로부터 돌아야지
        for (int i = 0; i < K; i++) {
            int y = scan.nextInt(), x = scan.nextInt();   //가로, 세로
            a[x][y] = 1;  //세로, 가로
        }
        visit = new boolean[N][M];  //[세로][가로]
    }

    // x, y 를 갈 수 있다는 걸 알고 방문한 상태
    static void dfs(int x, int y) {  //세로, 가로   (N,M)
        /* TODO */
        visit[x][y]=true;

        for(int[] direction : dir){
            int nx= x+direction[0];   //세로
            int ny=y+direction[1];     //가로
            if(nx >=N  || ny >= M || nx<0 || ny<0) continue;
            if(  visit[nx][ny]) continue;
            if(a[nx][ny]!=1) continue;
            dfs(nx,ny);

        }

    }

    static void bfs(int x, int y){//세로, 가로   (N,M)

        Queue<Integer> que= new LinkedList<>();
        que.add(x);
        que.add(y);
        visit[x][y]=true;
        while (!que.isEmpty()){
            x= que.poll();
            y = que.poll();

            for(int[] direction : dir){
                int nx= x+direction[0];   //세로
                int ny=y+direction[1];     //가로
                if(nx >=N  || ny >= M || nx<0 || ny<0) continue;
                if(  visit[nx][ny]) continue;
                if(a[nx][ny]!=1) continue;
                que.add(nx);
                que.add(ny);
                visit[nx][ny]=true;
            }
        }
    }

    static void pro() {
        int ans = 0;
        for (int i = 0; i < N; i++) { //세로
            for (int j = 0; j < M; j++) { //가로
                if (!visit[i][j] && a[i][j] == 1) {   //배추가 있고 방문한 적이 없다면
                    // 새로운 배추흰지렁이 발견!
                    /* TODO */
                   // dfs(i,j);  //세로, 가로
                    bfs(i,j);
                    ans++;
                }
            }
        }

        System.out.println(ans);
    }

    public static void main(String[] args) {
        int T = scan.nextInt();
        while (T-- > 0) {
            input();
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