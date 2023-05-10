package programers.level2;

public class 숫자카드나누기 {
    public static int solution(int[] arrayA, int[] arrayB) {
        int answer = 0;
        return answer;
    }



    public static int getGCD(int num1, int num2) {
        if (num1 % num2 == 0) {
            return num2;
        }
        return getGCD(num2, num1 % num2);
    }
}
