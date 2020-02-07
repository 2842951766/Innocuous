package com.workAttendance.utils;

import org.apache.commons.lang.StringUtils;

import java.io.InputStream;
import java.util.Properties;

public class ConfigUtil {
	private static Properties props = new Properties();
	static {
		InputStream ips = 
				ConfigUtil.class.getClassLoader()
				.getResourceAsStream("config/application.properties");
		try {
			props.load(ips);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 获Properties文件中制定key对应的value
	 * @param key
	 * @return
	 */
	public static String getProperty(String key) {
		return props.getProperty(key);
	}
	
	/**
	 * 获Properties文件中制定key对应的value，若取不到，返回defaultValue
	 * @param key
	 * @param defaultValue
	 * @return
	 */
	public static String getProperty(String key, String defaultValue) {
		String value = props.getProperty(key);
		if (StringUtils.isEmpty(value)) {
			return defaultValue;
		}
		return value;
	}
}
