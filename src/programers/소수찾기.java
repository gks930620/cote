package programers;

import java.util.HashSet;
import java.util.Set;

public class 소수찾기 {

    public static void main(String[] args) {
        System.out.println(new 소수찾기().solution("011"));
    }

    boolean[] selected;
    Set<Integer> set = new HashSet<>();
    String[] strArr;

    public int solution(String numbers) {
        strArr = new String[numbers.length()];
        selected = new boolean[numbers.length()];
        for (int i = 0; i < numbers.length(); i++) {
            strArr[i] = numbers.substring(i, i + 1);
        }
        rec_func(0, "");

        return set.size();
    }


    //숫자말고 index 선택된거는 제외해야지
    public void rec_func(int depth, String num) {
        if (depth == strArr.length) { //다 선택함
            if (!num.isEmpty()) {
                int candPrime = Integer.valueOf(num);
                if (isPrime(candPrime)) {
                    System.out.println(candPrime);
                    set.add(candPrime);
                }
            }
            return;
        }

        for (int i = 0; i < strArr.length; i++) {  //모든 순서
            if (selected[i] == false) {
                selected[i]=true;
                rec_func(depth + 1, num + strArr[i]); //선택함
                rec_func(depth + 1, num); //선택안함
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
