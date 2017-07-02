public class Solution {
    public String largestNumber(int[] nums) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(10, new Comparator<Integer>(){
           @Override
           public int compare(Integer a, Integer b) {
               String s1 = a.toString() + b.toString(); // tricky part: compare a + b and b + a
               String s2 = b.toString() + a.toString();
               for (int i = 0; i < s1.length(); i++) {
                   if (s1.charAt(i) > s2.charAt(i)) {
                       return -1;
                   } else if (s1.charAt(i) < s2.charAt(i)) {
                       return 1;
                   } else {
                       continue;
                   }
               }
               return 0;
               
           }
        });
        
        for (int i = 0; i < nums.length; i++) {
            pq.offer(nums[i]);
        }
        StringBuilder sb = new StringBuilder();
        while (!pq.isEmpty()) {
            int cur = pq.poll();
            if (sb.toString().equals("0") && cur == 0) {
                continue;
            }
            sb.append(cur);
        }
        return sb.toString();
    }
}