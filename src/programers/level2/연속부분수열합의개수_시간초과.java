package programers.level2;

import java.util.*;

public class 연속부분수열합의개수_시간초과 {
    public static void main(String[] args) {
        int[] elements={7,9,1,1,4};
        System.out.println(solution(elements));

    }

    static List<Integer> list=new ArrayList<>();
    static int count;
    public static int solution(int[] elements) {
        doSpin(elements);
        for(int i=0 ; i<elements.length ; i++){
            rec_func(elements,0,0,true);
            doSpin(elements);
        }
        return list.size()-1;  //아무것도 선택안했을 때 0도 포함되는데 이건 부분수열이 아니니까 제거
    }

    public static void rec_func(int[] elements,int depth,int sum,boolean preSelected){
        if(depth==elements.length){
            if(!list.contains(sum)){
                list.add(sum);
            }
            return;
        }

        //연속이도록..
        if(preSelected==false){
            rec_func(elements,depth+1,sum,false);
        }else{
            rec_func(elements,depth+1,sum,false);
            rec_func(elements,depth+1,sum+elements[depth],true);
        }
    }

    //회전
    public static void doSpin(int[] elements){
        int temp=elements[0];
        for(int i=0 ; i<elements.length-1 ; i++){
            elements[i]=elements[i+1];
        }
        elements[elements.length-1]=temp;
    }

}
