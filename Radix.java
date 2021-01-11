import java.util.*;
public class Radix{
	public static int nth(int n, int col){
		int divisor = (int) Math.pow(10.0, (double) col);
		int newN = n / divisor;
		return newN % 10;
	}

	public static int length(int n){
		return (int) (Math.log(Math.abs((double) n)) / Math.log(10.0)) + 1;
	}
	
	public static void main(String[] args){
		System.out.println("Should be 4: " + nth(145, 1));
		System.out.println("Should be 1: " + nth(145, 2));
		System.out.println("Should be 6: " + nth(7654, 2));
		System.out.println("Should be 5: " + nth(-895302, 3));
		System.out.println();
		System.out.println("length tests");
		System.out.println("Should be 1; " + length(8));
		System.out.println("Should be 2: " + length(-54));
		System.out.println("Should be 3: " + length(-782));
		System.out.println("Should be 4: " + length(8391));
	}

}