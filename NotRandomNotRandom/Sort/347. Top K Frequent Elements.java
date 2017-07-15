public class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        //count the frequency
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        
        //bucket sort
        // 如果知道array的范围是0 - 已知最大值，就可以用bucket排序 O(n)的时间复杂度
        List<Integer>[] bucket = new List[nums.length + 1]; // 记住bucket的写法
        for (Integer key : map.keySet()) {
            int freq = map.get(key);
            if (bucket[freq] == null) {
                bucket[freq] = new LinkedList<Integer>();
            }
            bucket[freq].add(key);
        }
        
        List<Integer> res = new LinkedList<Integer>();
        for (int i = nums.length; i >= 0; i--) {
            if (bucket[i] != null) {
                res.addAll(bucket[i]);
                k -= bucket[i].size();
            }
            if (k <= 0) { // can't handle the case top 1 element, while nums= [1,2,3,4]; the code will return [1,2,3,4] since they are all top 1 elmenet
                break;
            }
        }
        return res;
    }
}