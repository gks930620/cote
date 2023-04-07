import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MainKAKAO {
    public static void main(String[] args) {

    }

    public String[] solution(String[] history, String[][] option, String keyword) {

        Set<String> optionSet = new HashSet<>();
        List<String> list = new ArrayList<>();
        for (int i = 0; i < option.length; i++) {
            if (option[i][1].equals("T")) {
                optionSet.add(option[i][0]); //  T일 때만 옵션 set에 저장
            }
        }
        if (optionSet.isEmpty()) {
            for (int i = 0; i < history.length; i++) {
                if (history[i].equals(keyword)) {
                    list.add(history[i]);
                }
            }
        } else {
            if (optionSet.contains("W")) {
                addHistoryW(history, keyword, list);
            }
            if (optionSet.contains("WC")) {
                if (has2WCMore(keyword)) return emptyArray();
                if (keyword.contains("*")) {
                    addHistoryWC(history, keyword, list);
                }
            }
            if (optionSet.contains("R")) {
                reduceHistoryR(list);
            }
        }

        if (list.isEmpty()) {
            return emptyArray();
        }
        String[] answer = list.toArray(new String[list.size()]);
        return answer;

    }

    public String[] emptyArray() {
        String[] answer = {"empty"};
        return answer;
    }


    public void addHistoryW(String[] history, String keyword, List<String> list) {
        for (String his : history) {
            String[] split = his.split(" ");
            for (String word : split) {
                if (word.equals(keyword)) {
                    list.add(his);
                    break;
                }
            }
        }
    }

    public void reduceHistoryR(List<String> list) {
        for (int i = 0; i < list.size(); i++) {
            String selectedHis = list.get(i);
            if (selectedHis.length() > 10) {
                selectedHis = selectedHis.substring(0, 10) + "...";
            }
            list.remove(i);
            list.add(i, selectedHis);
        }
    }


    public boolean has2WCMore(String keyword) {
        int wcCount = 0;
        for (int i = 0; i < keyword.length(); i++) {
            char ch = keyword.charAt(i);
            if (ch == '*') wcCount++;
        }
        return wcCount >= 2;
    }

    //1개만 있겠지
    public void addHistoryWC(String[] history, String keyword, List<String> list) {
        int wcIndex=keyword.charAt('*');
        String first=keyword.substring(0,wcIndex);
        String last=keyword.substring(wcIndex);
        for (String his : history) {
            String[] split = his.split(" ");
            for (String word : split) {
                if(word.substring(0, first.length()).equals(first)
                && word.substring(word.length()-last.length()).equals(last)   ){
                    list.add(his);
                    break;
                }

            }
        }
    }

}
