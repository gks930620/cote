package programmers;

public class GymSuit {
	public static void main(String[] args) {
		int[] lost= {2,4};
		int[] reserve= {1,3,5};
		int n=5;
		System.out.println(solution(n, lost, reserve));
	}

	public static int solution(int n, int[] lost, int[] reserve) {
		int[] arr=new int[n];
		for(int i=0; i<arr.length ; i++) {
			arr[i]=1;
		}
		//lost에 있는 값의 index의 arr배열은 -1
		for(int i=0; i<lost.length ; i++) {
			int index=	--lost[i];
			arr[index]-=1;
		}
		//reserve에 있는 값의 index의 arr배열은 +1	
		for(int i=0; i<reserve.length ; i++) {
			int index=	--reserve[i];
			arr[index]+=1;
		}
		//앞에있는 학생한테 주는데,  안줘도 되면 뒤에있는학생한테 줌.
		//2인 학생을 먼저 찾자(여벌)
		// 둘다 안줘도 되면 그냥 안줌   0번째랑 마지막에 index벗어나는거 주의
		for(int i=0; i<arr.length ; i++) {
			if(arr[i]==2) {
				//앞에있는학생 찾기
				if(i!=0&& arr[i-1]==0) {
					arr[i-1]++; //앞에있는학생한테 주기 
					arr[i]--;
				}
				if(arr[i]==2 && i!=arr.length-1 && arr[i+1]==0) {
					//앞에 애한테 줬으면 1개줄어들었으니까 다시 검사
					arr[i+1]++; //뒤에있는학생한테 주기 
					arr[i]--;
				}
			}
		}
		int answer = 0;
		for(int i=0 ; i<arr.length; i++) {
			if(arr[i]>0)answer++;
		}
		 
		return answer; 
	}
}
