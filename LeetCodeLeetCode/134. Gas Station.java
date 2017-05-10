// compute the netCost, then check every station i to see if it can complete the circuit

public class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
       int[] netCost = new int[gas.length];
       for (int i = 0; i < gas.length; i++) {
           netCost[i] = gas[i] - cost[i];
       }
       
       for (int i = 0; i < gas.length; i++) {
           if (isComplete(i, netCost)) {
               return i;
           }
       }
       return -1;
    }
    
    private boolean isComplete(int i, int[] netCost) {
        int complete = 0;
        for (int index = i; index < netCost.length; index++) {
            complete += netCost[index];
            if (complete < 0) {
                return false;
            }
        }
        for (int index = 0; index < i; index++) {
            complete += netCost[index];
            if (complete < 0) {
                return false;
            }
        }
        return true;
    }
    
   
}