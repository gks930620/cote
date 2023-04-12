package programers;

import java.util.*;

public class 뒤에있는큰수 {
    
    public static int[] solution(int[] numbers) {
        int[] answer= new int[numbers.length];
        Stack<Integer> stack= new Stack<>();  // index가 담김
        stack.push(0);  //첨엔 index 0 넣고 시작
        for(int i=1 ; i<numbers.length ; i++){

            while (!stack.isEmpty() &&  numbers[stack.peek()] < numbers[i] ){
                int 뒤큰수=numbers[i];
                int index = stack.pop();
                answer[index]=뒤큰수;
            }

            stack.push(i);     //마지막엔 현재 index 넣기
        }

        while (!stack.isEmpty()){
            answer[stack.pop()]=-1;
        }


        return answer;
    }
}
