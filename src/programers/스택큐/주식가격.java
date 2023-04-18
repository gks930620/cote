package programers.스택큐;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class 주식가격 {
    class Data{
        public Data(int index, int value){
            this.index=index;
            this.value=value;
        }
        int index;
        int value;
    }
    public int[] solution(int[] prices) {
        int[] answer=new int[prices.length];
        Stack<Data> stack=new Stack<>();  //가격을 넣을 거야

        for(int i=0 ; i<prices.length ; i++){
           if(stack.isEmpty()) {
               stack.push(new Data(i, prices[i]));
           }else{
               Data data=stack.peek();
                if(data.value  > prices[i]){   //가격이 내려갔다면
                    int time= 1;
                    while (!stack.isEmpty()){  //stack 전부 제거
                        Data pop = stack.pop();
                        answer[pop.index]=time++;

                    }


                }else{  //내려가지않았다면
                    stack.push(new Data(i,prices[i]));
                }
           }
        }

        return  answer;
    }


    public int[] solution2(int[] prices) {
        int[] answer=new int[prices.length];
        for(int i=0;i<prices.length;i++) {
            answer[i]=prices.length-i-1;
            for(int j=i+1;j<prices.length;j++) {
                if(prices[i]>prices[j]) {
                    answer[i]=j-i;
                    break;
                }
            }
        }
        return answer;
    }
}
