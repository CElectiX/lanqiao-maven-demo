package lanqiao.service;

import lanqiao.dao.OrderDaoImpl;
import lanqiao.model.Detail;
import lanqiao.model.Order;
import lanqiao.model.PageResult;

import java.text.ParseException;


public class OrderServiceImpl {
	public PageResult queryOrderList(int pageNum, int pageSize) throws ParseException {
		OrderDaoImpl impl = new OrderDaoImpl();
		return impl.QueryOrderList(pageNum, pageSize);
	}
	
	public Order queryOrderById(String orderid) {
		OrderDaoImpl impl = new OrderDaoImpl();
		return impl.queryOrderById(orderid);
	}
	
	public Detail queryDetailById(String orderid) {
		OrderDaoImpl impl = new OrderDaoImpl();
		return impl.QueryDetailByOrderId(orderid);
	}
	
	public Boolean orderSend(String orderid) {
		OrderDaoImpl impl = new OrderDaoImpl();
		return impl.OrderSend(orderid);
	}
	
	public Boolean orderInvalid(String orderid) {
		OrderDaoImpl impl = new OrderDaoImpl();
		return impl.orderInvalid(orderid);
	}
}
