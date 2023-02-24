package finished;

import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class BOJ7576토마토2차원 {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N, M;
    static int[][] dist, a;
    static int[][] dir = { {0,1}, {0,-1},{1,0},{-1,0}};
    static void input() {
        M = scan.nextInt();  //가로가 M 세로가 N인데 for문은 대부분 세로가 바깥
        N = scan.nextInt();
        /* TODO */
        dist=new int[N][M];
        a=new int[N][M];
        for(int i=0 ;  i <N ; i++){
            for(int j=0 ; j<M ; j++){
                a[i][j]=scan.nextInt();     // (M,N)에 토마토 있는지 없는지,
            }
        }


    }

    static void bfs() {
        /* TODO */
        Queue<Integer> que= new LinkedList<>();
        //처음 익은 토마토들 que에 넣기
        for(int i=0 ; i<N ; i++){
            for(int j=0; j<M ; j++){
                if(a[i][j]==1){
                    que.add(i);
                    que.add(j);
                    dist[i][j]=0;
                }
            }
        }


        //x가 가로라능 상상을 버려.   x는 세로다.
        while (!que.isEmpty()){
            int x=que.poll();
            int y=que.poll();
            for(int[] direction : dir){
                int nx= x+direction[0];
                int ny=y+direction[1];

                if(nx <0  || ny<0 || nx>=N  || ny>=M) continue;
                if(a[nx][ny]!=0) continue;

                a[nx][ny]=1;
                que.add(nx);
                que.add(ny);
                dist[nx][ny]=dist[x][y]+1;
            }
        }
    }

    static void pro() {
        /* TODO */
        //초기화
        for(int i=0 ;  i < N ; i++){
            for(int j=0 ; j<M ; j++){
                dist[i][j]=-1;
            }
        }
        bfs();
        //모두 익으면 최소날짜,처음부터 익었으면 0,  모두 익을수없으면 -1
        // 비어있지않은칸에 -1,    빈칸제외하고 다 익었을떄 최대값,     처음부터 익었을때 0
        //0이 있으면 다 안익은거=> 이때는 -1 출력,  처음부터 익었으면 애초에 최대값 0

        //x는 가로가 아니다.  프로그래밍에서는 이차원배열할때 첫번째가 세로, 두번째가 가로다.
        int max=Integer.MIN_VALUE;
        boolean isThereZero=false;
        for(int i=0; i<N ; i++){
            for(int j=0; j<M ; j++){
                if(a[i][j]==0) isThereZero=true;
                max=Math.max(dist[i][j],max);
            }
        }

        if(isThereZero) System.out.println(-1);
        else System.out.println(max);




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
