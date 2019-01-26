package com.mahl;

import java.text.CollationKey;
import java.text.Collator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * �Զ�������Ӣ��
 * @author mahl  
 * 2015��11��12������11:15:55
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
		System.out.println("��ʼ��listΪ");
		output(list);
		System.out.println();
		System.out.println("Ĭ�������listΪ");
		Collections.sort(list);//Ĭ�ϰ���abcdefg��˳������
		output(list);
		System.out.println();
//		System.out.println("�Զ��������listΪ");
//		Collections.sort(list, new MyComparactor3());
//		output(list);
		System.out.println("���������listΪ");
		Collections.reverse(list);
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
 * �Զ���list�Ƚ���(Ӣ��)
 * @author mahl  
 * 2015��11��12������11:17:04
 */
@SuppressWarnings("rawtypes")
class MyComparactor3 implements Comparator{

	//����Collator��  
	private Collator collator = Collator.getInstance();//����鿴����api���
	
	@Override
	public int compare(Object o1, Object o2) {
		//���ַ���ת��Ϊһϵ�б��أ����ǿ����Ա�����ʽ�� CollationKeys ��Ƚ�  
		//Ҫ�벻���ִ�Сд���бȽ���o1.toString().toLowerCase()
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
