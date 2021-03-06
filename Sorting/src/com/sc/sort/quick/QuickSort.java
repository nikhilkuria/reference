package com.sc.sort.quick;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

import com.sc.sort.Sort;

public class QuickSort {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] input = new int[n];
		for (int i = 0; i < n; i++) {
			input[i] = in.nextInt();
		}
		sort(input, 0, input.length - 1);
		printArray(input);
	}

	private static void sort(int[] input, int low, int high) {
		if (high <= low) {
			return;
		}
		int pivotElement = partition(input, low, high);
		sort(input, low, pivotElement - 1);
		sort(input, pivotElement + 1, high);
	}

	private static int partition(int[] input, int low, int high) {
		int leftIndex = low;
		int rightIndex = high + 1;
		while (true) {

			// Move left Index towards right
			while (input[++leftIndex] < input[low]) {
				if (leftIndex == high) {
					break;
				}
			}

			// Move right Index towards left
			while (input[--rightIndex] > input[low]) {
				if (rightIndex == low) {
					break;
				}
			}

			if (leftIndex >= rightIndex) {
				break;
			}

			exch(input, leftIndex, rightIndex);
		}
		exch(input, low, rightIndex);
		return rightIndex;
	}

	private static void exch(int[] input, int from, int to) {
		int swap = input[from];
		input[from] = input[to];
		input[to] = swap;
	}

	static void printArray(int[] ar) {
		for (int n : ar) {
			System.out.print(n + " ");
		}
		System.out.println("");
	}

}
