
public class NodeAVL2 {
	DateStack dateStack;
	int height;
	NodeAVL2 left; // left child
	NodeAVL2 right; // right child

	public NodeAVL2() {
		this.dateStack = new DateStack();
	}

	public NodeAVL2(DateStack dateStack) {
		this(dateStack, null, null);
	}

	public DateStack getDateStack() {
		return dateStack;
	}

	public void setDateStack(DateStack dateStack) {
		this.dateStack = dateStack;
	}

	@Override
	public String toString() {
		return "NodeAVL2 [dateStack=" + dateStack + "]";
	}

	public NodeAVL2(DateStack dateStack, NodeAVL2 left, NodeAVL2 right) {
		this.dateStack = dateStack;
		this.left = left;
		this.right = right;
		this.height = 0;
	}

	public NodeAVL2 getLeft() {
		return left;
	}

	public void setLeft(NodeAVL2 left) {
		this.left = left;
	}

	public NodeAVL2 getRight() {
		return right;
	}

	public void setRight(NodeAVL2 right) {
		this.right = right;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

}
