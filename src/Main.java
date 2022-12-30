import java.io.*;
import java.lang.reflect.Array;
import java.util.*;


//다시해보자.   14502 연구소 뻑킹
public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N, M, B, ans;
    static int[][] A,blank;
    static int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    static boolean visit[][];

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
        // 모든 바이러스 (2인거)가 시작점으로 가능하니까, 전부 큐에 넣어준다.
        /* TODO */
        for(int i=1; i<=N ; i++){
            for(int j=1 ; j<=M ; j++){
                if(A[i][j]==2){
                    State state = new State(i, j);
                    que.add(state);
                    visit[i][j] = true;
                }
            }
        }
        // BFS 과정
        /* TODO */
        while(!que.isEmpty()){
            //방문함
            State state=que.poll();
            int x=state.x;
            int y=state.y;
            for(int[] dirction :dir ){
                int nx= x+dirction[0];
                int ny=y+dirction[1];
                //직사각형 범위
                if( nx<1 || nx>N||ny<1 || ny>M)continue;
                //벽(1)에 의해 막혔는지.. + 이미 바이러스(기존 바이러스)인 경우
                if(A[nx][ny]!=0) continue;
                //방문했던 적 있는지..
                if(visit[nx][ny]) continue;
                //문제없으면 나중에 방문해야되니까 que에 넣는다.
                visit[nx][ny]=true;
                State newState=new State(nx,ny);
                que.add(newState);
                System.out.println( "("+nx+","+ny+")");
            }
        }

        // 탐색이 종료된 시점이니, 안전 영역의 넓이를 계산하고, 정답을 갱신한다.
        /* TODO */
        int cnt = 0;
        for (int i = 1; i <= N; i++) for (int j = 1; j <= M; j++) if (A[i][j] == 0 && !visit[i][j]) cnt++;   // 원래 값이 0이고  누군가 방문안했으면(바이러스가 새로 안 퍼졌으면)
        ans = Math.max(ans, cnt);


    }

    // idx 번째 빈 칸에 벽을 세울 지 말 지 결정해야 하고, 이 전까지 selected_cnt 개의 벽을 세웠다.
    static void dfs(int idx,int depth) {
        if(depth==3 ){
            bfs();
            //탐색끝=> 다시 visit 초기화
            for(int i=1 ; i<=N ; i++){
                for(int j=1 ; j<=M ; j++){
                    if(visit[i][j]) System.out.println( i+","+j);
                    visit[i][j]=false;
                }
            }
            System.out.println("---------------------");
            return;
        }
        if (idx > B) return;  // 벽이 엄청많아 3개 더 못세우는경우..

        for(int i=idx; i<=B ;i++){  // 벽세우는건 완벽한거 확인 ^^
            int x=blank[i][0];
            int y=blank[i][1];
            A[x][y]=1;
            dfs(i+1,depth+1);
            A[x][y]=0;
        }
    }

    static void pro() {
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                if (A[i][j] == 0) {
                    B++;
                    blank[B][0] = i;  //x  행
                    blank[B][1] = j;  //y   열
                }
            }
        }

        dfs(1,0);  //벽을 세우는 방법   depth는 3이겠지
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