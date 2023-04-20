package programers.level2;

public class 마법의엘리베이터 {

    public int solution(int storey) {
        int button=0;
        while (storey!=0){
            int last= storey%10;
            if(last>5){
                button+=  10-last;
                storey+=10;
            }else if(last<5){
                button+=last;
            }else{// 5인경우
                int second= storey%100/10;
                if(second>=5){  //second는 5이상부터
                    button+= 10-last;
                    storey+=10;
                }else {
                    button+=last;
                }
            }
            storey /=10;
        }

        int answer = 0;
        return button;
    }
}
