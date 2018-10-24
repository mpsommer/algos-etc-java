import java.util.LinkedList;

public class Queue<T> {
	LinkedList<T> queue;

	Queue() {
		queue = new LinkedList<>();
	}

	void enqueue(T e) {
		queue.add(e);
		// queue.push(e);
	}

	T dequeue() {
		return queue.remove();
	}

	T peek() {
		return queue.peek();
	}

	int size() {
		return queue.size();
	}
	public static void main(String[] args) {
		Queue<Integer> queue = new Queue<>();
		for (int i = 1; i < 6; i++) {
			queue.enqueue(i);
		}
		System.out.println("queue.size() " + queue.size());
		System.out.println("queue.peek() " + queue.peek());

		for (int i = 0; i < 5; i++) {
			System.out.println("dequeued elem:" + queue.dequeue());
		}
		System.out.println("queue.size() " + queue.size());
		System.out.println("queue.peek() " + queue.peek());
	}
}