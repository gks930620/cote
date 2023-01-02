import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class BOJ1697숨바꼭질 {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N, K;
    static int[] dist;
    static boolean[] visit;

    static void input() {
        N = scan.nextInt();
        K = scan.nextInt();
        visit = new boolean[100005];
        dist = new int[100005];
    }

    // 숨바꼭질 시작~
    static void bfs() {
        Queue<Integer> queue = new LinkedList<>();
        /* TODO */
        queue.add(N); //처음 수빈이 위치
        visit[N]=true;
        dist[N]=0;
        // BFS 과정 시작
        /* TODO */
        while(!queue.isEmpty()){
            int x=queue.poll();

            //갈수있는점들이 3개.. 그냥 직접 쓰자
            //1번
            int y=x-1;
            if(y>=0 && y<=100000 && visit[y]==false ){
                visit[y]=true;
                queue.add(y);
                dist[y]=dist[x]+1;
                if( y==K )break;

            }


            y=x+1;
            if(y>=0 && y<=100000 && visit[y]==false ){
                visit[y]=true;
                queue.add(y);
                dist[y]=dist[x]+1;
                if( y==K )break;
            }
            y=2*x;
            if(y>=0 && y<=100000 && visit[y]==false ){
                visit[y]=true;
                queue.add(y);
                dist[y]=dist[x]+1;
                if( y==K )break;
            }
        }
    }

    static void pro() {
        bfs();
        System.out.println(dist[K]);
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