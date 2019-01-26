package com.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ListCopyTest {

	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		list.add("a");
		list.add("b");
		
		//method1
//		List<String> newList = new ArrayList<String>(Arrays.asList(new String[list.size()]));
//		Collections.copy(newList, list);
		
		//method2
		List<String> newList = new ArrayList<String>(list);
		
		newList.add("c");
		
		for(String s : list){
			System.out.print(s);
		}
		System.out.println();
		for(String s : newList){
			System.out.print(s);
		}
		System.out.println();
		System.out.println(list == newList);
	}
}
