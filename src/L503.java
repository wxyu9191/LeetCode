import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class L503 {
    public static int[] nextGreaterElements(int[] nums) {

        Stack<Integer> st = new Stack<Integer>();
        int len = nums.length;
        int []res = new int[len];
        Arrays.fill(res, -1);
        for(int i = 0 ; i < len * 2 ; i ++){
            int t = i % len;
            while(!st.isEmpty() && nums[st.peek()] < nums[t])
                res[st.pop()] = nums[t];
            if(i < len)
                st.push(i);
        }

        return res;
    }
}