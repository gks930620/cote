import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class BOJ3055탈출 {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N, M;
    static String[] a;
    static int[][] dist_water, dist_hedgehog;
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
        dist_water = new int[N][M];
        dist_hedgehog = new int[N][M];
    }

    // 모든 물들을 시작으로 동시에 BFS 시작!
    static void bfs_water() {
        Queue<Integer> que = new LinkedList<>();
        // 모든 물의 위치를 Q에 전부 넣어주기!
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                // dist_water 와 visit 배열 초기화
                /* TODO */
                visit[i][j]=false;
                dist_water[i][j]=-1;  //처음엔 다 못가는걸로
                if (a[i].charAt(j) == '*') {
                    /* TODO */
                    dist_water[i][j]=0;   //가면 0부터 시작
                    visit[i][j]=true;
                    que.add(i);
                    que.add(j);
                }
            }
        }

        // BFS 과정 시작
        /* TODO */
        while(!que.isEmpty()){
            int x=que.poll();
            int y=que.poll();

            for(int[] direction : dir){
                int nx=x+direction[0];
                int ny=y+direction[1];

                if(nx<0 || ny<0 || nx>=N || ny>=M) continue;
                if(a[nx].charAt(ny)!='.') continue;
                if(visit[nx][ny]) continue;
                visit[nx][ny]=true;
                que.add(nx);
                que.add(ny);
                dist_water[nx][ny]=dist_water[x][y]+1;

            }

        }
    }

    // 고슴도치를 시작으로 동시에 BFS 시작!
    static void bfs_hedgehog() {
        Queue<Integer> que = new LinkedList<>();
        // 고슴도치 위치를 Q에 넣어주기!
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                // dist_hedgehog 와 visit 배열 초기화
                /* TODO */
                dist_hedgehog[i][j]=-1;
                visit[i][j]=false;
                if (a[i].charAt(j) == 'S') {
                    /* TODO */
                    dist_hedgehog[i][j]=0;
                    visit[i][j]=true;
                    que.add(i);
                    que.add(j);
                }
            }
        }

        // BFS 과정 시작
        /* TODO */


        while (!que.isEmpty()){
            int x=que.poll();
            int y=que.poll();
            for(int[] direction : dir){
                int nx=x+direction[0];
                int ny=y+direction[1];
                if(nx<0 || ny<0 || nx>=N || ny>=M) continue;
                if(a[nx].charAt(ny)!='.' && a[nx].charAt(ny)!='D') continue;
                if( dist_water[nx][ny] !=-1 &&  dist_water[nx][ny] <= dist_hedgehog[x][y]+1) continue;;
                if(visit[nx][ny]) continue;



                visit[nx][ny]=true;
                dist_hedgehog[nx][ny]=dist_hedgehog[x][y]+1;
                que.add(nx);
                que.add(ny);
            }
        }
    }

    static void pro() {
        // 각 칸마다 물에 닿는 시간 계산하기
        bfs_water();

        // 고슴도치가 물을 피해 탐색할 수 있는 공간 찾기
        bfs_hedgehog();

        // 탈출구 'D' 에 대한 결과를 통해 정답 출력하기
        for (int i=0;i<N;i++){
            for (int j=0;j<M;j++){
                if (a[i].charAt(j) == 'D'){
                    /* TODO */
                    if(dist_hedgehog[i][j]==-1){
                        System.out.println("KAKTUS");
                    }else{
                        System.out.println(dist_hedgehog[i][j]);
                    }
                }
            }
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