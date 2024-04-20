
public class NodeAVL {
	int element; // store data
	NodeAVL left; // left child
	NodeAVL right; // right child
	int height; // Height
	String name;
	public Martyrobject obj;

	public NodeAVL(Martyrobject obj) {
		this.obj = obj;
		this.left = null;
		this.right = null;
		this.height = 0;
	}

	public NodeAVL(int element) {
		this(element, null, null);
	}

	public NodeAVL(int element, NodeAVL left, NodeAVL right) {
		this.element = element;
		this.left = left;
		this.right = right;
		this.height = 0;
	}

	public NodeAVL(String name) {
		this(name, null, null);
	}

	public NodeAVL(String name, NodeAVL left, NodeAVL right) {
		this.name = name;
		this.left = left;
		this.right = right;
		this.height = 0;
	}

	public int getElement() {
		return element;
	}

	public void setElement(int element) {
		this.element = element;
	}

	public NodeAVL getLeft() {
		return left;
	}

	public void setLeft(NodeAVL left) {
		this.left = left;
	}

	public NodeAVL getRight() {
		return right;
	}

	public void setRight(NodeAVL right) {
		this.right = right;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Martyrobject getObj() {
		return obj;
	}

	public void setObj(Martyrobject obj) {
		this.obj = obj;
	}

	@Override
	public String toString() {
		return "" + name + "";
	}

}
