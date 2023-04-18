package programers.스택큐;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class 같은숫자는싫어 {

    public int[] solution(int []arr) {
        Stack<Integer> stack=new Stack<>();
        Queue<Integer> que=new LinkedList<>();
        stack.add(arr[0]);
        que.add(arr[0]);
        for(int i=1 ; i<arr.length ; i++){
            if(arr[i]!= stack.peek()){
                stack.add(arr[i]);
                que.add(arr[i]);
            }
        }
        int[] answer=new int[que.size()];
        for(int i=0; i<answer.length ; i++){
            answer[i]=que.poll();
        }

        return answer;
    }

    public int[] solution2(int []arr) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i = 1; i < arr.length; i++) {
            if(arr[i]!=arr[i-1]) {
                list.add(arr[i-1]);
            }
        }
        if(list.size()==0 || arr[arr.length-1] != list.get(list.size()-1)) {
            list.add(arr[arr.length-1]);
        }


        int[] answer=new int[list.size()];
        for(int i=0; i<answer.length ; i++) {
            answer[i]=list.get(i);
        }

        return answer;
    }

}
