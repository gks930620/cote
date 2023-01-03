import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class BOJ7569토마토3차원 {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N, M, H;
    static int[][][] dist, a;
    static int[][] dir = { {1,0,0,},{-1,0,0},{0,1,0},{0,-1,0},{0,0,1}, {0,0,-1} };

    static void input() {
        M = scan.nextInt(); //가로
        N = scan.nextInt(); //세로
        H = scan.nextInt();   // 높이    ( x,y,z)는   가로 세로 높이.   for( k 높이 먼저,    세로    가로 순)
        /* TODO */
        a= new int[H][N][M];
        dist=new int[H][N][M];
        for(int i=0 ; i<H ; i++){
            for(int j=0 ; j<N ; j++){
                for(int k=0; k<M ; k++){
                    a[i][j][k]=scan.nextInt();
                }
            }
        }

    }

    static void bfs() {
        /* TODO */
        Queue<Integer> que=new LinkedList<>();
        for(int i=0 ; i<H ; i++){
            for(int j=0 ; j<N ; j++){
                for(int k=0; k<M ; k++){
                    if(a[i][j][k] == 1){
                        que.add(i);
                        que.add(j);
                        que.add(k);   //  높이, 세로, 가로순으로 넣음
                        dist[i][j][k]=0;
                    }
                }
            }
        }

        while (!que.isEmpty()){
            int x=que.poll();    //높이
            int y=que.poll();   //세로
            int z=que.poll();    //가로   수학버려.. 이차함수 버려

            for(int[] direction : dir){
                int nx=x+direction[0];
                int ny=y+direction[1];
                int nz=z+direction[2];

                if( nx<0 ||ny <0 ||nz <0 ||   nx>=H || ny>=N || nz>=M) continue;
                if(a[nx][ny][nz]!=0 ) continue;

                a[nx][ny][nz]=1;
                que.add(nx);
                que.add(ny);
                que.add(nz);
                dist[nx][ny][nz]=dist[x][y][z]+1;
            }
        }

    }

    static void pro() {
        /* TODO */
        for(int i=0 ; i<H ; i++){
            for(int j=0 ; j<N ; j++){
                for(int k=0; k<M ; k++){
                    dist[i][j][k]=-1;
                }
            }
        }
        bfs();


        int max=Integer.MIN_VALUE;
        boolean isThereZero=false;
        for(int i=0 ; i<H ; i++){
            for(int j=0 ; j<N ; j++){
                for(int k=0; k<M ; k++){
                    if(a[i][j][k]==0) isThereZero=true;
                    max=Math.max(dist[i][j][k],max);
                }
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
