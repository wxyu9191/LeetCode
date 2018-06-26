import java.util.*;

/**
 * @author: admin
 * @date: 2018/6/17
 * @description:
 */
public class LongestSubstring {

    public Map<StringBuilder, Integer> LongestSubStringByHashmap(String s){
        if (s == null)
            return null;
        Map<StringBuilder, Integer> result = new HashMap<>(); //result
        StringBuilder maxSubString = new StringBuilder("");//最长子串
        int startIndex = -1;//记录每次获取不同子字符串开始的位置
        int oriStartIndex = startIndex;//记录最终最长子串开始的位置
        int maxLen = 0;
        char[] strs = s.toCharArray();
        int[] charsIndex = new int[256];//serve every character index

        for (int i = 0 ; i < 256 ; i++)//保存每隔字符的位置
            charsIndex[i] = -1;
        for (int index = 0 ; index < strs.length ; index++){
            char temp = strs[index];
            if (charsIndex[temp] > -1 && charsIndex[temp] > startIndex){//repeat
                startIndex = charsIndex[temp];//将开始位置重置成出现重复元素的位置
            }
            // index-1 表示重复字符之前的一个位置，例如abcdfgb,这里b重复的时候取的子串是bcdfg
            if (index - 1 - startIndex + 1 > maxLen){
                maxLen = index - startIndex;
                oriStartIndex = startIndex + 1;
            }
            charsIndex[temp] = index;//更新字符的位置值
        }
        for (int j = oriStartIndex ; j < oriStartIndex + maxLen ; j ++)
            maxSubString.append(strs[j]);
        result.put(maxSubString, maxLen);
        return result;

    }

    public int lengthOfLongestSubstringByHashmap(String s) {
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
                ans = Math.max(ans, j - i);
            }
            else {
                set.remove(s.charAt(i++));
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        String s = "jhhjnsfudufbdfyscfbsdjjSAFASFsefyrsjksaudhsduhasdbg" +
                "ywqep[m,mzaASFASFhuwenzsdjsjfasfyaehwzsjx ;ASFASFlpwisjd" +
                "asuwnad.pqwekASFqowe92347174nsd sdfsdf73bwASFawue821b9sa" +
                "dasjdnasdqASFASASFF2en128adasjdnqwudSAASFF ASFw 1wq89ewa" +
                "dasjdASFhqw8edeqwhedhqwueASFuquweuqwuehqw e123xrkASFajs8" +
                "9da2qe54we24eDASASAFFdfsdifhsd";
                //"abcabcdd";
        LongestSubstring test = new LongestSubstring();
        int res = test.lengthOfLongestSubstringByHashmap(s);
        Map<StringBuilder, Integer> map = test.LongestSubStringByHashmap(s);
        System.out.println(map.entrySet());
        System.out.print(res);
    }
}
