import java.io.*;
import java.math.BigInteger;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.*;

public class KAKAOTEST {
	
	public static void main(String[] args) throws Exception {

		LinkedList<Integer> list = new LinkedList<Integer>();
		LinkedList<Integer> list2 = new LinkedList<Integer>();

		list.add(5);
		list.add(15); 
		list.add(19);

		list2.add(10);
		list2.add(3);
		list2.add(5);
		list2.add(8);

		System.out.println(solution3(list));
		System.out.println(solution3(list2));

	}

	public static int solution3(List<Integer> box) {
		double avg = 0;
		int sum = 0;
		for (int bc : box) {
			sum += bc;
		}
		avg = (sum * 1.0) / box.size();
		avg = Math.ceil(avg);
		for(int i=1; i < box.size() ; i++) {
			int moveBreadCount = (int)avg- box.get(i-1);
			if( moveBreadCount>0  &&  box.get(i) >=moveBreadCount )  {
				box.set(i-1, box.get(i-1) + moveBreadCount  );
				box.set(i, box.get(i) - moveBreadCount);
			}
			
			if( box.get(i) > avg) { // �Ű�µ��� ��պ��� ũ�ٸ� ���� �� ���� 
				int newAvg= (box.get(i) + box.get(i-1)) /2;
				int newMoveBreadCount= newAvg-box.get(i-1);
				box.set(i-1, box.get(i-1) + newMoveBreadCount  );
				box.set(i, box.get(i) - newMoveBreadCount);
			}
		}
		int max=0;
		for(int i=0; i<box.size() ; i++) {
			max=Math.max(max, box.get(i));
		}
		
		return max;
	}

	public static int solution2(List<Integer> cost, int x) {
		final int MOD = 1_000_000_007;
		int answer = 0;
		for (int i = cost.size() - 1; i >= 0; i--) {
			if (x >= cost.get(i)) {
				Long A = 2L;
				Long X = (long) i;
				Long K = 1L;
				A %= MOD;

				while (X > 0) {
					if ((X & 1) == 1)
						K = K * A % MOD;

					X >>= 1;
					A = A * A % MOD;
				}

				answer += K;
				answer %= MOD;
				x -= cost.get(i);
			}
		}
		return answer;

	}

	public static int solution1(int x, int y, int z) {
		// Write your code here
		// BFS���� �ΰ� �ߴµ� �׳� ��������ΰ�?..
		if (Math.abs(x - y) > z)
			return -1;
		if (y > x) { // ��ǥ�� �����ʿ� ���� �� , Z�� ����� ũ��.
			return x + (y - x) + (z - (y - x)) / 2;
		} else { // ��ǥ�� ����
			return (z - (x - y)) / 2 + x;
		}

	}
}