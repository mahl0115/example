package com.batch;

import java.util.UUID;

public class UuidUtil {

	public static String get32UUID() {
		String uuid = UUID.randomUUID().toString().trim().replaceAll("-", "");
		return uuid;
	}
	
	public static void main(String[] args) {
		for(int i=0;i<20;i++){
			System.out.println(get32UUID());
		}
	}
}

