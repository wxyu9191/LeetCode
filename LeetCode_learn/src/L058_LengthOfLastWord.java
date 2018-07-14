import java.util.Stack;

/**
 * @author: admin
 * @date: 2018/7/13
 * @description:
 */
public class L058_LengthOfLastWord {
    public int lengthOfLastWord(String s) {
        char[] chars = s.toCharArray();
        int len = chars.length;
        int res = 0;
        boolean flag = true;
        Stack<Character> stack = new Stack<>();
        for (int i = len - 1; i >= 0 ; i--){
            if (flag == true && chars[i] == ' ')
                continue;
            else if (chars[i] != ' '){
                stack.push(chars[i]);
                flag = false;
            }else if (chars[i] == ' ')
                break;
        }
        return stack.size();
    }

    public static void main(String[] args) {
        L058_LengthOfLastWord ll = new L058_LengthOfLastWord();
        String text = "a ";
        System.out.println(text.length());
        System.out.println(ll.lengthOfLastWord(text));
    }
}
