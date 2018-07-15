import java.util.*;

/**
 * @author: admin
 * @date: 2018/7/14
 * @description:
 */
public class L017_LetterCombinationsOfAPhoneNumber {
    public static void main(String[] args) {
        L017_LetterCombinationsOfAPhoneNumber test = new L017_LetterCombinationsOfAPhoneNumber();
        List<String> list = test.letterCombinations2("23");
        System.out.println(list);
    }

    //method1
    public static List<String> letterCombinations(String digits){
        List<String> list = new ArrayList<>();
        if (digits.isEmpty())
            return list;
        backtracking("", digits, 0, list);
        return list;
    }

    public static void backtracking(String temp, String digits, int flag, List<String> list){
        String[] strings = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        //代表已经遍历完digits的所有数字，到达底部，需要向上回溯，如23，ad,这时候flag == 2,return到上一层，遍历ae。
        if(flag >= digits.length()){
            list.add(temp);
            return;
        }
        String chars = strings[digits.charAt(flag) - '0'];
        for (int i = 0 ; i < chars.length(); i++){
            backtracking(temp + chars.charAt(i), digits, flag + 1, list);
        }
    }


    //@method2
    public List<String> letterCombinations2(String digits) {
        List<String> res = new  ArrayList<String>();
        if (digits.isEmpty())
            return res;
        Map<Integer, String> map = new HashMap<>();
        map.put(2, "abc");
        map.put(3, "def");
        map.put(4, "ghi");
        map.put(5, "jkl");
        map.put(6, "mno");
        map.put(7, "pqrs");
        map.put(8, "tuv");
        map.put(9, "wxyz");

        Queue<StringBuilder> queue = new LinkedList<>();
        queue.add(new StringBuilder());

        for (int i = 0 ; i < digits.length() ; ++i){
            int limiteSize = queue.size();
            if (digits.charAt(i) == '0' || digits.charAt(i) == '1'){
                continue;
            }

            int number = digits.charAt(i) - '0';
            int j = 0;//用于将queue中的元素依次出队列
            while (!queue.isEmpty() && j < limiteSize){
                StringBuilder strb = queue.poll();
                for (char x: map.get(number).toCharArray()){
                    StringBuilder tmp = new StringBuilder(strb);
                    tmp.append(x);
                    queue.add(tmp);
                }
                j++;
            }
        }
        while (!queue.isEmpty()){
            res.add(queue.poll().toString());
        }
        return res;
    }
}
