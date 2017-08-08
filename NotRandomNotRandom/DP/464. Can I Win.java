// That is canIWin({num1, num2, ...}, target) can always win is equvalent to there exists one num that after picking it, canIWin({num1, num2, ...} - num, target - num) will lose(The opponent will lose).
public class Solution {
    Map<Integer, Boolean> map;
    boolean[] used;
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        int sum = (1 + maxChoosableInteger) * maxChoosableInteger / 2;
        if (sum < desiredTotal) {
            return false;
        }
        if (desiredTotal <= 0) {
            return true;
        }
        
        map = new HashMap<Integer, Boolean>();
        used = new boolean[maxChoosableInteger + 1];
        
        boolean res = helper(desiredTotal);
        return res;
    }

    public boolean helper(int desiredTotal) {
        if (desiredTotal <= 0) {
            return false;
        }
        int key = format(used);
        if (!map.containsKey(key)) {
    // try every unchosen number as next step
            for (int i = 1; i < used.length; i++) {
                if (!used[i]){
                    used[i] = true;
     // check whether this lead to a win (i.e. the other player lose)
                    if (!helper(desiredTotal - i)) {
                        map.put(key, true);
                        used[i] = false;
                        return true;
                    }
                    used[i] = false;
                }
            }
            map.put(key, false);
        }
        return map.get(key);
    }
   
// transfer boolean[] to an Integer 
    public int format(boolean[] used){
        int num = 0;
        for(boolean b : used){
            num <<= 1;
            if(b) num |= 1;
        }
        return num;
    }
}


// 有n个数 每个数被play1选或者被play2选一共有2 ^ n种可能，遍历时间非常大
// 但是有一些可能是重复的例如1 - 10， play1选1，play2选2，play1选3，这个时候play2只要选大于4的任意数字
// play1就输了，如果key存下来的就是1，2，3被用了的时候play1输，所以如果helper函数轮到了play2，而此时的key又是
// 1，2，3被用掉了，那么map就contains这个key了，就直接return false，也就是play1输。就不需要考虑后面种种可能，因为假设
// 每个玩家都是想赢的。

// 把boolean 变成一个数字 是为了map查询的方便
