
public class NodeStack {
	public NodeStack prev, next;
	public Object element;
	public int index;
	
	public NodeStack() {

	}

	public NodeStack(Object element, NodeStack prev, NodeStack next) {
		super();
		this.prev = prev;
		this.next = next;
		this.element = element;
	}

	public NodeStack(Object element) {
		this(element, null, null);

	}

	public NodeStack getPrev() {
		return prev;
	}

	public void setPrev(NodeStack prev) {
		this.prev = prev;
	}

	public NodeStack getNext() {
		return next;
	}

	public void setNext(NodeStack next) {
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