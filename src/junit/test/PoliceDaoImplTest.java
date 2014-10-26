package junit.test;
import hj.dao.PoliceDao;
import hj.dao.impl.PoliceDaoImpl;
import hj.entity.Police;

public class PoliceDaoImplTest {
	public static void main(String[] args) {

		findByIDTest("000007");
		findByIDTest("000008");
		findByIDTest("000009");
		findByIDTest("000006");
		findByIDTest("000005");
		findByIDTest("000004");
		
	}

	private static void findByIDTest(String id) {
		PoliceDao pdi = new PoliceDaoImpl();
		if(pdi.findByID(id)){
			System.out.println(id + "已存在");
		}else{
			System.out.println(id + "不存在");
		}
	}
	private static void findByUserNameTest(){
		PoliceDao pdi = new PoliceDaoImpl();
		if(pdi.findByUserName("zyxs")){
			System.out.println("已存在");
		}else{
			System.out.println("不存在");
		}
		pdi.finalize();
	}
	private static void checkTest() {
		PoliceDao pdi = new PoliceDaoImpl();
		if(pdi.check("000003", "123456") == null ){
			System.out.println("id or password wrong");
		}else{
			System.out.println("I get a police");
		}
		if(pdi.check("000003", "123457") == null ){
			System.out.println("id or password wrong");
		}else{
			System.out.println("I get a police");
		}
		if(pdi.check("000005", "123456") == null ){
			System.out.println("id or password wrong");
		}else{
			System.out.println("I get a police");
		}
	}

	private static void addTest() {
		PoliceDao pdi = new PoliceDaoImpl();
		Police police = new Police();
		police.setId("000005");
		police.setUserName("yx");
		police.setRealName("杨欣");
		police.setPassword("123456");
		pdi.add(police);
	}
}
