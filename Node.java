
public class Node {// Node class for double list
	public Node prev, next;
	public Object element;
	public int index;

	public Node() {

	}

	public Node(Object element, Node prev, Node next) {
		super();
		this.prev = prev;
		this.next = next;
		this.element = element;
	}

	public Node(Object element) {
		this(element, null, null);

	}

	public Node getPrev() {
		return prev;
	}

	public void setPrev(Node prev) {
		this.prev = prev;
	}

	public Node getNext() {
		return next;
	}

	public void setNext(Node next) {
		this.next = next;
	}

	public Object getElement() {
		return element;
	}

	public void setElement(Object location) {
		this.element = element;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

}
