package com.sc.sort.selection;

import java.util.Comparator;

import com.sc.sort.Sort;

public class SelectionSort extends Sort{

	@Override
	public void sort(Comparable<Object>[] input) {
        for (int currentElement = 0; currentElement < input.length; currentElement++) {
            int min = currentElement;
            for (int minElement = currentElement+1; minElement < input.length; minElement++) {
                if (less(input[minElement], input[min])) {
                	min = minElement;
                }
            }
            exch(input, currentElement, min);
        }
	}

	@Override
	public void sort(Object[] input, Comparator<Object> comparator) {
        for (int currentElement = 0; currentElement < input.length; currentElement++) {
            int min = currentElement;
            for (int minElement = currentElement+1; minElement < input.length; minElement++) {
                if (less(comparator, input[minElement], input[min])){
                	min = minElement;
                }
            }
            exch(input, currentElement, min);
        }
	}

}
