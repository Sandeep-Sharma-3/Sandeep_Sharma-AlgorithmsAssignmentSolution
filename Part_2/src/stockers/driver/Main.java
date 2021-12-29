package stockers.driver;

import java.util.Scanner;

import stockers.company.Company;
import stockers.operations.Operations;

public class Main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		System.out.println("Enter the number of companies.");
		int N = in.nextInt();
		in.nextLine();
		System.out.println();
		
		Company [] company = new Company[N];
		
		for(int i = 0; i < N; ++i) {
			company[i] = new Company();
			company[i].sharesInfo((i + 1));
			System.out.print("\n");
		}
		
		Operations operations = new Operations(company, N);
				
		in.close();
		
		System.out.println("Exited Successfully");
	}

}
