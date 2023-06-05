package programers.level3;

import java.util.Arrays;

public class 숫자게임 {
    public static void main(String[] args) {
        int[] a= {5,1,3,7};
        int[] b={2,2,6,8,};
        int[] A={2,2,2,2};
        int[] B={1,1,1,1};
        int solution = new 숫자게임().solution(A,B);
        System.out.println(solution);
    }

    public int solution(int[] A, int[] B) {
        Arrays.sort(A);
        Arrays.sort(B);
        int ans=0;
        int plusIndex=0;
        for(int i=0 ; i+plusIndex<A.length ; i++){
            while (i+plusIndex < A.length &&  B[i+plusIndex] <= A[i]){
                    plusIndex++;
            }
            
            if(i+plusIndex == A.length){  //한개도 없는 경우
                break;
            }

            ans++;
        }

        return ans;
    }
}
