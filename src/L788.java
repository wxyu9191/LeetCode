public class L788 {





    public static int rotatedDigits(int N) {
        int num = 0 ;

        for(int i = 0 ; i <= N ; i ++){
            boolean flag = false;
            String s = i + "";
            char[] str = s.toCharArray();
            int len = str.length;

            for(int j = 0 ; j < len ; j++){
                if(str[j] == '3' || str[j] == '4' || str[j] == '7')
                {
                    flag = false;
                    break;
                }
                else if(str[j] == '2' || str[j] == '6' || str[j] == '5' || str[j] == '9') {
                    flag = true;

                }

            }
            if(flag == true)
                num++;
        }
        return num;
    }
}
