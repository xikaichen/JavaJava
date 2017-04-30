public class Node {
	public static class ListNode{
		int val;
		ListNode next;
		public ListNode(int val, ListNode next) {
			this.val = val;
			this.next = next;
		}
	}

	private static void show(ListNode node) {
		System.out.println(node.val + "   " + node.next.val);
	}

	public static void main(String[] args) {
		ListNode node1 = new ListNode(1, null);
		ListNode node2 = new ListNode(2, null);
		ListNode node3 = new ListNode(3, null);
		ListNode node4 = new ListNode(4, null);
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;

		
		node1 = node2;
		ListNode node = node1;

		show(node);




	}
}