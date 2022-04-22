import java.util.Arrays;

public class BubbleSort {
	public static void main(String[] args) {
		int[] arr = { 1,3,4,6,7,8,9 };
		// bubble(arr);
		improvedBubble1(arr);
		System.out.println(Arrays.toString(arr));
	}

	// 앞에서부터 해서 한회차 끝 제일큰게 뒤로 가게
	static void bubble(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 1; j < arr.length - i; j++) {
				if (arr[j - 1] > arr[j]) {
					int temp = arr[j];
					arr[j] = arr[j - 1];
					arr[j - 1] = temp;
				}
			}
		}

	}

	static void improvedBubble1(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			boolean isChange=false;
			for (int j = 1; j < arr.length - i; j++) {
				if (arr[j - 1] > arr[j]) {
					int temp = arr[j];
					arr[j] = arr[j - 1];
					arr[j - 1] = temp;
					isChange=true;
				}
			}
			if(!isChange)break;
		}
	}

	

}
