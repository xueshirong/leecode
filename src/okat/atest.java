package okat;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class atest {
	public static void main(String[] args){
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < 10; i++){
			list.add(ThreadLocalRandom.current().nextInt(100000001, 1000000000));
		}
		quickSort(list, 0, 9);
		System.out.print(list);
	}

	private static void quickSort(List<Integer> list, int start, int end) {
		if (start >= end)
			return;
		int pos = partition(list, start, end);
		quickSort(list, start, pos - 1);
		quickSort(list, pos + 1, end);		
	}

	private static int partition(List<Integer> list, int start, int end) {
		Random rad = new Random();
		Collections.swap(list, start + rad.nextInt(100)%(end - start + 1), end);
		int pos = start;
		for (int i = start; i< end; i++){
			if (list.get(i) <= list.get(end))
				Collections.swap(list, i, pos++);
		}
		Collections.swap(list, pos, end);
		return pos;
	}
}
