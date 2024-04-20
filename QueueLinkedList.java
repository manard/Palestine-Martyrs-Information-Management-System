
public class QueueLinkedList {
	public Node front;
	public Node rear;
	public int size;

	public QueueLinkedList() {
		front = rear = null;
		size = 0;

	}

	public boolean isEmpty() {// exmaine if the queue is empty
		return (front == null && rear == null);
	}

	public void enqueue(Object element) {// add element (enqueue)
		Node newNode = new Node(element);

		if (isEmpty()) {

			front = rear = newNode;
		} else {
			rear.next = newNode;
			rear = newNode;
		}
		size++;
	}

	public Object dequeue() {// remove element(dequeue)
		Object o = null;
		if (isEmpty()) {

		} else {
			if (front == rear) {
				o = front.element;
				front = rear = null;
			} else {
				o = front.element;
				front = front.next;
			}
			size--;
		}
		return o;
	}

	public Object peek() {// return an front element(front or peek)
		if (!isEmpty())
			return front.element;
		return null;
	}

	public void print() {// to print the elements in linked list implementaion using queue
		int s = size;
		;
		while (s != 0) {

			Object o = dequeue();
			System.out.println(o);
			enqueue(o);
			s--;
		}

	}

	public void clear() {// to clear all elements in linkedlist implementaion using queue
		while (!isEmpty()) {
			dequeue();
		}
	}

}
