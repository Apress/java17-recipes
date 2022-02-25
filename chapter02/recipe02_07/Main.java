package org.java17recipes.chapter02.recipe02_07;
 

public class Main {
	public static void main (String[] args) {
		SumFPnumbers sn = new SumFPnumbers ();
		System.out.println("SUM :  "+sn.sumNumbers(1.2,3.4));
		SumFPnumbersStrict sns = new SumFPnumbersStrict();
		System.out.println("SUM :  "+sns.sumNumbers(1.2,3.4));
	}
}
