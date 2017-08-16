// 如果只要insert和remove的话 直接用map就行了，但是map没有index没法getRandom，所以需要list
// 但是insert到list，只有加到最后一个才是O(1)的时间
public class RandomizedSet {
    private List<Integer> arr;
    private Map<Integer, Integer> map;
    private Random rand;
    /** Initialize your data structure here. */
    public RandomizedSet() {
        arr = new LinkedList<Integer>();
        map = new HashMap<Integer, Integer>();
        rand = new Random();
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (map.containsKey(val)) {
            return false;
        } else {
            map.put(val, arr.size());
        }
        arr.add(val);
        return true;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (!map.containsKey(val)) {
            return false;
        } else {
            if (map.get(val) != arr.size() - 1) {
                int loc = map.get(val);
                int temp = arr.get(arr.size() - 1);
                arr.set(loc, temp);
                map.put(temp, loc);
            }
            arr.remove(arr.size() - 1);
            map.remove(val);
        }
        return true;
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        return arr.get(rand.nextInt(arr.size())); // 得到随机数的方法
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */