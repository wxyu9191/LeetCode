import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * @author: admin
 * @date: 2018/6/17
 * @description:
 */
public class LongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        char temp;
        Set<Character> set = new HashSet<>();

        int ans = 0, i = 0, j = 0;
        StringBuilder res = new StringBuilder();
        while (i < n && j < n) {
            // try to extend the range [i, j]
            if (!set.contains(s.charAt(j))){
                temp = s.charAt(j++);
                set.add(temp);
                Iterator<Character> it = set.iterator();
                while (it.hasNext()){
                    res.append(temp);
                    it.next();
                }
                ans = Math.max(ans, j - i);
            }
            else {
                set.remove(s.charAt(i++));
            }
        }
        System.out.println(res);
        return ans;
    }

    public static void main(String[] args) {
        String s = "abcabcdd";
        LongestSubstring test = new LongestSubstring();
        int res = test.lengthOfLongestSubstring(s);
        System.out.println(res);
    }
}
