

public  class LC0622_DesignCircularQueue {
	public int[] queue;
	public int head, tail, size, limit;
	public LC0622_DesignCircularQueue(int k) {
		queue = new int[k];
		head = tail = size = 0;
		limit = k;
	}

	public boolean enQueue(int value) {
		if(isFull()) return false;
		// not full add to tail
		queue[tail] = value;
		tail = tail == (limit -1) ? 0 : (tail + 1);
		size++;
		return true;
	}

	public boolean deQueue() {
		if(isEmpty()) return false;
		head = head == (limit - 1) ? 0 : (head + 1);
		size--;
		return true;
	}

	public int Front() {
		if(isEmpty()) return -1;
		return queue[head];
	}

	public int Rear() {
		if(isEmpty()) return -1;
		int last = tail == 0 ? (limit - 1) : (tail - 1);
		return queue[last];
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public boolean isFull() {
		return size == limit;
	}
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */