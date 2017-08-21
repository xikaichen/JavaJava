//Hierholzer 算法： 前提是假设图G存在欧拉回路，即有向图任意点的出度和入度相同。
// 找欧拉路,算法时间复杂度是 O(E). 
// 从任意一个起始点v开始遍历，直到再次到达点v，即寻找一个环，这会保证一定可以到达点v，因为遍历到任意一个点u，由于其出度和入度相同，故u一定存在一条出边，
// 所以一定可以到达v。将此环定义为C，如果环C中存在某个点x，其有出边不在环中，则继续以此点x开始遍历寻找环C’，
// 将环C、C’连接起来也是一个大环，如此往复，直到图G中所有的边均已经添加到环中。
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

            while (targets.containsKey(stack.peek()) && !targets.get(stack.peek()).isEmpty()) { // 没有后继点的时候targets就不contains了所以要加第一个条件，比如一条直线的最后一个node
                stack.push(targets.get(stack.peek()).poll());
            } // 找到一条路，直到不能再走为止或者成环
            route.addFirst(stack.pop()); // from tail to head，pop出这个点, 再从他之前一个点开始找路     
        }
        return route; // 不需要回到JFK的，所以不是euler回路，不过加一条边就是了 所以算法一样
    }   
}