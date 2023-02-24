package finished;

import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class BOJ11403경로찾기 {  //11403
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N;
    static int[][] adj;   //i에서 j로 가는 방향.
    static boolean[] visit;

    static void input() {
        /* TODO */
        N = scan.nextInt();
        adj = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                adj[i][j] = scan.nextInt();
            }
        }
    }


    // start 에서 시작해서 갈 수 있는 정점들을 모두 탐색하기
    static void bfs(int start) {
        /* TODO */
        for (int i = 1; i <= N; i++) visit[i] = false;
        Queue<Integer> que = new LinkedList<>();
        //start에서 갈 수 있는 모든 점들 que에 넣어.

        que.add(start);  //
        visit[start] = false; // 내 위치에서 다시 돌아올 수 있는지 모르니까 false로 시작한다.

        while (!que.isEmpty()){
            int x=que.poll();
            for(int i=1; i<=N ; i++){  //x에서 갈 수 있는 모든 점 조회
                if(adj[x][i]==1 && !visit[i]){     //실제로 갈수 있는점들
                    que.add(i);
                    visit[i]=true;      // i 번째로 갈 수 있으니까 true
                    adj[start][i]=1;
                }
            }

        }

    }

    static void pro() {
        visit = new boolean[N + 1];
        for (int i = 1; i <= N; i++)
            bfs(i);

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                System.out.print(adj[i][j] + " ");
            }
            System.out.println();
        }

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