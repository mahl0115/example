package com.mahl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * 自定义排序int
 * @author mahl  
 * 2015年11月12日上午11:15:55
 */
public class ListSortByCustom{

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>(5);
		list.add(6);
		list.add(5);
		list.add(7);
		list.add(1);
		list.add(9);
		list.add(8);
		list.add(4);
		list.add(2);
		list.add(3);
		System.out.println("初始化list为");
		output(list);
		System.out.println();
		System.out.println("默认排序后list为");
		Collections.sort(list);//默认升序
		output(list);
		System.out.println();
		System.out.println("自定义排序后list为");
		Collections.sort(list, new MyComparactor());
		output(list);
	}
	
	/**
	 * 输入list
	 * @author mahl
	 * 2015年11月12日上午11:16:56
	 */
	public static void output(List list){
		if(list != null && list.size() > 0){
			for(Object obj : list){
				if(obj != null){
					System.out.print(obj.toString() + " ");
				}
			}
			return;
		}
		System.out.println("list为空！");
	}
}

/**
 * 自定义list比较器
 * @author mahl  
 * 2015年11月12日上午11:17:04
 */
@SuppressWarnings("rawtypes")
class MyComparactor implements Comparator{

	@Override
	public int compare(Object o1, Object o2) {
		Double value1 = 0.0;
		Double value2 = 0.0;
		if(o1 != null){
			value1 = Double.parseDouble(o1.toString());
		}
		if(o2 != null){
			value2 = Double.parseDouble(o2.toString());
		}
		return value2.compareTo(value1);
	}
	
}
