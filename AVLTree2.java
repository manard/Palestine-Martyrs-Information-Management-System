import java.text.SimpleDateFormat;
import java.util.Date;

public class AVLTree2 {
	private NodeAVL2 root;
	private int maxMartyrs = 0;
	private Date dateWithMaxMartyrs;

	public AVLTree2() {
		root = null;
	}

	private int height(NodeAVL2 e) {
		if (e == null)
			return -1;
		return e.height;
	}

	private NodeAVL2 rotateWithLeftChild(NodeAVL2 k2) {
		NodeAVL2 k1 = k2.left;
		k2.left = k1.right;
		k1.right = k2;
		k2.height = Math.max(height(k2.left), height(k2.right)) + 1;
		k1.height = Math.max(height(k1.left), k2.height) + 1;
		return k1;
	}

	private NodeAVL2 rotateWithRightChild(NodeAVL2 k1) {
		NodeAVL2 k2 = k1.right;
		k1.right = k2.left;
		k2.left = k1;
		k1.height = Math.max(height(k1.left), height(k1.right)) + 1;
		k2.height = Math.max(height(k2.right), k1.height) + 1;
		return k2;
	}

	private NodeAVL2 DoubleWithLeftChild(NodeAVL2 k3) {
		k3.left = rotateWithRightChild(k3.left);
		return rotateWithLeftChild(k3);
	}

	private NodeAVL2 DoubleWithRightChild(NodeAVL2 k1) {
		k1.right = rotateWithLeftChild(k1.right);
		return rotateWithRightChild(k1);
	}

	private NodeAVL2 findMinimum(NodeAVL2 node) {
		if (node.left == null) {
			return node;
		}
		return findMinimum(node.left);
	}

	private NodeAVL2 balance(NodeAVL2 node) {
		if (node == null) {
			return null;
		}

		int balanceFactor = getBalanceFactor(node);

		if (balanceFactor > 1) {
			if (getBalanceFactor(node.left) >= 0) {
				// Left-Left case
				return rotateWithLeftChild(node);
			} else {
				// Left-Right case
				return DoubleWithLeftChild(node);
			}
		} else if (balanceFactor < -1) {
			if (getBalanceFactor(node.right) <= 0) {
				// Right-Right case
				return rotateWithRightChild(node);
			} else {
				// Right-Left case
				return DoubleWithRightChild(node);
			}
		}

		return node;
	}

	private int getBalanceFactor(NodeAVL2 node) {
		if (node == null) {
			return 0;
		}
		return height(node.left) - height(node.right);

	}

	private void preOrder(NodeAVL2 root) {
		if (root != null) {
			System.out.print(" " + root);
			preOrder(root.left);
			preOrder(root.right);
		}
	}

	public void preOrder() {
		if (root != null) {
			preOrder(root);
		} else {
			// Handle the case when the root is null
			System.out.println("The AVL tree is empty.");
		}
	}

	private void inOrder(NodeAVL2 root) {
		if (root != null) {
			inOrder(root.left);
			System.out.println(" " + root);
			inOrder(root.right);
		}
	}

	public void inOrder() {
		if (root != null) {
			inOrder(root);
		} else {
			System.out.println("The AVL tree is empty");
		}
	}

	private NodeAVL2 insert(NodeAVL2 node, DateStack dateStack) {
		if (node == null) {
			return new NodeAVL2(dateStack);
		}

		int compareResult = dateStack.getDate().compareTo(node.dateStack.getDate());

		if (compareResult < 0) {
			node.left = insert(node.left, dateStack);
		} else if (compareResult > 0) {
			node.right = insert(node.right, dateStack);
		} else {
			// Dates are equal, push the martyr pointer stack to the existing DateStack
			node.dateStack.getStack().push((Stack) dateStack.getStack());
		}

		// Update the height of the current node
		node.height = Math.max(height(node.left), height(node.right)) + 1;

		// Balance the AVL tree if necessary
		node = balance(node);

		return node;
	}

	public void insert(DateStack dateStack) {
		root = insert(root, dateStack);

	}

	private void printInOrder(NodeAVL2 node) {
		if (node != null) {
			printInOrder(node.left);
			System.out.println(node.dateStack); // Print the node's data
			printInOrder(node.right);
		}
	}

	// Call this method to print the elements in the AVLTree
	public void printInOrder() {
		printInOrder(root);

	}

	public NodeAVL2 find(Martyrobject martyrs) {
		return find(martyrs, root);
	}

	private NodeAVL2 find(Martyrobject martyrs, NodeAVL2 current) {
		if (current == null) {
			return null;
		}
		if (martyrs.getDateOfDeth().before(current.getDateStack().getDate())) {
			return find(martyrs, current.left);
		} else if (martyrs.getDateOfDeth().after(current.getDateStack().getDate())) {
			return find(martyrs, current.right);
		} else {
			return current;
		}
	}

	public NodeAVL2 getNodeByDate(Date targetDate) {
		return getNodeByDate(root, targetDate);
	}

	private NodeAVL2 getNodeByDate(NodeAVL2 node, Date targetDate) {
		if (node == null || node.getDateStack().getDate().equals(targetDate)) {
			return node;
		}

		if (targetDate.compareTo(node.getDateStack().getDate()) < 0) {
			return getNodeByDate(node.getLeft(), targetDate);
		}

		return getNodeByDate(node.getRight(), targetDate);
	}

	private void Printreverse(NodeAVL2 node, StringBuilder sb) {
		if (node != null) {
			Printreverse(node.right, sb);
			sb.append(node.dateStack.toString()).append("\n"); // Assuming the `Martyrobject` class has a suitable
																// `toString()` method
			Printreverse(node.left, sb);
		}
	}

	public String printReverse() {
		StringBuilder sb = new StringBuilder();
		Printreverse(root, sb);
		return sb.toString();
	}

	public int getHeight() {
		return getHeight(root);
	}

	private int getHeight(NodeAVL2 node) {
		if (node == null) {
			return -1; // Height of an empty subtree is -1
		}

		int leftHeight = getHeight(node.left);
		int rightHeight = getHeight(node.right);

		return Math.max(leftHeight, rightHeight) + 1;
	}

	private Date Date(NodeAVL2 node, Date max, int maxMartyrs) {
		if (node == null) {
			return max;
		}

		int numMartyrs = node.dateStack.getStack().getSize();
		if (numMartyrs > maxMartyrs) {
			maxMartyrs = numMartyrs;
			max = node.dateStack.getDate();
		}

		Date leftMaxDate = Date(node.left, max, maxMartyrs);
		Date rightMaxDate = Date(node.right, max, maxMartyrs);

		// Return the date with the maximum number of martyrs among the current node,
		// left subtree, and right subtree
		return getDate(max, getDate(leftMaxDate, rightMaxDate));
	}

	// Method to get the date with the maximum number of martyrs
	public Date getDateMartyrs() {
		return Date(root, null, 0);
	}

	// Helper method to get the date with the maximum number of martyrs
	private Date getDate(Date date1, Date date2) {
		if (date1 == null) {
			return date2;
		} else if (date2 == null) {
			return date1;
		}

		return date1.after(date2) ? date1 : date2;
	}
}
