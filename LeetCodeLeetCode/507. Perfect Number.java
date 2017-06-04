public class Solution {
    public boolean checkPerfectNumber(int num) {
        if (num == 1) {
            return false;
        }
        List<Integer> list = new LinkedList<Integer>();
        list = getDivisor(num);
        return sumDivisor(list) + 1 == num;
    }
    private List<Integer> getDivisor(int num) {
        List<Integer> res = new LinkedList<Integer>();
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                res.add(i);
                res.add(num / i);
            }
        }
        return res;
    }
    
    private int sumDivisor(List<Integer> list) {
        int sum = 0;
        for (int i = 0; i < list.size(); i++) {
            sum += list.get(i);
        }
        return sum;
    }
}