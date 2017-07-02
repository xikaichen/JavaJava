// A - 65
public class Solution {
    public String convertToTitle(int n) {
        if (n == 0) {
            return "";
        }
        if (n < 26) {
            return (char) (n + 64) + "";
        }
        if (n % 26 == 0) {
            return convertToTitle(n / 26 - 1) + 'Z';  // if n % 26, like n = 26,52. than means 26 /26 = 1, 26 % 26 = 0. In this case, 0 represent Z and there should be only one bit.
        }
        return convertToTitle(n / 26) + (char) (n % 26 + 64);
    }
}


//a better way
//the magic is map 0 to A and 25 to Z.
//because doing this, 0 always represent A. In first solution 0 can represent "" and 'Z'. 
public class Solution {
    public String convertToTitle(int n) {
        n = n - 1;
        if (n < 26) {
            return (char) (n + 65) + "";
        }
        return convertToTitle((n / 26)) + (char) (n % 26 + 65);
    }
}

