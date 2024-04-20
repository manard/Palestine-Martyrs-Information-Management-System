
public class CircularList {

	public NodeList front, back;
	public int size;
	public NodeList current;

	public CircularList() {
		front = back = null;
		size = 0;
	}

	public void addFirst(Object element) {
		NodeList newNode = new NodeList(element);
		if (size == 0) {
			front = back = newNode;
		} else {
			newNode.next = front;
			front.prev = newNode;
			front = newNode;
		}
		size++;
		back.next = front;
		front.prev = back;
	}

	public void addLast(Object element) {
		NodeList newNode = new NodeList(element);
		if (size == 0) {
			front = back = newNode;
		} else {
			back.next = newNode;
			newNode.prev = back;
			back = newNode;
		}
		size++;
		back.next = front;
	}

	public void add(int index, Object element) {
		if (index == 0)
			addFirst(element);
		else if (index >= size)
			addLast(element);
		else {
			NodeList newNode = new NodeList(element);
			NodeList current = front;
			for (int i = 0; i < index - 1; i++)
				current = current.next;

			newNode.next = current.next;
			newNode.prev = current;
			current.next = newNode;
			newNode.next.prev = newNode;
			size++;
		}
	}

	public void add(Object element) {
		add(size, element);
	}

	public Object getFirst() {
		if (size == 0)
			return null;
		else
			return front.element;
	}

	public Object getLast() {
		if (size == 0)
			return null;
		else
			return back.element;
	}

	public Object get(int index) {
		if (size == 0)
			return null; // empty list
		else if (index == 0)
			return getFirst(); // first element
		else if (index == size - 1)
			return getLast(); // last element
		else if (index > 0 && index < size - 1) {
			NodeList current = front;
			for (int i = 0; i < index; i++)
				current = current.next;
			return current.element;
		} else
			return null; // out of boundary
	}

	public NodeList getFirstNode() {
		if (size == 0)
			return null;
		else
			return front;
	}

	public NodeList getLastNode() {
		if (size == 0)
			return null;
		else
			return back;
	}

	public NodeList getNode(int index) {
		if (size == 0)
			return null; // empty list
		else if (index == 0)
			return getFirstNode(); // first element
		else if (index == size - 1)
			return getLastNode(); // last element
		else if (index > 0 && index < size - 1) {
			NodeList current = front;

			for (int i = 0; i < index; i++)
				current = current.next;
			return current;
		} else
			return null; // out of boundary
	}

	public boolean removeFirst() {
		if (size == 0) {
			return false;
		} else if (size == 1) {
			front = back = null;
		} else {
			front = front.next;
			front.prev = back;
			back.next = front;
		}
		size--;
		return true;
	}

	public boolean removeLast() {

		if (size == 0) {
			return false;
		} else if (size == 1) {
			front = back = null;
		} else {
			back = back.prev;
			back.next = front;
			front.prev = back;
		}
		size--;
		return true;
	}

	public boolean remove(int index) {
		if (size == 0) {
			return false;
		} else if (index == 0) {
			removeFirst();
		} else if (index == size - 1) {
			removeLast();
		} else if (index > 0 && index < size - 1) {
			NodeList current = front;
			for (int i = 0; i < index - 1; i++)
				current = current.next;

			current.next = current.next.next;
			current.next.prev = current;
			size--;
			return true;
		}
		return false;
	}

	public Object returnRemove(int index) {
		if (size == 0) {
			return null;
		} else if (index == 0) {
			NodeList current = front;
			removeFirst();
			return current.element;
		} else if (index == size - 1) {
			NodeList current = back;
			removeLast();
			return current.element;
		} else if (index > 0 && index < size - 1) {
			NodeList current1 = front, current2;
			for (int i = 0; i < index - 1; i++)
				current1 = current1.next;
			current2 = current1.next;
			current1.next = current1.next.next;
			size--;
			return current2.element;
		}
		return null;
	}

	public boolean contains(Object o) {
		for (int i = 0; i < size; i++) {
			if ((((String) get(i)).toLowerCase()).compareTo(((String) o).toLowerCase()) == 0)
				return true;
		}
		return false;
	}

	public int find(Object o) {
		for (int i = 0; i < size; i++) {
			if (get(i).equals(o)) {
				return i;
			}
		}
		return -1;
	}

	public void print() {
		System.out.println("***********");
		NodeList current = front;
		while (current != null) {
			System.out.println(current.element);
			current = current.next;
			if (current == front) { // Stop printing if we have reached the start of the list again
				System.out.println("***********");
				break;
			}
		}
	}

	public boolean isEmpty() {
		if (size == 0)
			return true;
		return false;
	}

	public int size() {
		return size;
	}

	public boolean remove(String value) {
		if (size == 0) {
			return false;
		} else if (front.element.equals(value)) {
			removeFirst();
			return true;
		} else {
			NodeList current = front;
			while (current.next != null) {
				if (current.next.element.equals(value)) {
					current.next = current.next.next;
					size--;
					return true;
				}
				current = current.next;
			}
		}
		return false;
	}

}