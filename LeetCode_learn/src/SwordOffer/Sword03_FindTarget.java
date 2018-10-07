package SwordOffer;

public class Sword03_FindTarget {
    public boolean find(int target, int [][]arr){
        boolean res = false;
        if (arr == null)
            return res;
        int i = 0;
        int j = arr[0].length - 1;
        while (i < arr.length && 0 <= j){
            if (arr[i][j] == target){
                res = true;
                break;
            }else if (target < arr[i][j]){
                j--;
            }else {
                i++;
            }
        }
        return res;
    }
}
