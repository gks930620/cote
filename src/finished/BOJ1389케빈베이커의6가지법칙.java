package finished;

import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class BOJ1389케빈베이커의6가지법칙 {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N, M;
    static ArrayList<Integer>[] adj;
    static int[] dist;  //bfs에서 단계를 구할 때는 배열에 저장하면 된다.
    static  boolean[] visit;
    static void input() {
        /* TODO */
        N=scan.nextInt() ; //유저수
        M=scan.nextInt() ;// 관계 정의 수
        adj=new ArrayList[N+1];
        dist=new int[N+1];   // 시작점을 바꿀 때마다 초기화 해줘야한다...
        visit=new boolean[N+1];
        for(int i=1 ; i<=N ; i++){
            adj[i]=new ArrayList<>();
        }

        for(int i=1 ; i<=M ; i++){
            int x=scan.nextInt();
            int y=scan.nextInt();
            adj[x].add(y);
            adj[y].add(x);

        }


    }

    // start 라는 정점의 케빈 베이컨의 수를 계산해주는 함수
    static int bfs(int start) {
        Queue<Integer> que= new LinkedList<>();
        que.add(start);
        visit[start]=true;   //방문은 빼냈을 때지만,  빼냈을 때 visit true하면 여러번 반복함..  실제로 넣는 순간 어차피 반복할 예정이니 visit true 해주는게 맞음

        while (!que.isEmpty()){
            int x= que.poll();
            for(int y :  adj[x]){
                if(visit[y]) continue;
                visit[y]=true;
                que.add(y);
                dist[y]=dist[x]+1;   //최단 거리와 다르게 max함수 안 써도 됨 어차피 한번만 가는거니까   1-4  1-3-2-4 같은 경우는 없다. 둘 중에 하나만 주어진다.
            }
        }
        int sum=0;
        for(int i=1 ; i<=N ; i++){
            sum+=dist[i];
        }
        return sum;
    }
    static void firstState(){
        for(int i=1 ; i<=N ; i++){
            visit[i]=false;
            dist[i]=0;
        }
    }

    static void pro() {
        int minCavinIndex=1;   //번호
        int minCavinState= bfs(1);  //케빈베이컨 법칙의 총합
        for(int i=2 ; i<=N ; i++){
            firstState();
            int currentCanvinState= bfs(i);
            if( minCavinState> currentCanvinState ){   //값이 같을 때 숫자 적은 넘 쓴다는건   = 안붙이면 해결
                minCavinState=currentCanvinState;
                minCavinIndex= i;
            }
        }
        System.out.println(minCavinIndex);
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