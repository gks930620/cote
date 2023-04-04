package boj;

import java.io.*;
import java.util.*;


public class BOJ2251물통 {
    // 물통의 현재 상태와 물을 붓는 행위를 관리하는 구조체
    static class State{
        int[] X;
        State(int[] _X){
            X = new int[3];
            for (int i=0;i<3;i++) X[i] = _X[i];
        }
        State move(int from,int to,int[] Limit){
            // from 물통에서 to 물통으로 물을 옮긴다.
            int[] nX = new int[]{X[0], X[1], X[2]};
            /* TODO */
            //nX일단은 현재상태 그대로 배껴옴..  근데 이제 옮겨야지..
            if( nX[from]+nX[to]  <= Limit[to] ){  //그대로 옮길 수 있는 경우
                nX[to]+=nX[from];
                nX[from]=0;
            }else{ // 옮기다 마는 경우
                int chai= Limit[to]-nX[to];
                nX[to]=Limit[to];
                nX[from]-=chai;
            }
            return new State(nX);
        }
    }

    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();
    static int[] Limit;
    static boolean[][][] visit;
    static HashSet<Integer> set=new HashSet<>();

    static void input() {
        Limit = new int[3];
        for (int i=0;i<3;i++) Limit[i] = scan.nextInt();
        visit = new boolean[205][205][205];

    }

    // 물통 탐색 시작~
    static void bfs(int x1, int x2, int x3) {
        Queue<State> que = new LinkedList<>();

        // BFS 과정 시작
        /* TODO */
        //start를 que 에 넣는다.     while( q안비어있는동안)  큐에서 꺼낸다. 방문표시  for(꺼낸 점에서 갈 수 있는 모든거 확인){ 방문여부 확인. 갈 수있으면 que에 넣는다.visit=true  못 가면 continue
        int[] startX = {x1, x2, x3};
        State start= new State(startX);
        que.add(start);
        visit[startX[0]][ startX[1]][startX[2]]=true;

        while (!que.isEmpty()){
            State x = que.poll();
            int[] X = x.X;
            if(X[0]==0) {
                set.add(X[2]);
            }
            for(int from=0; from<3; from++){
                for(int to=0; to<3 ; to++){
                    if(from==to) continue;;
                    State nx= x.move(from,to,Limit);
                    int[] nX = nx.X;
                    if( visit[nX[0]][nX[1]][nX[2]] ==true ) continue;
                    que.add(nx);
                    visit[nX[0]][nX[1]][nX[2]] =true;
                }
            }
        }


    }

    static void pro() {
        bfs(0, 0, Limit[2]);
        // 정답 계산하기
        /* TODO */
        ArrayList<Integer> list= new ArrayList<>();
        list.addAll(set);
        Collections.sort(list);

        for(int a : list){
            sb.append(a).append(" ");
        }
        System.out.println(sb);
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