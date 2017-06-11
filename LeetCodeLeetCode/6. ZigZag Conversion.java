// 遍历s， 创建numRows个StringBuilder，设置一个方向根据当前处在哪一个StringBuilder来决定方向的变化，当处于最后一个StringBuilder的时候方向要反过来
public class Solution {
    public String convert(String s, int numRows) {
        if (numRows <= 1) { // corner case 一行的时候 直接返回
            return s;
        }
        StringBuilder[] sbs = new StringBuilder[numRows];
        for (int i = 0; i < sbs.length; i++) {
            sbs[i] = new StringBuilder();
        }
        int direction = 1;
        int index = 0;
        for (int i = 0; i < s.length(); i++) {
            sbs[index].append(s.charAt(i));
            if (index == 0) {
                direction = 1;
            }
            if (index == numRows - 1) {
                direction = -1;
            }
            index += direction;
        }
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < sbs.length; i++) {
            res.append(sbs[i]);
        }
        return res.toString();
    }
}