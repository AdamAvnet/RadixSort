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
	
	public static void radixSortSimple(SortableLinkedList data){
		SortableLinkedList[] buckets = new SortableLinkedList[10];
		for(int i = 0; i < 10; i ++){
			SortableLinkedList bukt = new SortableLinkedList();
			buckets[i] = bukt;
		}
		int max = 0;
		int value = 0;
		int content = 0;
		SortableLinkedList cleaner = new SortableLinkedList();
		for(int i = 0; i < data.size(); i++){
			value = data.get(i);
			if(length(value) > max)
				max = length(value);
			content = nth(value, 0);
			buckets[content].add(value);
		}
		cleaner.extend(data);
		for(int i = 1; i < max; i++){
			merge(data, buckets);
			for(int j = 0; j < data.size(); j++){
				value = data.get(j);
				content = nth(value, i);
				buckets[content].add(value);
			}
			cleaner.extend(data);
		}
		merge(data, buckets);
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

		System.out.println("merge test");
		SortableLinkedList test = new SortableLinkedList();
		test.add(-23);
		test.add(47);
		SortableLinkedList[] testr = new SortableLinkedList[3];
		SortableLinkedList test2 = new SortableLinkedList();
		test2.add(109);
		test2.add(7382);
		test2.add(-541);
		test2.add(-3921);
		testr[0] = test2;
		SortableLinkedList test3 = new SortableLinkedList();
		test3.add(102);
		test3.add(89);
		test3.add(-763);
		testr[1] = test3;
		SortableLinkedList test4 = new SortableLinkedList();
		test4.add(9);
		testr[2] = test4;
		merge(test, testr);
		System.out.println("Should be [-23, 47, 109, 7382, -541, -3921, 102, 89, -763, 9]: " + test);
		System.out.println();

		System.out.println("radixSortSimple test");
		SortableLinkedList test5 = new SortableLinkedList();
		test5.add(34);
		test5.add(9203);
		test5.add(23);
		test5.add(874);
		test5.add(321);
		test5.add(9);
		test5.add(3);
		test5.add(78);
		test5.add(173);
		System.out.println(test5);
		radixSortSimple(test5);
		System.out.println(test5);
	}

}