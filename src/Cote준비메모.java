public class Cote준비메모 {

    //완전탐색1
    void rec_func(int k){  //k는 depth, 즉 선택한 개수
         if(k==10) {  //탐색을 마침
             //마치고 해야 할 일듯, 보통 그동안 저장된 배열의 값들 가지고 함
         }

        for(int i=1 ; i<=4; i++){  // 선택할 수 있는 것들의 범위

            //이 단계에서 처리할 코드

            rec_func(k+1); //다음단계 진행

            // 원래대로. 돌려놓기
        }
    }
    //완전탐색2
    void rec_func2(int k,int value){  //k는 depth, 즉 선택한 개수
        if(k==10){
            //탐색을 마침
        }
        rec_func2(k+1, value+ 10); // 다음단계 넘어갈 때 현재단계의 무언가(10)를 더함 , 즉 이번단계 선택한 거
        rec_func2(k+1,value);  //  다음단계 넘어갈 때 그대로 넘어감.   이번단계 선택안함
        //부분수열이나 사칙연산 문제 등에서 쓰임.
    }


    //이중탐색
    //거꾸로 생각해야됨. 문제 뒤집기.
    static boolean determination(long len) {
        return  false;
    }
    //이런형태를 벗어나지 않는다. 결국 determination 함수 작성능력이 문제해결
    static void pro() {
        long L = 1, R = Integer.MAX_VALUE, ans = 0;
        // [L ... R] 범위 안에 정답이 존재한다!
        // 이분 탐색과 determination 문제를 이용해서 answer를 빠르게 구하자!
        while (L<=R){
            long mid= (L+R)/2;
            if(determination(mid)){  //n개 만들 수 있는가?  더 길이 늘려도 됨
                ans=mid;
                L=mid+1;
            }else{
                R=mid-1;  // n개 못 만듬. 길이 줄여봄
            }
        }
        System.out.println(ans);
    }

    //이중탐색2

}
