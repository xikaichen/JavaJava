public class Solution {
    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
        //build graph, using two hashmap, one for nodes, one for weights
        HashMap<String, LinkedList<String>> nodes = new HashMap<String, LinkedList<String>>();
        HashMap<String, LinkedList<Double>> weights = new HashMap<String, LinkedList<Double>>();
        for (int i = 0; i < equations.length; i++) {
            String[] curStr = equations[i];
            if (!nodes.containsKey(curStr[0])) {
                nodes.put(curStr[0], new LinkedList<String>());
                weights.put(curStr[0], new LinkedList<Double>());
            }
            if (!nodes.containsKey(curStr[1])) {
                nodes.put(curStr[1], new LinkedList<String>());
                weights.put(curStr[1], new LinkedList<Double>());
            }
            nodes.get(curStr[0]).add(curStr[1]);
            weights.get(curStr[0]).add(values[i]);
            nodes.get(curStr[1]).add(curStr[0]);
            weights.get(curStr[1]).add(1 / values[i]);
        }
        
        // Do DFS to every query
        double[] res = new double[queries.length];
        for (int i = 0; i < queries.length; i++) {
            String[] query = queries[i];
            res[i] = DFS(query[0], query[1], nodes, weights, new HashSet<String>(), 1.0);
            if (res[i] == 0.0) {
                res[i] = -1.0;
            }
        }
        return res;
    }
    
    private double DFS(String start, String end, 
                    HashMap<String, LinkedList<String>> nodes, 
                    HashMap<String, LinkedList<Double>> weights,
                    HashSet<String> set, double value) {
                        if (set.contains(start) || !nodes.containsKey(start)) {
                            return 0.0;
                        }
                        if (start.equals(end)) {
                            return value;
                        }
        				set.add(start);
        				double temp = 0.0;
                        LinkedList<String> neighbors = nodes.get(start);
                        LinkedList<Double> dist = weights.get(start);
                        for (int i = 0; i < neighbors.size(); i++) {
                            String str = neighbors.get(i);
                            temp = DFS(str, end, nodes, weights, set, value * dist.get(i));
                            if (temp != 0.0) {
                                return temp;
                            }
                        }
                        return 0.0;
                    }
}