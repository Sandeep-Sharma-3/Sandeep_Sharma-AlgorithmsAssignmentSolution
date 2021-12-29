package stockers.utilities;

import stockers.company.Company;

public class MergeSort {
	static void mergeAsc(Company arr[], int left, int mid, int right) {
		int len_left = mid - left + 1;
		int len_right = right - mid;
		
		Company [] left_arr = new Company[len_left];
		Company [] right_arr = new Company[len_right];
		
		int i, j, k;
		for(i = 0; i < len_left; ++i) {
			left_arr[i] = arr[i + left];
		}
		for(i = 0; i < len_right; ++i) {
			right_arr[i] = arr[i + mid + 1];
		}
		//i -> left array, j -> right array, k -> sorted array
		i = j = 0;
		k = left;
		while (i < len_left && j < len_right) {
			if(left_arr[i].getSharePrice() <= right_arr[j].getSharePrice()) {
				arr[k] = left_arr[i];
				++i;
			}
			else {
				arr[k] = right_arr[j];
				++j;
			}
			++k;
		}
		
		while (i < len_left) {
			arr[k] = left_arr[i];
			++i;
			++k;
		}
		
		while(j < len_right) {
			arr[k] = right_arr[j];
			++j;
			++k; 
		}
	}
	
	static void mergeDesc(Company arr[], int left, int mid, int right) {
		int len_left = mid - left + 1;
		int len_right = right - mid;
		
		Company [] left_arr = new Company[len_left];
		Company [] right_arr = new Company[len_right];
		
		int i, j, k;
		for(i = 0; i < len_left; ++i) {
			left_arr[i] = arr[i + left];
		}
		for(i = 0; i < len_right; ++i) {
			right_arr[i] = arr[i + mid + 1];
		}
		//i -> left array, j -> right array, k -> sorted array
		i = j = 0;
		k = left;
		while (i < len_left && j < len_right) {
			if(left_arr[i].getSharePrice() >= right_arr[j].getSharePrice()) {
				arr[k] = left_arr[i];
				++i;
			}
			else {
				arr[k] = right_arr[j];
				++j;
			}
			++k;
		}
		
		while (i < len_left) {
			arr[k] = left_arr[i];
			++i;
			++k;
		}
		
		while(j < len_right) {
			arr[k] = right_arr[j];
			++j;
			++k; 
		}
	}
	
	public static void mergeSort(Company[] arr, int left, int right, int direction) {
		if(left < right) {
			int mid = (left + right)/2;
			mergeSort(arr, left, mid, direction);
			mergeSort(arr, mid + 1, right, direction);
			
			if(direction == 0) {
				mergeAsc(arr, left, mid, right);
			}
			else {
				mergeDesc(arr, left, mid, right);
			}
		}
	}
}
