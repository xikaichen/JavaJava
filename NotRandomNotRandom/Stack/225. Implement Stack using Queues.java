public class MyStack {

    /** Initialize your data structure here. */
    private Queue<Integer> queue1;
    private Queue<Integer> queue2;
    public MyStack() {
        queue1 = new LinkedList<Integer>();  //  basic idea: use two queue, one of them only contains the element just pushed in.
        queue2 = new LinkedList<Integer>();
    }
    
    /** Push element x onto stack. */
    public void push(int x) {
        if (queue1.size() == 0) {
            queue1.offer(x);
        } else {
            while (!queue1.isEmpty()) { // 把queue1弹空，再加新的数，始终保持queue1只有一个数
                queue2.offer(queue1.poll());
            }
            queue1.offer(x);
        }
    }
    
    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        if (queue1.isEmpty()) {
            return -1;
        }
        int top = queue1.poll();
        while (queue2.size() > 1) {
            queue1.offer(queue2.poll());
        }
        Queue<Integer> temp = new LinkedList<Integer>();
        temp = queue1;
        queue1 = queue2;
        queue2 = temp;
        return top;
    }
    
    /** Get the top element. */
    public int top() {
        if (queue1.isEmpty()) {
            return -1;
        }
        return queue1.peek();
    }
    
    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queue1.isEmpty() && queue2.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */