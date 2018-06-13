public class L400 {
    public static int findNthDigit(int n) {
        int len = 1;
        long count = 9;
        int start = 1;

        while (n > len * count) {
            n -= len * count;
            len += 1;
            count *= 10;
            start *= 10;//又从1开始数
        }

        start += (n - 1) / len;
        String s = Integer.toString(start);//s定位了 到哪个数字累加一起满足了n
        return Character.getNumericValue(s.charAt((n - 1) % len));//定位到具体哪个数字。
    }
}
