/**
 * @author: admin
 * @date: 2018/9/29
 * @description:
 */
public class Mostprofite {
    public static int maxProfit(int[] prices) {
        int profit = 0, i = 0;
        while (i < prices.length) {
            // find next local minimum
            while (i < prices.length-1 && prices[i+1] <= prices[i]) i++;
            int min = prices[i++]; // need increment to avoid infinite loop for "[1]"
            // find next local maximum
            while (i < prices.length-1 && prices[i+1] >= prices[i]) i++;
            profit += i < prices.length ? prices[i++] - min : 0;
        }
        return profit;
    }

    public static void main(String[] args) {
        int []arr = {7, 1, 5, 3, 6, 4};
        System.out.println(Mostprofite.maxProfit(arr));
    }
}
