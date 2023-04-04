package boj;

import java.io.*;
import java.util.*;

public class BOJ2178미로탐색 {
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
    static void bfs() {
        // dist 배열 초기화
        /* TODO */
        for(int i=0 ; i<N ; i++){
            for(int j=0 ;j<M ; j++){
                dist[i][j]=-1;
            }
        }
        // (x, y)를 Q에 넣어주고, visit 표시와 dist 값 초기화
        /* TODO */
        Queue<Integer> que=new LinkedList<>();
        que.add(0);
        que.add(0);
        visit[0][0]=true;
        dist[0][0]=1; //문제예시에서 초기값 1

        // BFS 과정 시작
        /* TODO */
        while (!que.isEmpty()){
            int x=que.poll();
            int y=que.poll();

            for(int[] direction  : dir){
                int nx=x+direction[0];
                int ny=y+direction[1];

                if(nx<0 || ny<0 || nx>=N ||ny>=M ) continue;
                if(a[nx].charAt(ny)!='1') continue;
                if(visit[nx][ny])continue;
                visit[nx][ny]=true;
                que.add(nx);
                que.add(ny);
                dist[nx][ny]=dist[x][y]+1;
            }
        }

    }

    static void pro() {
        bfs();
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