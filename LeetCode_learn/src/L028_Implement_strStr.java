
/**
 * Created by bass on 2018/7/9.
 * @description: implements indexOf in Java
 */
public class L028_Implement_strStr {
    public int strStr(String haystack, String needle){
        if (needle.isEmpty())
            return 0;
        if (haystack.length() < needle.length())
            return -1;
        int i = 0, j = 0;
        int k = 0;
        while (i <= haystack.length() - needle.length()){
            int index = i;
            k = i;
            while (j < needle.length() && haystack.charAt(k) == needle.charAt(j)){
                k++;
                j++;
            }
            if (j == needle.length())
                return index;
            i++;
            j = 0;
        }
        return -1;
    }

    public static void main(String[] args) {
        L028_Implement_strStr test = new L028_Implement_strStr();
        int x = test.strStr("mississippi", "issip");
        System.out.println(x);
    }
}
