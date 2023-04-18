package programers.완전탐색;

import java.util.HashSet;
import java.util.Set;

public class 소수찾기 {
    boolean[] selected;
    String[] strArr;
    Set<Integer> set=new HashSet<>();
    public int solution(String numbers) {
        strArr=new String[numbers.length()];
        selected=new boolean[numbers.length()];
        for(int i=0 ; i<numbers.length() ; i++){
            strArr[i]=numbers.substring(i,i+1);
        }
        rec_func(0,"");
        return set.size();
    }


    public void rec_func(int depth,String num){
        if (depth==strArr.length){  //하나의 숫자완성
            if (!num.isEmpty()) {
                int candPrime = Integer.parseInt(num);
                if (isPrime(candPrime)) {
                    set.add(candPrime);
                }
            }
            return;
        }


        for(int i=0; i<strArr.length ; i++){ //모든 숫자 전부
            if(selected[i]==false){
                selected[i]=true;
                rec_func(depth+1, num+strArr[i]);  //선택함
                rec_func(depth+1,num);  //선택안함
                selected[i]=false;
            }

        }

    }

    public boolean isPrime(int n) {
        if(n==1 ||n==0) return  false;
        if (n == 2 || n == 3) return true;
        int sqrt = (int) Math.sqrt(n);
        for (int i = 2; i <= sqrt; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

}
