package com.luxoft.datastructures.queue;

public interface Queue {
	void enqueue (Object value);

	Object dequeue();

	Object peek();

	int size();

	boolean isEmpty();

	boolean contains(Object value);

	void clear();

	//[a,b,c] -> size == 3
	String toString();
}
