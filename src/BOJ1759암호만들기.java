import java.io.*;
import java.util.*;

public class BOJ1759암호만들기 {
    static StringBuilder sb = new StringBuilder();

    static void input() {
        FastReader scan = new FastReader();
        M = scan.nextInt();
        N = scan.nextInt();
        chars = new char[N + 1];
        selected = new int[M + 1];
        String[] tokens = scan.nextLine().split(" ");
        for (int i = 1; i <= N; i++) {
            chars[i] = tokens[i - 1].charAt(0);
        }
    }

    static int N, M;
    static char[] chars;
    static int[] selected; 


    //모음이냐?
    static boolean isVowel(char x) {
        return x == 'a' || x == 'e' || x == 'i' || x == 'o' || x == 'u';
    }

    //for는 1~6 문자 6개중   k는 1~ 4 4개선택
    static void rec_func(int k) {
        if (k == M + 1) { // 1 ~ M 번째를 전부 다 골랐다
            int vowel = 0, consonant = 0;
            for (int i = 1; i <= M; i++) {
                //chars[selected[i]]
                if(isVowel(chars[selected[i]])){
                    vowel++; //모음
                }else {
                    consonant++; //자음
                }
            }
            if(vowel >=1 && consonant>=2){
                for(int i=1 ; i<=M ; i++){
                    sb.append(chars[selected[i]]);
                }
                sb.append("\n");
            }

        } else {
            for (int i = selected[k - 1] + 1; i <= N; i++) {  
                // 정렬한 상태에서  a선택했으면 a이후것만 선택하게..    오름차순 할 땐 selected 한다.  전에 선택된거 +1부터 ㅎㅎ
                selected[k] = i;  //이번에 선택된거
                rec_func(k + 1);
                selected[k] = 0;
            }
        }
    }

    public static void main(String[] args) {
        input();
        Arrays.sort(chars, 1, N + 1);   //일단 정렬
        rec_func(1);
        System.out.println(sb.toString());
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