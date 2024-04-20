
public class Stack {
	private int Size;
	private NodeStack front;
	// private String input;

	public Stack() {
		front = null;
		Size = 0;
	}

	public int getSize() {
		return Size;
	}

	public void setSize(int size) {
		Size = size;
	}

	public NodeStack getFront() {
		return front;
	}

	public void setFront(NodeStack front) {
		this.front = front;
	}

	public boolean isEmpty() {// examine is empty
		return front == null;
	}

	public void push(Object element) {// add an element
		NodeStack newNode = new NodeStack(element);
		if (isEmpty())// examine is empty
			front = newNode;// if its empty then set the front as newNode

		else {// if not empty then:
			newNode.next = front;
			front = newNode;

		}
		Size++;
	}

	public Object pop() {// remove element
		if (!(isEmpty())) {
			NodeStack top = front;
			front = front.next;
			Size--;
			return top.element;
		}
		return null;
	}

	public Object peek() {// return an front element(the top)
		if (!(isEmpty())) {

			return front.element;
		}
		return null;
	}

	public int Size() {// return size of stack
		return Size;
	}

	public void printList() {// to print list
		Stack stack = new Stack();
		while (!(isEmpty())) {
			Object obj = pop();
			stack.push(obj);
			System.out.println(obj);

		}
		while (!(stack.isEmpty())) {
			push(stack.pop());
		}
	}

	/*
	 * public String printList2() { Stack tempStack = new Stack(); StringBuilder sb
	 * = new StringBuilder(); while (!isEmpty()) { Object obj = pop();
	 * tempStack.push(obj); sb.append(obj).append("\n"); } while
	 * (!tempStack.isEmpty()) { push(tempStack.pop()); } return sb.toString(); }
	 */


	public void removeElement(Object elementToRemove) {
		Stack tempStack = new Stack(); // update after discussion
		while (!isEmpty()) {
			Object obj = pop();
			if (!obj.equals(elementToRemove))

				tempStack.push(pop());

		}
		while (!tempStack.isEmpty()) {
			push(tempStack.pop());
		}
	}

	@Override
	public String toString() {
		return "Stack [Size=" + Size + ", front=" + front + "]";
	}
	

}