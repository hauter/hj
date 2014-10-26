package junit.test;

import hj.dao.impl.PoliceDaoImpl;
import hj.entity.Police;
import hj.exception.PoliceIDExistException;
import hj.exception.PoliceUserNameExistException;
import hj.service.impl.PoliceServiceImpl;

public class PoliceServiceImplTest {
	public static void main(String[] args) {
		
	}


	private static void loginTest() {
		Police police = new PoliceServiceImpl().login("000001", "123456");
		System.out.println(police.getRealName());
	}
	
	
	private static void registerTest() {
		Police police = new Police();
		police.setId("000001");
		police.setUserName("zyx");
		police.setRealName("张宇新");
		police.setPassword("123456");
		PoliceServiceImpl psi = new PoliceServiceImpl();
		try {
			psi.register(police);
			System.out.println("注册成功");
		} catch (PoliceIDExistException e) {
			System.out.println("用户ID已存在");
		} catch (PoliceUserNameExistException e){
			System.out.println("用户UserName已存在");
		}
	}
}
