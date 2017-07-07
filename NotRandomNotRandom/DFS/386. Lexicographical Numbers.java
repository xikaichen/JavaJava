// n 太大 会超时O(nlogn)
public class Solution {
    public List<Integer> lexicalOrder(int n) {
        //比较第一位，小的排前面
        //比较第二位, 小的排前慢。。。
        //如果都一样，长度小的排前面
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(n, new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                String temp1 = String.valueOf(a);
                String temp2 = String.valueOf(b);
                int len = Math.min(temp1.length(), temp2.length());
                for (int i = 0; i < len; i++) {
                    if (temp1.charAt(i) > temp2.charAt(i)) {
                        return 1;
                    } else if (temp1.charAt(i) < temp2.charAt(i)) {
                        return -1;
                    }
                }
                return temp2.length() == len ? 1 : -1;
            }
        });
        for (int i = 1; i <= n; i++) {
			pq.offer(i);
        }
        List<Integer> res = new LinkedList<Integer>();
        while (!pq.isEmpty()) {
			res.add(pq.poll());	
        }
        return res;
    }
}

//DFS
// The idea is pretty simple. If we look at the order we can find out we just keep adding digit from 0 to 9 to every digit and make it a tree.
// Then we visit every node in pre-order. 
//        1        2        3    ...
//       /\        /\       /\
//    10 ...19  20...29  30...39   ....

public class Solution {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> res = new ArrayList<Integer>();
        for (int i = 1; i < 10; i++) {
            DFS(i, n, res); 
        }
        return res;
    }
    
    public void DFS(int cur, int n, List<Integer> res) {
        if (cur > n) {
            return;
        } else {
            res.add(cur);
            for(int i = 0; i < 10; i++) {
                if (10 * cur + i > n) {
                    return;
                }
                DFS(10 * cur + i, n, res);
            }
        }
    }
}


// The basic idea is to find the next number to add.
// Take 45 for example:
// the next one will be 450 (450 == 45 * 10)(if 450 <= n), or 46 (46 == 45 + 1) (if 46 <= n) or 5 (5 == 45 / 10 + 1)(5 is less than 45 so it is for sure less than n).
// We should also consider n = 600, and the current number = 499, 
// the next number is 5 because there are all "9"s after "4" in "499" 
// so we should divide 499 by 10 until the last digit is not "9".

public List<Integer> lexicalOrder(int n) {
        List<Integer> list = new ArrayList<Integer>(n);
        int curr = 1;
        for (int i = 1; i <= n; i++) {
            list.add(curr);
            if (curr * 10 <= n) {
                curr *= 10;
            } else if (curr % 10 != 9 && curr + 1 <= n) {
                curr++;
            } else {
                while ((curr / 10) % 10 == 9) {
                    curr /= 10;
                }
                curr = curr / 10 + 1;
            }
        }
        return list;
    }

