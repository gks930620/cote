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
        M = scan.nextInt(); //세로
        N = scan.nextInt(); //가로
        K = scan.nextInt();  //배추개수
        a = new int[M][N];  //항상 세로먼저
        for (int i = 0; i < K; i++) { //0부터네
            int x= scan.nextInt(), y = scan.nextInt();  //세로, 가로
            a[x][y] =1;
        }
        visit = new boolean[M][N];   // , 세로 가로
    }

    // x, y 를 갈 수 있다는 걸 알고 방문한 상태
    static void dfs(int x, int y) {  //세로 가로 
        /* TODO */
        visit[x][y]=true;

        for(int[] direction : dir){
            int nx=x+direction[0]; //세로 
            int ny=y+direction[1]; //가로
            if(nx>= M || ny>=N || nx<0 || ny<0) continue;
            if(a[nx][ny]==0) continue;
            if(visit[nx][ny])continue;;
            dfs(nx,ny);

        }
    }

    static  void bfs(int startX, int startY){ //bfs로도 똑같이 풀 수 있다..
        Queue<Integer> que= new LinkedList<>();
        que.add(startX);
        que.add(startY); //세로먼저 넣음
        visit[startX][startY]=true;
        while (!que.isEmpty()){
            int x= que.poll();
            int y=que.poll();
            for(int[] direction : dir){
                int nx= x+direction[0];
                int ny= y+direction[1];
                if(nx>= M || ny>=N || nx<0 || ny<0) continue;
                if(a[nx][ny]==0) continue;
                if(visit[nx][ny])continue;
                que.add(nx);
                que.add(ny);
                visit[nx][ ny]=true;
            }
        }
    }

    static void pro() {
        int ans = 0;
        for (int i = 0; i < M; i++) {  //세로
            for (int j = 0; j < N; j++) { //가로
                if (!visit[i][j] && a[i][j] == 1) { //방문한적이없고, 지렁이라면 시작;
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