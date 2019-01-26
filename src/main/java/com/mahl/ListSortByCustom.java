package com.mahl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * �Զ�������int
 * @author mahl  
 * 2015��11��12������11:15:55
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
		System.out.println("��ʼ��listΪ");
		output(list);
		System.out.println();
		System.out.println("Ĭ�������listΪ");
		Collections.sort(list);//Ĭ������
		output(list);
		System.out.println();
		System.out.println("�Զ��������listΪ");
		Collections.sort(list, new MyComparactor());
		output(list);
	}
	
	/**
	 * ����list
	 * @author mahl
	 * 2015��11��12������11:16:56
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
		System.out.println("listΪ�գ�");
	}
}

/**
 * �Զ���list�Ƚ���
 * @author mahl  
 * 2015��11��12������11:17:04
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
