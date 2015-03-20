package com.sc.maxsubarray;

import java.util.Scanner;

public class Kadane {

	public static int[] getMaxContiguous(int input[]) {
		int bestSum = 0;
		int currentSum = 0;
		int bestStartIndex = 0;
		int bestEndIndex = 0;
		int currentStartIndex = 0;

		for (int index = 0; index < input.length; index++) {
			int val = currentSum + input[index];
			if (val > 0) {
				// Means the newly found inputVal increases the sum
				if (currentSum == 0) {
					// First entry after resetting the currentSum
					currentStartIndex = index;
				}
				currentSum = val;
			} else {
				// When the currentSum is less than 0,
				// means a negative number larger than the sum calculated so far
				// is encountered
				// Reset the currentSum count
				currentSum = 0;
			}

			if (currentSum > bestSum) {
				bestStartIndex = currentStartIndex;
				bestEndIndex = index;
				bestSum = currentSum;
			}
		}
		int[] maxContiguousArray = new int[bestEndIndex - bestStartIndex + 1];
		System.arraycopy(input, bestStartIndex, maxContiguousArray, 0,
				bestEndIndex - bestStartIndex + 1);
		return maxContiguousArray;
	}

	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int testCase = in.nextInt();
		for (int testCaeIndex = 0; testCaeIndex < testCase; testCaeIndex++) {
			int inputCount = in.nextInt();
			int[] input = new int[inputCount];
			for (int inputIndex = 0; inputIndex < inputCount; inputIndex++) {
				input[inputIndex] = in.nextInt();
			}
			int[] maxContiguous = getMaxContiguous(input);

			printArraySum(maxContiguous);
			System.out.print(" ");
			printMaxNonContiguousSum(input);
			System.out.println();
		}
		in.close();
	}

	private static void printMaxNonContiguousSum(int[] input) {
		int sum = 0;
		boolean positiveFound = false;
		int maxValue = Integer.MIN_VALUE;
		for (int number : input) {
			if (number > 0) {
				positiveFound = true;
				sum = sum + number;
			}
			if (number > maxValue) {
				maxValue = number;
			}
		}
		if (positiveFound) {
			System.out.print(sum);
		} else {
			System.out.print(maxValue);
		}
	}

	private static void printArraySum(int[] maxContiguous) {

		int sum = 0;
		for (int number : maxContiguous) {
			sum = sum + number;

		}
		System.out.print(sum);
	}

}
