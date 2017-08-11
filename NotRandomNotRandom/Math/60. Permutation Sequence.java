// 代码是对的但是会超时
public class Solution {
    public String getPermutation(int n, int k) {
        List<String> res = new LinkedList<String>();
        boolean[] used = new boolean[n + 1];
        String temp = "";
        backtrack(res, temp, used, n);
        return res.get(k - 1);
    }
    
    private void backtrack(List<String> res, String temp, boolean[] used, int n) {
        if (temp.length() == n) {
            res.add(temp);
            return;
        }
        for (int i = 1; i <= n; i++) {
            if (used[i]) {
                continue;
            }
            used[i] = true;
            backtrack(res, temp + String.valueOf(i), used, n);
            used[i] = false;
        }
    }
} 

// 数学， 数数字，根据k来判断 该在什么位置
public class Solution {
    public String getPermutation(int n, int k) {
        int pos = 0;
        List<Integer> numbers = new ArrayList<>();
        int[] factorial = new int[n+1];
        StringBuilder sb = new StringBuilder();
        
        // create an array of factorial lookup
        int sum = 1;
        factorial[0] = 1;
        for(int i=1; i<=n; i++){
            sum *= i;
            factorial[i] = sum;
        }
        // factorial[] = {1, 1, 2, 6, 24, ... n!}
        
        // create a list of numbers to get indices
        for(int i = 1; i <= n; i++) {
            numbers.add(i);
        }
        // numbers = {1, 2, 3, 4}
        
        k--;
        
        for(int i = 1; i <= n; i++) {
            int index = k / factorial[n - i];
            sb.append(numbers.get(index));
            numbers.remove(index);
            k -= index * factorial[n - i];
        }
        
        return String.valueOf(sb);
    }
}