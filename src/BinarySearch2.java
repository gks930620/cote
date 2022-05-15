import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BinarySearch2 {
	public static void main(String[] args) {
		ArrayList<Integer> list=new ArrayList<>();
		list.add(1);
		list.add(3);
		list.add(5);
		list.add(7);
		list.add(9);
		list.add(11);
		list.add(17);
		System.out.println(searchFunc(list, 11));
	}
	
	
	public static boolean searchFunc(ArrayList<Integer> dataList,Integer searchItem) {
		if(dataList.size()==1 && searchItem==dataList.get(0)) {
			return true;
		}
		if(dataList.size()==1 && searchItem!=dataList.get(0)) {
			return false;
		}
		if(dataList.size()==0) {
			return false;
		}
		int medium=dataList.size()/2;
		if(searchItem==dataList.get(medium)) {
			return true;
		}else {
			if(searchItem<dataList.get(medium)) {
				return searchFunc(new ArrayList<Integer>(dataList.subList(0,medium)), searchItem);
			}else {
				return searchFunc(new ArrayList<Integer>(dataList.subList(medium,dataList.size())), searchItem);
			}
		}
		
	}
	
}
