package com.sc.sort.quick;

import java.util.Scanner;

public class QuickSortHackerRank {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] input = new int[n];
		for (int i = 0; i < n; i++) {
			input[i] = in.nextInt();
		}
		sort(input,0,input.length-1);

		in.close();
	}

	private static void sort(int[] input,int lowPointer,int pivotCandidateIndex) {
		if(lowPointer>=pivotCandidateIndex){
			return;
		}
			int pivotIndex = partition(input,lowPointer,pivotCandidateIndex);
			sort(input,lowPointer,pivotIndex-1);
			sort(input,pivotIndex+1,pivotCandidateIndex);

	}

	private static int partition(int[] input, int lowPointer,
			int pivotCandidateIndex) {
		int lowIndex = lowPointer-1;
		int highIndex = lowPointer-1;
		
		while(true){
			
			while(input[++highIndex]<input[pivotCandidateIndex]){
				if(highIndex==pivotCandidateIndex){
					break;
				}
			}
			
			if((lowIndex==pivotCandidateIndex) || (highIndex==pivotCandidateIndex)){
				break;
			}
			lowIndex=highIndex;
			while(input[++lowIndex]>input[pivotCandidateIndex]){
				if(lowIndex==pivotCandidateIndex){
					break;
				}
			}
			
			if((lowIndex==pivotCandidateIndex) || (highIndex==pivotCandidateIndex)){
				break;
			}
			
			exch(input, highIndex, lowIndex);
		}

		exch(input,highIndex,pivotCandidateIndex);
		printArray(input);
		return highIndex;
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
