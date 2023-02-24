package finished;

import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class BOJ1068트리 {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N, root, erased;
    static ArrayList<Integer>[] child;
    static int[] leaf;

    static void input() {
        N = scan.nextInt();   //부모가 주어지기때문에 부모에서 자식으로 가는것만 설정하면 된다.
        /* TODO */
        child=new ArrayList[N];
        for(int i=0; i<N ; i++){
            child[i]=new ArrayList<>();
        }
        for(int i=0; i<N ; i++){
            int x=scan.nextInt();   //i번째의 부모
            if(x==-1) {
                root=i;
            }else{
                child[x].add(i);
            }
        }
        erased=scan.nextInt();
        leaf=new int[N];

    }

    // dfs(x, par) := 정점 x 의 부모가 par 였고, Subtree(x) 의 leaf 개수를 세주는 함수
    static void dfs(int x, int par) {
        /* TODO */
        //만약 내가 마지막 자식이면
        if(child[x].isEmpty()){
            leaf[x]=1;
        }
        for(int y : child[x]){ //자식들 전부 조사.
            dfs(y,x);
            leaf[x]+=leaf[y];
        }

    }

    static void pro() {
        // erased와 그의 부모 사이의 연결을 끊어주기
        /* TODO */
        for(int i=0; i<N ; i++ ){
            //erased가 있으면 해당 부모의 list에서 제거.
            if(child[i].contains(erased)){
                child[i].remove(  child[i].indexOf(erased) );
            }
        }
        // erased 가 root 인 예외 처리하기
        /* TODO */
        if (root != erased) dfs(root, -1);  //root가 erased일때는 할 필요없지.  그럼 그냥 0나오게 출력
        // 정답 출력하기
        /* TODO */
        System.out.println(leaf[root]);
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