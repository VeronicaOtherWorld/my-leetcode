import java.util.Deque;
import java.util.LinkedList;

// 使用双端队列 double ended queue
// 使用固定数组 来实现双端队列
// 数组的大小为 k， 数组的头部为 l， 数组的尾部为 r
// 数组的元素个数为 size
// 数组的头部 l 指向数组的第一个元素， 数组的尾部 r 指向数组的最后一个元素
// 当 size == k 时， 队列满
// 当 size == 0 时， 队列空
// 插入元素时， 若队列满， 返回 false； 否则， 若队列为空， 则 l = r = 0， 并将 value 存入数组的第一个元素； 否则， 若 l == 0， 则 l = k - 1； 否则， l--， 并将 value 存入数组的 l 位置； 最后， size++， 返回 true
// 删除元素时， 若队列为空， 返回 false； 否则， 若 l == r， 则 l = r = 0， 并将数组的第一个元素置为 0； 否则， 若 l == 0， 则 l = k - 1； 否则， l++， 并将数组的 l 位置置为 0； 最后， size--， 返回 true
// 获取元素时， 若队列为空， 返回 -1； 否则， 返回数组的 l 位置的元素

public class LC0641_DesignCircularDeque {
	class MyCircularDeque {
		public Deque<Integer> deque;
		public int size;
		public int limit;
		public MyCircularDeque(int k) {
			deque = new LinkedList<Integer>();
			size = 0;
			limit = k;
		}

		public boolean insertFront(int value) {
			if(isFull()) return false;
			deque.offerFirst(value);
			size++;
			return true;
		}

		public boolean insertLast(int value) {
			if(isFull()) return false;
			deque.offerLast(value);
			size++;
			return true;
		}

		public boolean deleteFront() {
			if(isEmpty()) return false;
			deque.pollFirst();
			size--;
			return true;
		}

		public boolean deleteLast() {
			if(isEmpty()) return false;
			deque.pollLast();
			size--;
			return true;
		}

		public int getFront() {
			if(isEmpty()) return -1;
			return deque.peekFirst();
		}

		public int getRear() {
			if(isEmpty()) return -1;
			return deque.peekLast();
		}

		public boolean isEmpty() {
			return size == 0;
		}

		public boolean isFull() {
			return size == limit;
		}
	}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */

class MyCircularDeque2 {
	int[] deque;
	int l ,r, size, k;

	public MyCircularDeque2(int k) {
		deque = new int[k];
		l = r = size = 0;
		this.k = k;
	}

	public boolean insertFront(int value) {
		if(isFull()) return false;
		if(isEmpty()){
			l = r = 0;
			deque[0] = value;
		} else {
			l = l == 0 ? (k - 1) : (l -1);
			deque[l] = value;
		}
		size++;
		return true;
	}

	public boolean insertLast(int value) {
		if(isFull()) return false;
		if(isEmpty()){
			l = r = 0;
			deque[0] = value;
		} else {
			r = r == (k - 1) ? 0 : (r + 1);
			deque[r] = value;
		}
		size++;
		return true;
	}

	public boolean deleteFront() {
		if(isEmpty()) return false;
		l = l == (k - 1) ? 0 : (l + 1);
		size--;
		return true;
	}

	public boolean deleteLast() {
		if(isEmpty()) return false;
		r = r == 0 ? (k -1) : (r - 1);
		size--;
		return true;
	}

	public int getFront() {
		if(isEmpty()) return -1;
		return deque[l];
	}

	public int getRear() {
		if(isEmpty()) return -1;
		return deque[r];
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public boolean isFull() {
		return size == k;
	}
}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */
}
