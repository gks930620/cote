import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        String str = "edeaaabbccd";
        System.out.println(solution(str));

    }
    public static String solution(String inputString) {
        Stack<String> stack= new Stack<>();
        stack.push(inputString.substring(0,1));
        for(int i=1 ; i<inputString.length() ; i++){
            String subStr= inputString.substring(i,i+1);
            if(!stack.peek().equals(subStr)){
                stack.push(subStr);
            }
        }
        Map<String,Integer> map= new HashMap<>();
        stack.sort(String::compareTo);
        stack.stream().forEach(  o-> map.put(o,  map.getOrDefault(o,0) +1 ));
        StringBuffer sb=new StringBuffer();
        map.forEach(  (str,length) -> {
            if(length>=2) {
                sb.append(str);
            }
        });
        String answer= sb.toString();
        if(answer.equals("")) return "N";
        return answer;
    }

}