package boj;
import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class BOJ18404현명한나이트 {  //18404 현명한나이트
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N, M, sx, sy;
    static int[][] dist;
    static int[][] dir = {{-1,-2},{-2,-1},{-1,2},{-2,1},{1,-2},{2,-1},{1,2},{2,1}};

    static void input() {
        N = scan.nextInt();   //체스판크기
        M = scan.nextInt();   // 잡을 말
        sx = scan.nextInt();   //나이트 x
        sy = scan.nextInt();  //나이트 y
        dist = new int[N + 1][N + 1];
    }

    static void bfs() {
        // 초기화 해주기
        /* TODO */
        // [x][y]  = [세로] [가로]       for문 바깥이 세로


        // BFS 과정 시작
        /* TODO */
        Queue<Integer> que= new LinkedList<>();
        que.add(sx);
        que.add(sy);
        dist[sx][sy]=0;

        while (!que.isEmpty()){
            int x= que.poll();
            int y=que.poll();

            for(int[] direction : dir){
                int nx= x+direction[0];
                int ny= y+direction[1];
                if( nx>N || ny >N || nx<=0 || ny<=0) continue;
                if( dist[nx][ny]!=0) continue;  //방문했던곳
                que.add(nx);
                que.add(ny);
                dist[nx][ny]= dist[x][y]+1;
            }
        }



    }

    static void pro() {
        bfs();
        while (M-- > 0) {
            int ex = scan.nextInt();
            int ey = scan.nextInt();
            System.out.print(dist[ex][ey]+ " ");
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