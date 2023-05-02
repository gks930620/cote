package programers.level2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 연속된부분수열의합 { // 백준 두포인터 문제 풀어보고 해보자.
    public static void main(String[] args) {
        int[] sequence={1,1,1,2,3,4,5};

        int[] solution = new 연속된부분수열의합().solution(sequence, 5);
        System.out.println(Arrays.toString(solution));
    }


    public int[] solution(int[] sequence, int k) {
        int N = sequence.length;
        int left = 0, right = N;
        int sum = 0;
        for(int L = 0, R = 0; L < N; L++) {
            while(R < N && sum < k) {
                sum += sequence[R++];
            }

            if(sum == k) {
                int range = R - L - 1;  //새로찾은 거
                if((right - left) > range) {  //범위 비교해서 더 짧은 걸로 교체
                    left = L;
                    right = R - 1;
                }
            }


            sum -= sequence[L];
        }

        int[] answer = {left, right};

        return answer;
    }
}
