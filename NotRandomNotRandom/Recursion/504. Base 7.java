public class Solution {
    public String convertTo7(int num) {
        if (num < 0)
            return '-' + convertTo7(-num); // change any negative number to base 7
        if (num < 7)
            return num + "";
        return convertTo7(num / 7) + num % 7; // method to change any positive number to base 7 remember this! 
    }
}