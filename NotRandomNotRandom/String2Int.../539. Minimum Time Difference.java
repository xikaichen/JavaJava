public class Solution {
    public int findMinDifference(List<String> timePoints) {
        int diff = Integer.MAX_VALUE;
        List<Integer> time = new ArrayList<Integer>();
        
        for (int i = 0; i < timePoints.size(); i++) {
            Integer h = Integer.valueOf(timePoints.get(i).substring(0, 2));
            time.add(60 * h + Integer.valueOf(timePoints.get(i).substring(3, 5))); // convert to total minutes
        }
        
        Collections.sort(time, (Integer a, Integer b) -> a - b); // sort
        
        for (int i = 1; i < time.size(); i++) {
            diff = Math.min(diff, time.get(i) - time.get(i - 1));
        }
        
        int corner = 1440 + time.get(0) - time.get(time.size() - 1); // conside the corner case: 1440 + first element - last element
        return Math.min(diff, corner);
    }
}