import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class LC_225_232_ConvertQueueAndStack {
	class MyQueue {
		public Stack<Integer> in;
		public Stack<Integer> out;
		public MyQueue() {
			in = new Stack<Integer>();
			out = new Stack<Integer>();
		}

		private void intoout(){
			if(out.empty()){
				while(!in.empty()){
					out.push(in.pop());
				}
			}
		}

		public void push(int x) {
			in.push(x);
			intoout();
		}

		public int pop() {
			intoout();
			return out.pop();
		}

		public int peek() {
			intoout();
			return out.peek();
		}

		public boolean empty() {
			return in.isEmpty() && out.isEmpty();
		}
	}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */

class MyStack {
	public Queue<Integer> queue;
	public MyStack() {
		queue = new LinkedList<>();
	}

	public void push(int x) {
		int n = queue.size();
		queue.offer(x);
		for(int i = 0; i < n; i++){
			queue.offer(queue.poll());
		}
	}

	public int pop() {
		return queue.poll();
	}

	public int top() {
		return queue.peek();
	}

	public boolean empty() {
		return queue.isEmpty();
	}
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */

}
