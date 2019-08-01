package lanqiao.service;

import java.math.BigDecimal;
import java.util.List;

import lanqiao.dao.CarDaoImpl;
import lanqiao.model.Detail;

public class CarServiceImpl {
	public List<Detail> queryCartList(String uid){
		CarDaoImpl impl = new CarDaoImpl();
		return impl.queryCartList(uid);
		
	}

	public Boolean addCar(String detailProductId,
						  Integer detailProductCount,
						  String detailProductUnit,
						  BigDecimal detailProductPrice,
						  String detailComment,
						  String detailUserId) {
		CarDaoImpl impl = new CarDaoImpl();
		return impl.addCar(detailProductId, detailProductCount, detailProductUnit, detailProductPrice, detailComment, detailUserId);
	}
}
