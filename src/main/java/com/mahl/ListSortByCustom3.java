package com.mahl;

import java.text.CollationKey;
import java.text.Collator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * 自定义排序英文
 * @author mahl
 * 2015年11月12日上午11:15:55
 */
public class ListSortByCustom3{

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		List list = new ArrayList(10);
		list.add("gdfg");
		list.add("fdgf");
		list.add("adgf");
		list.add("had");
		list.add("basd");
		list.add("casdf");
		list.add("dasf");
		list.add("esdf");
		System.out.println("初始化list为");
		output(list);
		System.out.println();
		System.out.println("默认排序后list为");
		Collections.sort(list);//默认按照abcdefg的顺序排序
		output(list);
		System.out.println();
//		System.out.println("自定义排序后list为");
//		Collections.sort(list, new MyComparactor3());
//		output(list);
		System.out.println("倒序排序后list为");
		Collections.reverse(list);
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
 * 自定义list比较器(英文)
 * @author mahl
 * 2015年11月12日上午11:17:04
 */
@SuppressWarnings("rawtypes")
class MyComparactor3 implements Comparator{

	//关于Collator。
	private Collator collator = Collator.getInstance();//点击查看中文api详解

	@Override
	public int compare(Object o1, Object o2) {
		//把字符串转换为一系列比特，它们可以以比特形式与 CollationKeys 相比较
		//要想不区分大小写进行比较用o1.toString().toLowerCase()
		CollationKey key1 = null;
		CollationKey key2 = null;
		if(o1 != null){
			key1 = collator.getCollationKey(o1.toString().toLowerCase());
		}
		if(o2 != null){
			key2 = collator.getCollationKey(o2.toString().toLowerCase());
		}
		return key1.compareTo(key2);
	}

}
