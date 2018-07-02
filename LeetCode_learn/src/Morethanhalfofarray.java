

import java.util.HashMap;
import java.util.Map;

public class
Morethanhalfofarray {
    public static int MoreThanHalfNum_Solution(int[] array) {
        if (array.length == 0)
            return 0;
        if (array.length == 1)
            return array[0];

        int max = 0, target = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            if (!map.containsKey(array[i])) {
                map.put(array[i], 1);
            } else {
                int temp = map.get(array[i]) + 1;
                map.put(array[i], temp);
                if (max < temp) {
                    max = temp;
                    target = i;
                }
            }
        }
        return max > array.length / 2 ? array[target] : 0;
    }

    public static void main(String[] args) {
        int test[] = {2, 2, 2, 2, 2, 1, 3, 4, 5};
        int res = Morethanhalfofarray.MoreThanHalfNum_Solution(test);
        System.out.println(res);
    }

}

