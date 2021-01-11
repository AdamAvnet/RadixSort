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
	
	public static void merge(SortableLinkedList original, SortableLinkedList[] buckets){
		for(int i = 0; i < buckets.length; i++){
			original.extend(buckets[i]);
		}
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
		System.out.println();

		System.out.println("merge tests");
		SortableLinkedList test = new SortableLinkedList();
		test.add(0);
		test.add(1);
		test.add(2);
		SortableLinkedList[] testr = new SortableLinkedList[3];
		SortableLinkedList test2 = new SortableLinkedList();
		test2.add(3);
		test2.add(4);
		test2.add(5);
		testr[0] = test2;
		SortableLinkedList test3 = new SortableLinkedList();
		test3.add(6);
		test3.add(7);
		test3.add(8);
		testr[1] = test3;
		SortableLinkedList test4 = new SortableLinkedList();
		test4.add(9);
		testr[2] = test4;
		merge(test, testr);
		System.out.println("Should be [0, 1, 2, 3, 4, 5, 6, 7, 8, 9]: " + test);
	}

}