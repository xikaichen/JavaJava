class subset2 {
    public ArrayList<ArrayList<Integer>> subsetsWithDup(int[] nums) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> temp = new ArrayList<Integer>();
        Arrays.sort(nums);
        backtrack(nums, res, temp, 0);
        return res;
    }
    
    private void backtrack(int[] nums,
        ArrayList<ArrayList<Integer>> res, ArrayList<Integer> temp,
        int start) {
            res.add(new ArrayList(temp));
            for (int i = start; i < nums.length; i++) {
                if (i > start && nums[i] == nums[i - 1]) {
                    continue;
                }
                temp.add(nums[i]);
                backtrack(nums, res, temp, i + 1);
                temp.remove(temp.size() - 1);
            }
        }
}
