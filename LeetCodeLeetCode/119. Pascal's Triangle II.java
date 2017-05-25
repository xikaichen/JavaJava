public class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> list = new LinkedList<Integer>();
        for (int i = 0; i < rowIndex; i++) {
            list.add(0);
        }
        list.add(1);
        for (int i = rowIndex - 1; i >= 0; i--) { // update from tail to head
            for (int j = i; j < rowIndex; j++) { // add from current to tail
                list.set(j, list.get(j) + list.get(j + 1));
            }
        }
        return list;
    }
}


