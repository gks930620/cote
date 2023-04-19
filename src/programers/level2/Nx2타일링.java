package programers.level2;

public class Nx2타일링 {
    int[] fn=new int[60001];
    final int  mod=1000000007;
    public int solution(int n) {
        fn[1]=1;
        fn[2]=2;
        for(int i=3; i<=n ; i++){
            fn[i]=(fn[i-1]+fn[i-2])%mod;
        }

        return fn[n];
    }

}
