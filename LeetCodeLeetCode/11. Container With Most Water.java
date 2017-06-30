public class Solution {
    public int maxArea(int[] height) {
        int left = 0, right = height.length - 1;
        int maxArea = (right - left) * Math.min(height[left], height[right]);
        while (left + 1 < right) {
            while (left + 1 < right && height[left] <= height[right]) {
                left++;
                if (height[left] < height[left - 1]) {
                    continue;
                }
                maxArea = Math.max(maxArea, (right - left) * Math.min(height[left], height[right]));
            }
            while (left + 1 < right && height[left] >= height[right]) {
                right--;
                if (height[right] < height[right + 1]) {
                    continue;
                }
                maxArea = Math.max(maxArea, (right - left) * Math.min(height[left], height[right]));
            }
        }
        return maxArea;
    }
}