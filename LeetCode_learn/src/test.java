import java.util.LinkedList;
/*
 * @description: search each sub windows max
 * */
public class test {

    public static void main(String[] args) {
        int [] arr = {3,4,6,4,9};
        arr = getMaxwindow(arr, 3);
        for (int x : arr)
            System.out.println(x);
    }

    public static int[] getMaxwindow(int[] arr, int w){

        if(arr == null || w < 1 || arr.length ==1)
            return null;

        LinkedList<Integer> qmax = new LinkedList<Integer>();
        //result
        int[] res = new int[arr.length - w + 1];
        int index = 0;
        //[3, 2, 6, 4, 9]. 		[6, 6, 9]
        for(int i = 0 ; i < arr.length ; i ++) {
            while (!qmax.isEmpty() && arr[qmax.peekLast()] <= arr[i]) {
                qmax.pollLast();
            }

            qmax.addLast(i);//[0,1]
            if (qmax.peekFirst() == i - w) {
                qmax.pollFirst();
            }
            if(i >= w - 1){
                res[index++] = arr[qmax.peekFirst()];
            }

        }
        return res;
    }
}
