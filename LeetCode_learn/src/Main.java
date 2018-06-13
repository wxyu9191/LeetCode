import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int res = 0;
        int []tst ={1, 2, 1};
        //int[] tst = {100,1,11,1,120,111,123,1,-1,-100};
        tst = L503.nextGreaterElements(tst);
        res = L400.findNthDigit(55);
        //int res = L788.rotatedDigits(847);
        System.out.println(Arrays.toString(tst));
    }
}
