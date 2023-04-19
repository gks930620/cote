package programers.level2;

import java.util.*;

public class 연속부분수열합의개수 {
    public static void main(String[] args) {
        int[] elements={7,9,1,1,4};
        System.out.println(solution(elements));

    }

    public static int solution(int[] elements) {
        // 똑같은 배열 붙여주고  0에서 원래 배열 크기만큼 sum해주고 set에 넣자
        Set<Integer> set=new HashSet<>();
        int[] newElements= new int[elements.length*2];
        for(int i=0; i<elements.length ; i++){
            newElements[i]=elements[i];
        }
        for(int i=elements.length ; i<newElements.length ; i++){
            newElements[i]=elements[i-elements.length];
        }

        for(int i=0 ; i<elements.length ; i++){  //시작점을 의미
            int sum=0;
            for(int j=0; j<elements.length ; j++){  //부분수열 길이를 의미
                sum+=newElements[i+j];
                set.add(sum);
            }
        }


     return set.size();
    }





}
