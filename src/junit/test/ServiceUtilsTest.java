package junit.test;

import hj.utils.ServiceUtils;

public class ServiceUtilsTest {
	public static void main(String[] args) {
		String md5 = ServiceUtils.md5("bnm,lkjuiytredswqazx");
		System.out.println(md5);
		System.out.println(md5.length());
	}

}
