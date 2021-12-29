package stockers.utilities;

import stockers.company.Company;

public class BinarySearch {
	public static int binarySearchAsc(Company[] arr, double key, int size) {
		int last = size - 1;
		int first = 0;
		int mid = (first + last)/2;
		
		while(first <= last) {
			if(arr[mid].getSharePrice() < key) {
				first = mid + 1;
			}
			else if(arr[mid].getSharePrice() == key) {
				return mid;
			}
			else {
				last = mid - 1;
			}
			
			mid = (first + last)/2;
		}
		
		return -1;
	}
	
	public static int binarySearchDesc(Company[] arr, double key, int size) {
		int last = size - 1;
		int first = 0;
		int mid = (first + last)/2;
		
		while(first <= last) {
			if(arr[mid].getSharePrice() > key) {
				first = mid + 1;
			}
			else if(arr[mid].getSharePrice() == key) {
				return mid;
			}
			else {
				last = mid - 1;
			}
			
			mid = (first + last)/2;
		}
		
		return -1;
	}
}
