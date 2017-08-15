// 题目的意思是有一个无限循环的字符串s: abcd....xyzabc..., 给一个字符p，问p的substring有多少是在s里的
public class Solution {
    public int findSubstringInWraproundString(String p) {
        // count[i] is the maximum unique substring end with ith letter.
        // 0 - 'a', 1 - 'b', ..., 25 - 'z'.
        int[] count = new int[26];
        
        // store longest contiguous substring ends at current position.
        int maxLengthCur = 0; 

        for (int i = 0; i < p.length(); i++) {
            if (i > 0 && (p.charAt(i) - p.charAt(i - 1) == 1 || (p.charAt(i - 1) - p.charAt(i) == 25))) {
                maxLengthCur++;
            }
            else {
                maxLengthCur = 1;
            }
            
            int index = p.charAt(i) - 'a';
            count[index] = Math.max(count[index], maxLengthCur);
        }
        
        // Sum to get result
        int sum = 0;
        for (int i = 0; i < 26; i++) {
            sum += count[i];
        }
        return sum;
    }
}

z
za a
zab ab b
zabc abc bc c
x
xy y
xyz yz z
xyza yza za a


// i.e:  z a b c x y z a
//       1 2 3 4 1 2 3 4
// count:a-4, b-3, c-4, x-1, y-2, z-3 取最大的数字，例如a取4，因为这样已经把所有以a结尾的可能都包括了
// sum = 17