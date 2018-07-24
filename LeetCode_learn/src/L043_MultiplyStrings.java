/**
 * Created by bass on 2018/7/24.
 */
public class L043_MultiplyStrings {
    public String multiply(String num1, String num2) {
        String res = "";
        int m = num1.length();
        int n = num2.length();
        int []pos = new int[m+n];//store the res, max length
        for (int i = m - 1; i >= 0; i--)
            for (int j = n -1; j >= 0; j--){
                int mul = (num1.charAt(i) - '0')*(num2.charAt(j) - '0');
                int min_pos = i + j + 1;//相对小的数位
                int max_pos = i + j;//相对大的数位
                int cur = pos[min_pos] + mul;
                pos[min_pos] = cur % 10;
                pos[max_pos] = pos[max_pos] + cur / 10;
            }
        StringBuilder sb = new StringBuilder();
        for (int x : pos) {
            if (sb.length() == 0 && x == 0)
                continue;
            sb.append(x);
        }
        res = sb.length() == 0 ? "0" : sb.toString();
        return res;
    }
    public static void main(String[] args) {
        L043_MultiplyStrings test = new L043_MultiplyStrings();
        System.out.println(test.multiply("123", "456"));
    }
}
