import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class Main {
    //문제 이해가 어려웠다.
   /*       4 2
            2 1 2
            4 3 2
            1 4 3
            1 2
            3 2


            첫째줄의 4(N)는    2 1 2     4, 3, 2       1,4,3  와 같이 3(N-1)개의  개수를 의미한다.    각각은  2->1번으로 가는 거리.

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
    // 잘못된 길로 간다면, 끝까지 탐색하고 for문에서 끝나고 되돌아옴.
    static void DFS(int x,int prev, int goal, int dist){
        /* TODO */
        if(x== goal) { //목표도착
            ans=dist;
            return;
        }
        //x에서 갈 수 있는 모든 곳 찾기
        for( Edge edge   : con[x]){
            if (edge.y == prev) continue;
            DFS(edge.y, x, goal , dist+edge.c );  //트리니까 무조건 도착함. 길은 하나임.
        }
    }
    static void pro() {
        /* TODO */
        int x = scan.nextInt(), y = scan.nextInt();
        DFS(x, -1, y, 0);   //x에서 y까지의 거리를 구하는 함수.
        System.out.println(ans);


    }

    public static void main(String[] args) throws IOException {
        input();
        while (m-- > 0) {
            pro();
        }
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