import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N, M;
    static int[] indeg;
    static ArrayList<Integer>[] adj;

    static void input() {
        N = scan.nextInt();
        M = scan.nextInt();
        adj = new ArrayList[N + 1];  //목적지 수
        indeg = new int[N + 1];  //  들어오는 간선의 수
        for (int i = 1; i <= N; i++)
            adj[i] = new ArrayList<>();
        /*
         * A1, A2, ... Acnt 순서로 나가야 한다면,
         * A1 -> A2
         * A2 -> A3
         *  ...
         * A(cnt-1) -> Acnt
         * 의 간선을 만들어주면 된다.
         */
        for(int i=1 ; i<=M ; i++){
            int singerCount=scan.nextInt();
            int preSinger=scan.nextInt();
            int curSinger;
            for(int j=2 ; j<=singerCount ; j++){
                curSinger=scan.nextInt();
                adj[preSinger].add(curSinger);   //이전 가수에서 현재 y로  간선 생김
                indeg[curSinger]++;               //y로 들어오는 간선 +1
                preSinger=curSinger;           //이전 가수는 현재가수
            }
        }
    }

    static void pro() {
        // 우선순위에 대한 조건을 간선으로 표현했으므로 위상정렬을 수행하면 된다.
        /* TODO */
        //위상정렬 해서 한가지 경우 출력

        //시작점 후보들 QUE에 넣기
        //QUE에서 값 뺀다음 그 지점에서 갈 수 있는 모든 점에 대해
        // INDEG -- 하나씩 줄임.   INDEG가 0이면 QUE에 넣기.   (그림그렸다면 쉽다)
        Queue<Integer> que= new LinkedList<>();
        for(int i=1 ; i<=N ; i++){
            if(indeg[i]==0) que.add(i);
        }

        while (!que.isEmpty()){
            int x=que.poll();
            sb.append(x).append("\n");
            for(int y : adj[x]){
                indeg[y]--;
                if(indeg[y]==0) que.add(y);
            }

        }

        if(sb.length()<N){
            System.out.println(0);
        }else{

        System.out.println(sb);
        }
        //만약 남일이가 순서를 정하는 것이 불가능할 경우에는 첫째 줄에 0을 출력한다.

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