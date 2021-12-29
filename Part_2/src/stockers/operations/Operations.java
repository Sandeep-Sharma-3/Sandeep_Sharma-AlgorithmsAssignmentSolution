package stockers.operations;

import java.util.Scanner;

import stockers.company.Company;
import stockers.utilities.MergeSort;
import stockers.utilities.BinarySearch;

public class Operations {
	private Company[] company;
	private int numComp;
	private boolean isSortedAsc;
	private boolean isSortedDesc;

	public Operations(Company[] company, int numComp) {
		this.company = company;
		this.numComp = numComp;
		this.isSortedAsc = false;
		this.isSortedDesc = false;
		this.select();
	}

	public void select() {
		int select;
		Scanner in = new Scanner(System.in);
		
		do {
			System.out.println("Enter the operation that you want to perform.");
			System.out.println("1. Display the companies stock prices in ascending order.");
			System.out.println("2. Display the companies stock prices in descending order.");
			System.out.println("3. Display the total no of companies for which stock prices rose today.");
			System.out.println("4. Display the total no of companies for which stock prices declined today.");
			System.out.println("5. Search a specific stock price.");
			System.out.println("6. press 0 to exit.");
			
			select = in.nextInt();
			
			switch(select) {
				case 1 :
					this.dispStockAsc();
					break;
				case 2 :
					this.dispStockDesc();
					break;
				case 3 :
					this.dispStockRose();
					break;
				case 4 :
					this.dispStockDeclined();
					break;
				case 5 :
					this.searchStockPrice();
					break;
				case 6 :
					break;
				default :
					break;
			}
		} while(select == 1 || select == 2 || select == 3 || select == 4 || select == 5);
	}

	public void dispStockAsc() {
		MergeSort.mergeSort(company, 0, this.numComp - 1, 0);
		this.isSortedAsc = true;
		this.isSortedDesc = false;
		
		System.out.println("Stock prices in ascending order are :");
		for(int i = 0; i < this.numComp; ++i) {
			System.out.print(this.company[i].getSharePrice() + " ");
		}
		System.out.println("\n");
	}
	
	public void dispStockDesc() {
		MergeSort.mergeSort(company, 0, this.numComp - 1, 1);
		this.isSortedDesc = true;
		this.isSortedAsc = false;
		
		System.out.println("Stock prices in descending order are :");
		for(int i = 0; i < this.numComp; ++i) {
			System.out.print(this.company[i].getSharePrice() + " ");
		}
		System.out.println("\n");
	}
	
	public void dispStockRose() {
		int count = 0;
		for(int i = 0; i < this.numComp; ++i) {
			if(this.company[i].isGreaterThanYesterday() == true) {
				++count;
			}
		}
		System.out.println("Total no of companies whose stock price rose today : " + count + "\n");
	}
	
	public void dispStockDeclined() {
		int count = 0;
		for(int i = 0; i < this.numComp; ++i) {
			if(this.company[i].isGreaterThanYesterday() == false) {
				++count;
			}
		}
		System.out.println("Total no of companies whose stock price declined today : " + count + "\n");
	}
	
	public void searchStockPrice() {
		Scanner in = new Scanner(System.in);
		
		System.out.println("Enter the key value :");
		double key = in.nextDouble();
		
		if(this.isSortedDesc == false) {
			if(this.isSortedAsc == false) {
				MergeSort.mergeSort(this.company, 0, this.numComp - 1, 0);
			}
			
			int position = BinarySearch.binarySearchAsc(this.company, key, this.numComp);
			
			if(position == -1) {
				System.out.println("Stock of value " + key + " is not present.\n");
			}
			else {
				System.out.println("Stock of value " + key + " is present.\n");
			}
						
			return;
		}
		else if(this.isSortedDesc == true) {
			int position = BinarySearch.binarySearchDesc(this.company, key, this.numComp);
			
			if(position == -1) {
				System.out.println("Stock of value " + key + " is not present.\n");
			}
			else {
				System.out.println("Stock of value " + key + " is present.\n");
			}
						
			return;
		}
		
	}
}
