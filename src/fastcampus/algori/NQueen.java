package fastcampus.algori;

import java.util.*;
public class NQueen {
	public void dfsFunc(Integer N, Integer currentRow,ArrayList<Integer> currentCandidate) {
		if(currentRow==N) {
			System.out.println(currentCandidate);
			return ;
		}
		for(int i=0; i<N ; i++) {
			// 현재 행의 모든 열을 체크해야함
			if(isAvailable(currentCandidate,i)==true) {
				currentCandidate.add(i);
				dfsFunc(N, currentRow+1, currentCandidate);   
				currentCandidate.remove(currentCandidate.size()-1);    //조건에 맞는게 없다. 현재 검사한거 삭제
			}
		}
	}
	private boolean isAvailable(ArrayList<Integer> candidate, Integer currentCol) {
		Integer currentRow=candidate.size();  //2개 있으면 3번째 row찾아야함.  0,1,2 
		for(int i=0; i<currentRow; i++) {
			if(candidate.get(i)==currentCol ||Math.abs(candidate.get(i)-currentCol)==currentRow-i) { //수직, 대각선 
				return false;
			}
		}
		return true;
	}
}











