package com.self.learning.algorithm;

import java.util.Arrays;

/**
 * Class for Merge Sort
 * 
 * @author rejina
 *
 */
public class MergeSort {

	/**
	 * Main method
	 * @param args
	 */
	public static void main(String[] args) {
		int[] inputArray = { 150, 50, 100, 200, 300, 250, 400, 350 };
		printArray(inputArray,"Input");
		int[] finalArray = devideAndSort(inputArray);
		printArray(finalArray,"Output");
		
	}

	/**
	 * Method to divide the input array into smaller
	 * 
	 * @param inputArray
	 * @return
	 */
	private static int[] devideAndSort(int[] inputArray) {

		int mid = inputArray.length / 2;

		if (mid <= 0) {
			return null;
		}

		int[] leftArray = Arrays.copyOfRange(inputArray, 0, mid);

		int[] rightArray = Arrays.copyOfRange(inputArray, mid, inputArray.length);

		//Call the method iteratively to divide and merge
		devideAndSort(rightArray);
		devideAndSort(leftArray);
		//Merge the arrays
		merge(inputArray, leftArray, rightArray);
		return inputArray;
	}

	/**
	 * Method to sort and merge the arrays
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

		//Compare the left and right arrays and update the main array
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
		
		//Copy the remaining elements in the left array into the main array
		while (i < leftArray.length) {
			arr[k] = leftArray[i];
			i++;
			k++;
		}

		//Copy the remaining elements in the right array into the main array
		while (j < rightArray.length) {
			arr[k] = rightArray[j];
			j++;
			k++;
		}
		return arr;
	}

	/**
	 * Method to print the array
	 * 
	 * @param finalArray
	 */
	private static void printArray(int[] array, String type) {
		System.out.println(type+"::"+Arrays.toString(array));
	}

}
