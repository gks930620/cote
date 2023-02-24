package finished;

import java.io.*;
import java.util.*;

public class BOJ11725트리의부모찾기DFS {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N;
    static ArrayList<Integer>[] adj;
    static int[] parent;

    static void input() {
        N = scan.nextInt();
        // 인접 리스트 구성하기
        /* TODO */
        adj=new ArrayList[N+1];
        parent=new int[N+1];
        for(int i=1; i<=N ; i++){
            adj[i]=new ArrayList<>();
        }
        for(int i=1; i<=N-1 ; i++){  //단순한 횟수. 의미없음
            int start=scan.nextInt();
            int destination=scan.nextInt();
            adj[start].add(destination);
            adj[destination].add(start);
        }

    }

    // dfs(x, par) := 정점 x 의 부모가 par 였고, x의 children들을 찾아주는 함수
    static void dfs(int x, int par) {
        /* TODO */
        for(int y : adj[x]){
            if (y == par) continue;   // 내가 갈 수 있는 점들중에서 부모로 가는경우는 제외해야지
            parent[y]=x;  //간선은 n-1임.   한번만 값 세팅 될 확률 58000%
            dfs(y,x);
        }


    }

    static void pro() {
        // 1 번 정점이 ROOT 이므로, 여기서 시작해서 Tree의 구조를 파악하자.
        /* TODO */
        dfs(1,-1);

        // 정답 출력하기
        /* TODO */
        for(int i=2 ; i <=N ; i++){
            System.out.println(parent[i]);
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