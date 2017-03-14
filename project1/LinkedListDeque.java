class Node <Item> {
	Item value;
	Node next;
	Node prev;


	public Node(Item v) {
		value = v;
		next = null;
		prev = null;
	}

	public Node(Item v, Node n, Node p) {
		value = v;
		next = n;
		prev = p;
	}
}
class LinkedListDeque <Item> { 
	
	private int size;
	private Node sentinel;
	Node head;
	
	public LinkedListDeque(Item x){  //why I push a Node variable? Because I want to initialize head
		sentinel = new Node(x, null, null);  //how to initialize sentinel
		head = new Node(x, null, sentinel);
		sentinel.next = head;
		size = 1;
	}


	public void addFirst(Node item) {   //cannot use Node?
		// Node<Integer> item = new Node<Integer>(x);
		item.next = head;
		item.prev = sentinel;
		head.prev = item;
		sentinel.next = item;
		size += 1;
	}

	public void addLast(Node item) {
		//Node<Integer> item = new Node<Integer>(x);
		Node p = sentinel;
		while(p.next != null){
			p = p.next;
		}

		p.next = item;
		item.prev = p;
		size += 1;
	}

	public boolean isEmpty() {
		if(size == 0){
			return true;
		}
		else {
			return false;
		}
	}

	public int size() {
		return size;
	}

	public Item get(int index) {
		if(index > size - 1) {
			return null;
		}

		Node temp = head;
		while(index > 0) {	
			index -= 1;
			temp = temp.next;
		}

		return (Item) temp.value;
	}

	public static void main(String[] args) {
		LinkedListDeque<Integer> list = new LinkedListDeque<Integer>(1);

		Node<Integer> x1 = new Node<Integer>(2);
		Node<Integer> x2 = new Node<Integer>(3);
		Node<Integer> x3 = new Node<Integer>(4);

		list.addLast(x1);
		list.addLast(x2);
		list.addFirst(x3);

		System.out.println(list.get(2));


	}

/*
1. nest class cannot be called from outside. When define class Node in class LinkedListDeque. I cannot create
Node instance by using Node<Integer> x1 = new Node<Integer>(1);
2. use (Item) to convert Object to Item. You need use<Integer> or <String> etc.. to declare the Item type when you
create new instance. So the class know which type should be assign to Item.
*/


}