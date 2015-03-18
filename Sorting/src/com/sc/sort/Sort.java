package com.sc.sort;

import java.util.Comparator;

public abstract class Sort {

	public abstract void sort(Comparable<Object>[] input);

	public abstract void sort(Object[] input, Comparator<Object> comparator);

	protected boolean less(Comparable<Object> v, Comparable<Object> w) {
		return (v.compareTo(w) < 0);
	}

	protected boolean less(Comparator<Object> comparator, Object v, Object w) {
		return (comparator.compare(v, w) < 0);
	}

	protected void exch(Object[] input, int from, int to) {
		Object swap = input[from];
		input[from] = input[to];
		input[to] = swap;
	}

}
