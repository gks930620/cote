import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class BOJ1240노드사이의거리 {
    //문제 이해가 어려웠다.
   /*       4 2
            2 1 2
            4 3 2
            1 4 3
            1 2
            3 2
            첫째줄의 4(N)는    2 1 2     4, 3, 2       1,4,3  와 같이 3(N-1)개의  개수를 의미한다.    각각은  2->1번으로 가는 거리 2.   4->3으로 가는 거리 2
            첫째줄의   2(M)은     1,2    3,2처럼     1 ->2,   3->2 가는 거리가 몇 인지 출력해달라는 개수를 의미한다.

    */
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static class Edge {
        int y, c;
        Edge(int y,int c){
            this.y = y;
            this.c = c;
        }
    }
    static int n, m;
    static ArrayList<Edge>[] con;

    static void input() throws IOException {
        n = scan.nextInt();
        m = scan.nextInt();
        con = new ArrayList[n + 1];
        for (int i=1;i<=n;i++) con[i]=new ArrayList<>();
        for (int i=1;i<n;i++){
            int x=scan.nextInt(), y=scan.nextInt(), c=scan.nextInt();
            con[x].add(new Edge(y, c));
            con[y].add(new Edge(x, c));
        }
    }

    static int ans;
    // 현재 x 에 있으며, 부모 노드는 prev 이며, 목표 지점은 goal,
    // 그리고 root부터 지금까지 이동 거리가 dist 이다.
    static void dfs(int x,int prev, int goal, int dist){
        /* TODO */
        if(x==goal){
            ans=dist;
            return;
        }
        for(Edge edge : con[x]){   //x에서 갈 수 있는 모든 점 조사  ( edge에는 x에서 갈 수 있는 모든 점+ cost가 들어있음
            if(edge.y != prev ){  //간적이 없으면,   되돌아갈필요는 없다
                dfs( edge.y, x , goal, dist+edge.c   );
            }
        }
    }
    static void pro() {
        /* TODO */
        for(int i=1 ; i<=m ; i++){
            int start=scan.nextInt();
            int goal=scan.nextInt();
            dfs(start,-1,goal,0);
            System.out.println(ans);
        }


    }

    public static void main(String[] args) throws IOException {
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