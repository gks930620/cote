package programers.해쉬;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class 폰켓몬 {
    public int solution(int[] nums) {
        Arrays.sort(nums);
        int maxPick= nums.length/2;
        int count=1;  //0번째거는 무조건 가저간다고 가정
        for(int i=1 ; i<nums.length && count<maxPick ; i++){ //1부터 시작
            if(nums[i]!=nums[i-1]){  //다른 종류이면
                count++;
            }
        }

        return count ;
    }

    public int solution2(int[] nums) {
        Set<Integer> set= new HashSet<Integer>();
        for(int i=0 ; i<nums.length ; i++) {
            set.add(nums[i]);
        }
        return set.size()>nums.length/2 ? nums.length/2 : set.size();
    }

}
