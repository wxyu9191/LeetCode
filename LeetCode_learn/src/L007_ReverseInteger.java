import java.math.BigInteger;
import java.util.Iterator;

/**
 * Created by bass on 2018/7/25.
 */
public class L007_ReverseInteger {
    public int reverse(int x) {
        int res = 0;
        String str = String.valueOf(Math.abs(x));
        char[] chars = str.toCharArray();
        int len = chars.length;
        if (len == 1)
            return x;
        for (int i = 0 ; i < len/2 ; i++){
            char tmp = chars[i] ;
            chars[i] = chars[len - i - 1];
            chars[len - i - 1] = tmp;
        }
        StringBuilder sb = new StringBuilder();
        int i = 0;
        for (int j = 0 ; j < len ; j++){
            if (chars[j] == '0' && sb.length() == 0)
                continue;
            sb.append(chars[j]);
        }
        try {
            res = Integer.valueOf(sb.toString());
        }catch (Exception e){
            return res;
        }
        return x >= 0 ? res : -res;
    }

    public static void main(String[] args) {
        L007_ReverseInteger text = new L007_ReverseInteger();
        System.out.println(text.reverse(901000));
    }
}
