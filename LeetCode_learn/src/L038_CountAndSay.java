import java.awt.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author: admin
 * @date: 2018/7/12
 * @description:
 */
public class L038_CountAndSay {
    public String countAndSay(int n){
        String result;
        StringBuilder res = new StringBuilder("");
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(1);
        if (n == 1)
            result = String.valueOf(res.append(queue.poll()));
        while (n-- > 1){
            int len = queue.size();
            int count = 1;
            while (len-- >0){
                int temp = queue.poll();
                if (queue.size() >0 && temp == queue.peek() && len != 0)
                    count++;
                else {
                    queue.add(count);
                    queue.add(temp);
                    count = 1;
                }
            }

        }
        int size = queue.size();
        while(size-- > 0){
            String ch = ""+queue.poll();
            res = res.append(ch);
        }
        result = String.valueOf(res);
        return result;
    }

    public static void main(String[] args) {
        L038_CountAndSay test = new L038_CountAndSay();
        String str = test.countAndSay(6);
        System.out.println(str);
    }
}
