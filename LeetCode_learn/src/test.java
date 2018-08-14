public class test {
    public boolean Find(int target, int [][] array) {
        int row = 0;
        int col = array[0].length-1;
        while(row < array.length&&col >= 0){
            if(target == array[row][col]){
                return true;
            }else if(target < array[row][col]){
                col--;
            }else{
                row++;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        test t = new test();
        int [][] arr = {{1, 2, 3}, {4, 5, 6 }, {7, 8, 9}};
        System.out.println(t.Find(10, arr));
    }
}