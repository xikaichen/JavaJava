public class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> res = new LinkedList<String>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        if (nums.length == 1) {
            res.add(nums[0] + "");
            return res;
        }
        int first = nums[0], last = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] - 1 == nums[i - 1]) {
                last = nums[i];
            } else {
                if (first != last) {
                    res.add(first + "->" + last);
                } else {
                    res.add(first + "");
                }
                first = nums[i];
                last = nums[i];
            }
        }
        if (first != last) {
            res.add(first + "->" + last);
        } else {
            res.add(first + "");
        }
        return res;
    }
}

// more concise
public class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> res = new LinkedList<String>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        if (nums.length == 1) {
            res.add(nums[0] + "");
            return res;
        }
        
        for (int i = 0; i < nums.length; i++) {
            int first = nums[i];
            while (i < nums.length - 1 && nums[i + 1] - 1 == nums[i]) {
                i++;
            }
            int last = nums[i];
            if (first != last) {
                res.add(first + "->" + last);
            } else {
                res.add(first + "");
            }
        }

        return res;
    }
}