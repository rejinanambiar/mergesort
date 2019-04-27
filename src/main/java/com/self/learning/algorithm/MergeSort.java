package com.self.learning.algorithm;

import java.util.Arrays;
/**
 * 
 * @author rejina
 *
 */
public class MergeSort {

	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		int[] arr = { 150, 50, 100, 200, 300, 250, 400, 350 };
		int[] finalArray = devideAndSort(arr);
		System.out.println("--------------------------------------------");
		printArray(finalArray);
	}

	/**
	 * 
	 * @param arr
	 * @return
	 */
	private static int[] devideAndSort(int[] arr) {

		int mid = arr.length / 2;

		if (mid <= 0) {
			return null;
		}

		int[] leftArray = Arrays.copyOfRange(arr, 0, mid);

		int[] rightArray = Arrays.copyOfRange(arr, mid, arr.length);

		devideAndSort(rightArray);
		devideAndSort(leftArray);

		merge(arr, leftArray, rightArray);
		printArray(arr);
		return arr;
	}

	/**
	 * 
	 * @param arr
	 * @param leftArray
	 * @param rightArray
	 * @return
	 */
	private static int[] merge(int[] arr, int[] leftArray, int[] rightArray) {

		int k = 0;
		int i = 0;
		int j = 0;

		while (i < leftArray.length && j < rightArray.length) {
			if (leftArray[i] < rightArray[j]) {
				arr[k] = leftArray[i];
				i++;
				k++;
				;
			} else {
				arr[k] = rightArray[j];
				j++;
				k++;
			}
		}
		while (i < leftArray.length) {
			arr[k] = leftArray[i];
			i++;
			k++;
		}

		while (j < rightArray.length) {
			arr[k] = rightArray[j];
			j++;
			k++;
		}
		return arr;
	}

	/**
	 * 
	 * @param finalArray
	 */
	private static void printArray(int[] finalArray) {
		for (int i = 0; i < finalArray.length; i++) {
			System.out.print(finalArray[i] + ",");
		}
		System.out.println();
	}

}
