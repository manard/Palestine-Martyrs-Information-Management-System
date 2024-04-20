
public class AVLTree {

	private NodeAVL root;

	public AVLTree() {
		root = null;
	}

	private int height(NodeAVL e) {
		if (e == null)
			return -1;
		return e.height;
	}

	private NodeAVL rotateWithLeftChild(NodeAVL k2) {
		NodeAVL k1 = k2.left;
		k2.left = k1.right;
		k1.right = k2;
		k2.height = Math.max(height(k2.left), height(k2.right)) + 1;
		k1.height = Math.max(height(k1.left), k2.height) + 1;
		return k1;
	}

	private NodeAVL rotateWithRightChild(NodeAVL k1) {
		NodeAVL k2 = k1.right;
		k1.right = k2.left;
		k2.left = k1;
		k1.height = Math.max(height(k1.left), height(k1.right)) + 1;
		k2.height = Math.max(height(k2.right), k1.height) + 1;
		return k2;
	}

	private NodeAVL DoubleWithLeftChild(NodeAVL k3) {
		k3.left = rotateWithRightChild(k3.left);
		return rotateWithLeftChild(k3);
	}

	private NodeAVL DoubleWithRightChild(NodeAVL k1) {
		k1.right = rotateWithLeftChild(k1.right);
		return rotateWithRightChild(k1);
	}

	public void insert(int element) {
		root = insert(element, root);
	}

	private NodeAVL insert(int element, NodeAVL node) {
		if (node == null) {
			return new NodeAVL(element);
		}

		if (element < node.element) {
			node.left = insert(element, node.left);
		} else if (element > node.element) {
			node.right = insert(element, node.right);
		} else {
			// Duplicate elements are not allowed in AVL trees
			return node;
		}

		node.height = Math.max(height(node.left), height(node.right)) + 1;

		return balance(node);
	}

	public void remove(int element) {
		root = remove(element, root);
	}

	private NodeAVL remove(int element, NodeAVL node) {
		if (node == null) {
			return null;
		}

		if (element < node.element) {
			node.left = remove(element, node.left);
		} else if (element > node.element) {
			node.right = remove(element, node.right);
		} else {
			// Found the node to be removed
			if (node.left == null && node.right == null) {
				// Case 1: Node is a leaf
				return null;
			} else if (node.left == null) {
				// Case 2: Node has only a right child
				return node.right;
			} else if (node.right == null) {
				// Case 2: Node has only a left child
				return node.left;
			} else {
				// Case 3: Node has both left and right children
				NodeAVL successor = findMinimum(node.right);
				node.element = successor.element;
				node.right = remove(successor.element, node.right);
			}
		}

		node.height = Math.max(height(node.left), height(node.right)) + 1;

		return balance(node);
	}

	private NodeAVL findMinimum(NodeAVL node) {
		if (node.left == null) {
			return node;
		}
		return findMinimum(node.left);
	}

	private NodeAVL balance(NodeAVL node) {
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

	private int getBalanceFactor(NodeAVL node) {
		if (node == null) {
			return 0;
		}
		return height(node.left) - height(node.right);

	}

	private void preOrder(NodeAVL root) {
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

	private void inOrder(NodeAVL root) {
		if (root != null) {
			inOrder(root.left);
			System.out.print(" " + root);
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

	private NodeAVL insert(String name, NodeAVL node) {
		if (node == null) {
			return new NodeAVL(name);
		}

		int comparisonResult = name.compareTo(node.name);

		if (comparisonResult < 0) {
			node.left = insert(name, node.left);
		} else if (comparisonResult > 0) {
			node.right = insert(name, node.right);
		} else {
			// Duplicate names are not allowed in AVL trees
			return node;
		}

		node.height = Math.max(height(node.left), height(node.right)) + 1;

		return balance(node);
	}

	public void insert(String name) {
		root = insert(name, root);
	}

	private NodeAVL insert(Martyrobject element, NodeAVL node) {
		if (node == null) {
			return new NodeAVL(element);
		}

		// Compare data using appropriate comparison logic for your objects
		else {
			int Result = element.getName().compareTo((node.obj).getName());

			if (Result < 0) {
				node.left = insert(element, node.left);
			} else if (Result > 0) {
				node.right = insert(element, node.right);
			} else {
				// Handle the case of duplicate objects if needed
				return node;
			}

			node.height = Math.max(height(node.left), height(node.right)) + 1;

			return balance(node);
		}
	}

	public void insert(Martyrobject element) {
		root = insert(element, root);
	}

	private void printInOrder(NodeAVL node) {
		if (node != null) {
			printInOrder(node.left);
			System.out.println(node.obj); // Assuming the `Martyrobject` class has a suitable `toString()` method
			printInOrder(node.right);
		}
	}

	// Usage:
//	avlTree.printInOrder(avlTree.getRoot());
	public void printInOrder() {
		if (root != null) {
			printInOrder(root);
		} else {
			System.out.println("The AVL tree is empty");
		}
	}

	public NodeAVL find(String name) {
		return find(root, name);
	}

	private NodeAVL find(NodeAVL node, String name) {
		if (node == null) {
			// The name is not found in the tree
			return null;
		}

		int compareResult = name.compareTo(node.getObj().getName());

		if (compareResult == 0) {
			// Found the node with the desired name
			return node;
		} else if (compareResult < 0) {
			// Search in the left subtree
			return find(node.getLeft(), name);
		} else {
			// Search in the right subtree
			return find(node.getRight(), name);
		}
	}

	public int Size() {
		return Size(root);
	}

	private int Size(NodeAVL node) {
		if (node == null) {
			return 0;
		}

		int leftCount = Size(node.left);
		int rightCount = Size(node.right);

		// Add 1 for the current node
		return leftCount + rightCount + 1;
	}

	public String getLevelByLevelRepresentation() {
		if (root == null) {
			return "The AVL tree is empty.";
		}

		StringBuilder sb = new StringBuilder();
		QueueLinkedList queue = new QueueLinkedList();
		queue.enqueue(root);

		while (!queue.isEmpty()) {
			int levelSize = queue.size;

			for (int i = 0; i < levelSize; i++) {
				NodeAVL node = (NodeAVL) queue.dequeue();
				sb.append(node).append(" "); // Assuming the `NodeAVL` class has a suitable `toString()` method

				if (node.left != null) {
					queue.enqueue(node.left);
				}

				if (node.right != null) {
					queue.enqueue(node.right);
				}
			}

			sb.append("\n"); // Move to the next line after printing each level
		}

		return sb.toString();
	}

	private String printInOrder2(NodeAVL node) {
		StringBuilder sb = new StringBuilder();
		if (node != null) {
			sb.append(printInOrder2(node.left));
			sb.append(node.obj.toString()).append("\n"); // Assuming the `Martyrobject` class has a suitable
															// `toString()` method
			sb.append(printInOrder2(node.right));
		}
		return sb.toString();
	}

	// String result = avlTree.printInOrder();
	public String printInOrder2() {
		if (root != null) {
			return printInOrder2(root);
		} else {
			return "The AVL tree is empty";
		}
	}

	public int getHeight() {
		return getHeight(root);
	}

	private int getHeight(NodeAVL node) {
		if (node == null) {
			return -1; // Height of an empty subtree is -1
		}

		int leftHeight = getHeight(node.left);
		int rightHeight = getHeight(node.right);

		return Math.max(leftHeight, rightHeight) + 1;
	}

	public Martyrobject getMartyr(int i) {
		NodeAVL node = get(root, i);
		return (node != null) ? node.obj : null;
	}

	private NodeAVL get(NodeAVL node, int i) {
		int leftSize = Size(node.left);
		if (i == leftSize) {
			// Found the node at the current position
			return node;
		} else if (i < leftSize) {
			// Search in the left subtree
			return get(node.left, i);
		} else {
			// Search in the right subtree
			return get(node.right, i - leftSize - 1);
		}
	}

	public void remove2(Martyrobject element) {
		root = remove2(element, root);
	}

	private NodeAVL remove2(Martyrobject element, NodeAVL node) {
		if (node == null) {
			return null;
		}

		// Standard comparison using `compareTo` method
		int comparisonResult = element.getName().compareTo(node.obj.getName());

		if (comparisonResult < 0) {
			node.left = remove2(element, node.left);
		} else if (comparisonResult > 0) {
			node.right = remove2(element, node.right);
		} else {
			// Found the node to be removed
			if (node.left == null && node.right == null) {
				// Case 1: Node is a leaf
				return null;
			} else if (node.left == null) {
				// Case 2: Node has only a right child
				return node.right;
			} else if (node.right == null) {
				// Case 2: Node has only a left child
				return node.left;
			} else {
				// Case 3: Node has both left and right children
				NodeAVL successor = findMinimum(node.right);
				node.obj = successor.obj;
				node.right = remove2(successor.obj, node.right);
			}
		}

		node.height = Math.max(height(node.left), height(node.right)) + 1;

		return balance(node);
	}

}
