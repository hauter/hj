package hj.service.impl;

import hj.dao.PoliceDao;
import hj.dao.impl.PoliceDaoImpl;
import hj.entity.Police;
import hj.exception.PoliceIDExistException;
import hj.exception.PoliceUserNameExistException;
import hj.utils.ServiceUtils;

public class PoliceServiceImpl {
	private PoliceDao pd = new PoliceDaoImpl();
	
	//注册
	public void register(Police police) throws PoliceIDExistException, PoliceUserNameExistException{
		pd.reloadDriver();
		boolean bid = pd.findByID(police.getId());
		boolean bun = pd.findByUserName(police.getUserName());
		if(bid){
			throw new PoliceIDExistException();
		}else if(bun){
			throw new PoliceUserNameExistException();
		}else{
			String password = ServiceUtils.md5(police.getPassword());
			police.setPassword(password);
			pd.add(police);
		}
	}
	//登录
	public Police login(String userName, String password){
		pd.reloadDriver();
		password = ServiceUtils.md5(password);
		return pd.check(userName, password);
	}
}
