package programers;

import java.util.*;

public class 롤케이크자르기 {
    public static void main(String[] args) {
        int[] toppings={1, 2, 1, 3, 1, 4, 1, 2};
        int a=new 롤케이크자르기().solution(toppings);
    }
    public int solution(int[] topping) {
        Set<Integer> set = new HashSet<>();
        int[] dp = new int[topping.length];
        int[] reverseDp = new int[topping.length];

        for (int i = 0; i < topping.length-1; i++) { //dp   0번부터 i번까지의 토핑수
            set.add(topping[i]);
            dp[i] = set.size();
        }
        set=new HashSet<>();
        for (int i = topping.length-1; i >0; i--) { //reverseDp      reverseD[[4]=   5부터 끝까지했을때 topping 수
            set.add(topping[i]);
            reverseDp[i] = set.size();
        }

        int count=0;
        for(int i=0 ; i<topping.length-1 ; i++){
            if(dp[i]==reverseDp[i+1]) count++;
        }

        System.out.println(Arrays.toString(dp));
        System.out.println(Arrays.toString(reverseDp));


        return count;
    }
}
