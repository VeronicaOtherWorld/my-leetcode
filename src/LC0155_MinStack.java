import java.util.Stack;

public class LC0155_MinStack {
	class MinStack {
		public Stack<Integer> data;
		public Stack<Integer> min;

		public MinStack() {
			data = new Stack<Integer>();
			min = new Stack<Integer>();
		}

		public void push(int val) {
			// first add into data
			data.push(val);
			// if the min is empty, same as data stack
			// or the val is smaller than the top of the min. same as data stack
			if(min.isEmpty() || val < min.peek()){
				min.push(val);
			} else {
				min.push(min.peek());
			}
		}

		public void pop() {
			data.pop();
			min.pop();
		}

		public int top() {
			return data.peek();
		}

		public int getMin() {
			return min.peek();
		}
	}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
}
