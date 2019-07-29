package lanqiao.service;

import java.util.List;

import lanqiao.dao.CarDaoImpl;
import lanqiao.model.Detail;

public class CarServiceImpl {
	public List<Detail> queryCartList(String uid){
		CarDaoImpl impl = new CarDaoImpl();
		return impl.queryCartList(uid);
		
	}
}
