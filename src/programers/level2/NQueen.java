package programers.level2;

public class NQueen {

    static int[] col;
    static int ans;
    public static int solution(int n) {
        col=new int[n];      // col[0]=3   0행에는 3열이 놓여져있음.
        rec_func(0,n);
        return ans;
    }

    public static void rec_func(int row, int n){
        if(row==n){
            ans++;
        }else{
            for(int i=0; i<n ; i++){   // 0부터 n-1열까지 확인해봐야지,  난 row행에 퀸을 놓으려고 하고 있음
                boolean possible=true;

                for(int j=0; j<row ; j++){   //0행부터 row-1행까지는 퀸이 놓여있음. 그것들 전부 비교
                        if(attackable(row,i , j,col[j] )){
                            possible=false;
                            break;
                        }
                }
                
                if(possible){  //공격이 가능하다면  row행에 퀸을 넣고 다음행 확인
                    col[row]=i;
                    rec_func(row+1,n);
                    col[row]=0;
                }

            }
        }

    }

    private static boolean attackable(int r1, int c1, int r2, int c2) {
        if(r1==r2) return  true;  //같은 행   r1==r2가 같은경우를 호출하지는 않지만..  메소드 이름에 대해서는 필요한 조건임.
        if (c1 == c2) return true; //같은 열
        if (r1 - c1 == r2 - c2) return true; //  올라가는 대각선
        if (r1 + c1 == r2 + c2) return true;  //내려오는 대각선

        return  false;
    }


}
