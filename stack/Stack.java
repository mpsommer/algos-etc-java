import java.util.LinkedList;

public class Stack<T> {
	LinkedList<T> stack;

	Stack() {
		stack = new LinkedList<>();
	}
	
	void push(T e) {
		stack.push(e);
	}

	T pop() {
		return stack.pop();
	}

	boolean isEmpty() {
		return stack.isEmpty();
	}

	int size() {
		return stack.size();
	}

	T peek() {
		return stack.peek();
	}

	public static void main(String[] args) {
		Stack <Integer>stack = new Stack<>();
		stack.push(1);
		System.out.println("Popped element " + stack.pop());
		System.out.println("Is empty: " + stack.isEmpty());
		System.out.println("Size of stack " + stack.size());
		for (int i = 0; i < 5; i++) {
			stack.push(i);
		}
		System.out.println("Size of stack " + stack.size());
		System.out.println("First elem in stack " + stack.peek());
		for (int i = 0; i < 5; i++) {
			System.out.println("Popped element " + stack.pop());
		}
		System.out.println("Size of stack " + stack.size());
	}
}