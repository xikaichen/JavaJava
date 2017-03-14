class LinkedListDeque <Item> { 
	//nest class
	class Node {
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
	
	private int size;
	private Node sentinel;
	Node head;
	
	public LinkedListDeque() {
		sentinel = new Node(null, null, null);  //how to initialize sentinel
		head = new Node(null, null, sentinel);
		sentinel.next = head;
		size = 0;
	}

	public LinkedListDeque(Item x){  //why I push a Node variable? Because I want to initialize head
		sentinel = new Node(x, null, null);  //how to initialize sentinel
		head = new Node(x, null, sentinel);
		sentinel.next = head;
		size = 1;
	}


	public void addFirst(Item x) {   //cannot use Node?
		Node item = new Node(x);
		item.next = head;
		item.prev = sentinel;
		head.prev = item;
		sentinel.next = item;
		size += 1;
	}

	public void addLast(Item x) {
		Node item = new Node(x);
		Node p = sentinel;
		while(p.next != null){
			p = p.next;
		}

		p.next = item;
		item.prev = p;
		size += 1;
	}

	public Item removeFirst() {
		if(size == 0) {
			return null;
		}
		Item firstRemoveElement = sentinel.next.value;
		sentinel.next = sentinel.next.next;
		if(sentinel.next.next != null) {
			sentinel.next.next.prev = sentinel;
		}
		size -= 1;
		return firstRemoveElement;
	}

	public Item removeLast() {
		if(size == 0) {
			return null;
		}

		Node p = sentinel;
		while(p.next != null){
			p = p.next;
		}

		Item lastRemoveElement = p.value;
		p.prev.next = null;
		size -= 1;
		return lastRemoveElement;
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

	public void printDeque() {
		for (int i = 0; i < size; i++) {
			System.out.println(get(i));
		}
	}

	public static void main(String[] args) {
		LinkedListDeque<Integer> list = new LinkedListDeque<Integer>(1);
		// 1 -> 2 -> 3 -> 4

		

		list.addLast(2);
		list.addLast(3);
		list.addLast(4);
		list.printDeque();

		System.out.println(list.get(0));


	}

/*
1. nest class cannot be called from outside. When define class Node in class LinkedListDeque. I cannot create
Node instance by using Node<Integer> x1 = new Node<Integer>(1);
2. use (Item) to convert Object to Item. You need use<Integer> or <String> etc.. to declare the Item type when you
create new instance. So the class know which type should be assign to Item.
*/


}