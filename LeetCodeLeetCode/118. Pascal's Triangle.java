public class Solution {
    public List<List<Integer>> generate(int numRows) {
    	List<List<Integer>> res = new LinkedList<List<Integer>>();
    	LinkedList<Integer> temp = new LinkedList<Integer>();
    	for (int i = 0; i < numRows; i++) {
    		temp.addFirst(1);
    		for (int j = 1; j < temp.size() - 1; j++) {
    			temp.set(j, temp.get(j) + temp.get(j + 1));
    		}
    		res.add(new LinkedList(temp));
    	}
    	return res;
    }
}