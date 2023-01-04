import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N, root, erased;
    static ArrayList<Integer>[] child;
    static int[] leaf;

    static void input() {
        N = scan.nextInt();
        /* TODO  트리 인정리스트 구성하기   0번부터니까  0~N-1로 한다.*/
        leaf=new int[N];
        child=new ArrayList[N];
        for(int i=0 ; i<N ; i++) child[i]=new ArrayList<>();
        for(int i=0; i<N ; i++){
            int par=scan.nextInt();
            if(par ==-1){
                root=i;
                continue;
            }
            child[par].add(i);           //양쪽으로 안하고 한쪽만해도되나?   부모에서 자식으로만 간선 저장
        }
        erased=scan.nextInt();
    }

    // dfs(x, par) := 정점 x 의 부모가 par 였고, Subtree(x) 의 leaf 개수를 세주는 함수
    static void dfs(int x) {
        /* TODO */
        if(child[x].isEmpty()){
            leaf[x]=1;  //내가 바로 leaf node
        }else{
            for(int y : child[x]){
                dfs(y);
                leaf[x]+=leaf[y];
            }
        }

    }

    static void pro() {
        // erased와 그의 부모 사이의 연결을 끊어주기
        /* TODO */
        for(int i=0; i<N ; i++){
            if(child[i].contains(erased)){
                child[i].remove(child[i].indexOf(erased));  //그 아래 자식들 다 안끊어도 됨. dfs할 때 어차피 안감
            }
        }
        if(root !=erased) dfs(root);
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