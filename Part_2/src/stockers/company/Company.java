package stockers.company;

import java.util.Scanner;

public class Company {

	private double sharePrice;
	private boolean greaterThanYesterday;
	
	public double getSharePrice() {
		return sharePrice;
	}

	public void setSharePrice(double sharePrice) {
		this.sharePrice = sharePrice;
	}

	public boolean isGreaterThanYesterday() {
		return greaterThanYesterday;
	}

	public void setGreaterThanYesterday(boolean greaterThanYesterday) {
		this.greaterThanYesterday = greaterThanYesterday;
	}
	
	public void sharesInfo(int num) {
		Scanner in = new Scanner(System.in);
		
		System.out.println("Enter current stock price of the company " + num);
		double sharePrice = in.nextDouble();
		in.nextLine();
		this.setSharePrice(sharePrice);
		
		System.out.println("Whether company's stock price rose today compare to yesterday?");
		boolean greaterThanYesterday = in.nextBoolean();
		in.nextLine();
		this.setGreaterThanYesterday(greaterThanYesterday);	
	}

	

}
