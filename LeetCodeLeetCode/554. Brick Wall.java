public class Solution {
    public int leastBricks(List<List<Integer>> wall) {
        if (wall == null || wall.size() == 0) {
            return 0;
        }
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int count = 0; // count从0开始算 不能从Integer.MIN_VALUE开始
        for (List<Integer> list : wall) {
            int length = 0;
            for (int i = 0; i < list.size() - 1; i++) { // list.size() - 1，因为最后大家的长度都一样了
                length += list.get(i);
                map.put(length, map.getOrDefault(length, 0) + 1);
                count = Math.max(count, map.get(length));
            }
        }
        return wall.size() - count;
    }
}