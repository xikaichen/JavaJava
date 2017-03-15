class ArrayDeque <Item>{
	private int size;   //must use private? i think not
	private Item[] array;
	private int capacity;


	public ArrayDeque() {
		size = 0;
		capacity = 8;
		array = (Item[]) new Object[capacity];
	}

	public void add(Item x) {
		if(size >= capacity) {
			resize(capacity);
			capacity *= 2;
		}
		array[size] = x;
	}

	public void remove() {
		array[size - 1] = null;
		size -= 1;
	}

	public Item get(int index) { //not consider the case index >= size. should throw an exception 
		return (Item) array[index];
	}

	private void resize(int capacity) {
		Item[] a = (Item[]) new Object[capacity * 2];
		System.arraycopy(array, 0, a, 0, size);
		array = a;
	}

	public int size() {
		return size;
	}

	//public void insert(int index, int x){}   TODO
}

