/*
@author: bass
@data: 2018-08-08 08:04:40
*/
public class L067_AddBinary {
    public String addBinary(String a, String b){
        StringBuilder res = new StringBuilder();
        int i = a.length() - 1, j = b.length() - 1, carry = 0;
        while (i >=0 || j >= 0){
            int sum  = carry;
            if ( j >= 0) sum += b.charAt(j--) - '0';
            if ( i >= 0) sum += a.charAt(i--) - '0';
            res.append(sum % 2);
            carry = sum/2;
        }
        if (carry != 0)
            res.append(carry);
        return res.reverse().toString();
    }

    public static void main(String[] args) {
        L067_AddBinary test = new L067_AddBinary();
        System.out.println(test.addBinary("101", "1010"));
    }
}
