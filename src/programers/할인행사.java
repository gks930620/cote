package programers;

import java.util.*;

public class 할인행사 {
    public static void main(String[] args) {
        String[] want = {"banana", "apple", "rice", "pork", "pot"};
        int[] number = {3, 2, 2, 2, 1};
        String[] discount = {"chicken", "apple", "apple", "banana", "rice", "apple", "pork", "banana", "pork", "rice", "pot", "banana", "apple", "banana"};
        int a = new 할인행사().solution(want, number, discount);
        System.out.println(a);
    }

    Map<String, Integer> map = new HashMap<>();
    Map<String, Integer> wantMap = new HashMap<>();
    int count = 0;

    public int solution(String[] want, int[] number, String[] discount) {
        for (int i = 0; i < want.length; i++) {
            wantMap.put(want[i], number[i]);
        }

        for (int i = 0; i < 10; i++) { //초기 10개 map에 저장
            map.put(discount[i], map.getOrDefault(discount[i], 0) + 1);
        }
        satis(); //길이가 딱 10일 때 한번
        for (int i = 0; i < discount.length - 10; i++) {   //기존거 지우고 다음거 담아봄
            map.put(discount[i], map.get(discount[i]) - 1);   // null이 나올 수 없다.
            map.put(discount[i + 10], map.getOrDefault(discount[i + 10], 0) + 1);
            satis();
        }

        return count;
    }

    public void satis() {
        boolean satis = true;
        //map은 wantMap에 있는걸 모두 가지고 있어야 함..
        for (String key : wantMap.keySet()) {   //wantMap에 있는 걸 모두 조사
            int wantValue = wantMap.get(key);
            int discountValue = map.getOrDefault(key, 0);   // 없을수도 있지
            if (discountValue != wantValue) {  //내가 원하는 품목이 할인들 품목보다 작으면
                satis = false;
                break;
            }
        }
        if (satis) count++;
    }
}
