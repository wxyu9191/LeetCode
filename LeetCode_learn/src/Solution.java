import java.util.ArrayList;
import java.util.LinkedList;

public class Solution {

    public static void main(String[] args) {
        int [] arr = {10,14,12,11};
        ArrayList<Integer> e = maxInWindows(arr, 0);
        for (int x : e)
            System.out.println(x);
    }

    public static ArrayList<Integer> maxInWindows(int [] num, int size)
    {
        if (num == null || size < 1 || num.length < size)
            return null;
        int len = num.length;

        //int res[] = new int[num.length - size + 1];
        ArrayList<Integer> res = new ArrayList<>();
        //int index = 0 ;
        LinkedList<Integer> maxlist = new LinkedList<Integer>();
        for(int i = 0 ; i < len ; i++){
            while(!maxlist.isEmpty() && num[maxlist.peekLast()] < num[i])
            {
                maxlist.pollLast();
            }
            maxlist.addLast(i);

            if(maxlist.peekFirst() == i - size)
                maxlist.pollFirst();

            if (i >= size-1)
                //res[index++] = num[maxlist.peekFirst()];
                res.add(num[maxlist.peekFirst()]);
        }
        return res;
    }
}