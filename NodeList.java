
public class NodeList {// Node class for C list

	public Object element;
	public NodeList next;
	public NodeList prev;
	public String k;
	public AVLTree AVLList1 = new AVLTree();
	public AVLTree2 AVLList2 = new AVLTree2();
	public NodeList current;
	public NodeList() {

	}

	public NodeList(Object element) {
		this(element, null, null);
	}

	public NodeList(Object element, NodeList next, NodeList prev) {
		this.element = element;
		this.next = next;
		this.prev = prev;
	}

	public Object getElement() {
		return element;
	}

	public void setElement(Object element) {
		this.element = element;
	}

	public NodeList getNext() {
		return next;
	}

	public void setNext(NodeList next) {
		this.next = next;
	}

	public NodeList getPrev() {
		return prev;
	}

	public void setPrev(NodeList prev) {
		this.prev = prev;
	}

	public AVLTree getAVLList1() {
		return AVLList1;
	}

	public void setAVLList1(AVLTree aVLList1) {
		AVLList1 = aVLList1;
	}

	public void insert(Martyrobject M) {
		AVLList1.insert(M);

	}

	public AVLTree2 getAVLList2() {
		return AVLList2;
	}

	public void setAVLList2(AVLTree2 aVLList2) {
		AVLList2 = aVLList2;
	}
	

}
