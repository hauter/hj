package hj.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import sun.misc.BASE64Encoder;

//md5加密
public class ServiceUtils {
	public static String md5(String str){
		MessageDigest md;
		try {
			md = MessageDigest.getInstance("md5");
			byte [] md5 = md.digest(str.getBytes());
			return new BASE64Encoder().encode(md5);
		} catch (NoSuchAlgorithmException e) {
			throw new RuntimeException(e);
		}
	}
}
