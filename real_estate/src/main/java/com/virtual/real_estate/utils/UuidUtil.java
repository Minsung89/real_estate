package com.virtual.real_estate.utils;

import java.util.UUID;

public class UuidUtil {

	public static String uuidTen() {
        String uuid = UUID.randomUUID().toString().replaceAll("-", ""); // -를 제거해 주었다.
        return uuid = uuid.substring(0, 10).toUpperCase(); //uuid를 앞에서부터 10자리 잘라줌.
	}
}
