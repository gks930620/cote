package boj;

import java.io.*;
import java.util.*;


//다시해보자.   14502 연구소 뻑킹
//B가 오름차순, 중복x 할려면?     BOJ15650참고.   전에거보다 높은데서 for문 돌려야지.   이게 어려웠다.
//bfs는 쉽네..
public class BOJ14502연구소 {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N, M, B, ans;
    static int[][] A,blank;
    static int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    static boolean visit[][];
    static ArrayList<State> beginningVirus=new ArrayList<>();

    static void input() {
        N = scan.nextInt();
        M = scan.nextInt();
        visit=new boolean[N+1][M+1];
        A = new int[N + 1][M + 1];
        blank=new int[N * M + 1][2];
        for (int i = 1; i <= N; i++)
            for (int j = 1; j <= M; j++)
                A[i][j] = scan.nextInt();
    }

    static class State{
        int x; int y;
        public State(int x, int y){
            this.x=x;
            this.y=y;
        }
    }


    // 바이러스 퍼뜨리기!!
    static void bfs() {
        Queue<State> que = new LinkedList<>();
        for(int i=1; i<=N ; i++){
            for(int j=1 ; j<=M ; j++){
                visit[i][j]=false; //초기화
                if (A[i][j] == 2) {
                    visit[i][j] = true;
                    que.add(new State(i,j));
                }
            }
        }

        while (!que.isEmpty()){
            //  que에 넣을 때 true를 해줘야 함.  실제 방문한 건 뺄때처럼보이지만,     여러곳에서 넣을 때 같은 곳을 중첩되서 넣을 수도 있음.. 그러니까 넣을 떄 true해줘야함
            State state = que.poll();
            int x=state.x;
            int y=state.y;
            for(int[] direction : dir){   // 현재 점 (x,y)에서 갈 수 있는 곳 조사
                int nx=x+direction[0];
                int ny=y+direction[1];
                if(nx<1 || ny<1 || nx>N || ny>M) continue;
                if(A[nx][ny]!=0) continue;     //!=0 으로 해도되는데     2인경우에는 어차피 visit[][]에서 걸림.
                if(visit[nx][ny]) continue;
                que.add(  new State(nx,ny));
                visit[nx][ny]=true;
            }
        }


        //조사 다 했으면 현재 visit[][]에는 원래 2있던곳과 bfs로 탐색한 곳들이 true로 되어있음.  false인 곳들이  0인것들
        int cnt=0;
        for(int i=1 ; i<=N ; i++){
            for(int j=1; j<=M ; j++){
                if(A[i][j]==0&&visit[i][j]==false) cnt++;   //0인거 조사안하면 벽 개수까지 true로 함.
            }
        }
        ans=Math.max(ans,cnt);
    }

    // idx 번째 빈 칸에 벽을 세울 지 말 지 결정해야 하고, 이 전까지 depth 개의 벽을 세웠다.
    static void dfs(int idx,int depth) {
        if(depth==3){  //벽은 최대 3개까지만 세울수 있다. 벽 3개 세웠으면
            //벽 3개 세웠으면 바이러스 확장 얼마나 되는지 확인
            bfs();
            return ;
        }

        if(idx >B) return ;    // 1이 너무많아서 벽 3개 세우기 전에 더이상 세울데가 없는 경우.

        for(int i=idx ; i<=B ; i++){ //벽 후보만큼 탐색한다. 중복 안되게 했으니까 굳이 조건 필요없음
            int x=blank[i][0];int y=blank[i][1];
            A[x][y]=1;  //i번째 벽후보(0)인 곳을 벽 세움
            dfs(i+1,depth+1);
            A[x][y]=0;
        }


    }

    static void pro() {
        //벽이 얼마나있는지  dfs를 위한 B라는 숫자활용  + 초기 바이러스들 찾기
        for(int i=1; i<=N ; i++){
            for(int j=1 ; j<=M ; j++){
                if(A[i][j]==0){
                    B++;
                    blank[B][0]=i;
                    blank[B][1]=j;    //  B번째 벽 후보의 좌표( 0인것들의 좌표) 를 blank[B]에다 저장
                }
            }
        }
        dfs(1,0);


        System.out.println(ans);
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