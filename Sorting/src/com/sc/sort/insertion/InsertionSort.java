package com.sc.sort.insertion;

import java.util.Comparator;

import com.sc.sort.Sort;

//Efficient for partially sorted arrays
public class InsertionSort extends Sort {

	@Override
	public void sort(Comparable<Object>[] input) {
		for (int sortElementIndex = 0; sortElementIndex < input.length; sortElementIndex++) {
			for (int index = sortElementIndex; index > 0
					&& less(input[index], input[index - 1]); index--) {
				exch(input, index, index - 1);
			}
		}

	}

	@Override
	public void sort(Object[] input, Comparator<Object> comparator) {
		for (int sortElementIndex = 0; sortElementIndex < input.length; sortElementIndex++) {
			for (int index = sortElementIndex; index > 0
					&& less(comparator, input[index], input[index - 1]); index--) {
				exch(input, index, index - 1);
			}
		}
	}

}
