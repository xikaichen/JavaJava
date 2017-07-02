//Hierholzer 算法： 找欧拉路,算法时间复杂度是 O(E). 其在 DFS 的过程中不用恢复边，靠出栈记录轨迹。
public class Solution {
    public List<String> findItinerary(String[][] tickets) {
        Map<String, PriorityQueue<String>> targets = new HashMap<>();
        for (String[] ticket : tickets) { // build graph
            if (!targets.containsKey(ticket[0])) {
                targets.put(ticket[0], new PriorityQueue()); // sort by lexical order 
            }
            targets.get(ticket[0]).add(ticket[1]);
        }
        LinkedList<String> route = new LinkedList();
        Stack<String> stack = new Stack<>();
        stack.push("JFK");
        while (!stack.empty()) {
            while (targets.containsKey(stack.peek()) && !targets.get(stack.peek()).isEmpty()) {
                stack.push(targets.get(stack.peek()).poll());
            } // 找到一条路，直到不能再走为止
            route.addFirst(stack.pop()); // from tail to head，pop出这个点, 再从他之前一个点开始找路
        return route;
    }
}