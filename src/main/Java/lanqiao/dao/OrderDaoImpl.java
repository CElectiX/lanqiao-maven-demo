package lanqiao.dao;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import lanqiao.model.*;
import lanqiao.util.DbUtil;
import lanqiao.util.StringUtil;
import lanqiao.vo.JsonResult;

public class OrderDaoImpl {
	/**
	 * 分页查询订单列表
	 * @param pageNum
	 * @param pageSize
	 * @return
	 * @throws ParseException
	 */
	public PageResult QueryOrderList(int pageNum, int pageSize) throws ParseException {
		String sql = "select * from order_list ol LEFT JOIN user u on ol.ORDER_USER_ID=u.USER_ID limit ?,?";
		List<Map<String,Object>> list = DbUtil.query(sql, (pageNum-1)*pageSize,pageSize);
		List<Order> list2 = new ArrayList<Order>();
		System.out.println(list);
		if(list!=null) {
			for(int i=0;i<list.size();i++) {
				Order order = new Order();
				User user = new User();
				order.setOrderId(StringUtil.ValueOf(list.get(i).get("ORDER_ID")));
				order.setOrderUserId(StringUtil.ValueOf(list.get(i).get("ORDER_USER_ID")));
				order.setOrderDateTime(StringUtil.ValueOf(list.get(i).get("ORDER_DETE_TIME")));
				order.setOrderIsSend(Byte.valueOf(StringUtil.ValueOf(list.get(i).get("ORDER_IS_SEND"))));
				order.setOrderIsValid(Byte.valueOf(StringUtil.ValueOf(list.get(i).get("ORDER_IS_VALID"))));
				order.setOrderTotalPrice((BigDecimal.valueOf(Double.valueOf(StringUtil.ValueOf(list.get(i).get("ORDER_TOTAL_PRICE"))))));
				order.setOrderStatus(Byte.valueOf(StringUtil.ValueOf(list.get(i).get("ORDER_STATUS"))));
				order.setOrderComment(StringUtil.ValueOf(list.get(i).get("ORDER_COMMENT")));
				order.setUser(user);
				list2.add(order);
			}
		}
		System.out.println(list2);
		PageResult pgresult = new PageResult();
		pgresult.setList(list2);
		pgresult.setPageNum(pageNum);
		pgresult.setPageSize(pageSize);
		
		String sql2 = "select count(*) row from order_list";
		List<Map<String,Object>> countList =DbUtil.query(sql2);
		String count = StringUtil.ValueOf(countList.get(0).get("row"));
		int size = Integer.parseInt(count);
		pgresult.setTotal(size);
		pgresult.setPages(size%pageSize==0?size/pageSize:size/pageSize+1);
		
		return pgresult;
	}
	/**
	 *根据订单ID查询订单
	 * @param orderId
	 * @return
	 */
	public Order queryOrderById(String orderid) {
		String sql = "select * from ORDER_LIST where ORDER_ID=?";
		List<Map<String ,Object>> list = DbUtil.query(sql, orderid);
		Order order = new Order();
		if(list!=null) {
			order.setOrderUserId(StringUtil.ValueOf(list.get(0).get("ORDER_USER_ID")));
			String sql2 = "select * from user where USER_ID =?";
			String userId = order.getOrderUserId();
			List<Map<String,Object>> list2 = DbUtil.query(sql2, userId);
			User user = new User();
			user.setUserId(StringUtil.ValueOf(list2.get(0).get("USER_ID")));
			user.setUserUserName(StringUtil.ValueOf(list2.get(0).get("USER_USER_NAME")));
			user.setUserPassword(StringUtil.ValueOf(list2.get(0).get("USER_PASSWORD")));
			user.setUserTelphone(StringUtil.ValueOf(list2.get(0).get("USER_TELPHONE")));
			user.setUserAddress(StringUtil.ValueOf(list2.get(0).get("USER_ADDRESS")));
			user.setUserShopName(StringUtil.ValueOf(list2.get(0).get("USER_SHOP_NAME")));
			user.setUserComment(StringUtil.ValueOf(list2.get(0).get("USER_COMMENT")));
			user.setUserStatus(StringUtil.ValueOf(list2.get(0).get("USER_STATUS")));
			order.setUser(user);
			order.setOrderId(StringUtil.ValueOf(list.get(0).get("ORDER_ID")));
			order.setOrderDateTime(StringUtil.ValueOf(list.get(0).get("ORDER_DETE_TIME")));
			order.setOrderIsSend(Byte.valueOf(StringUtil.ValueOf(list.get(0).get("ORDER_IS_SEND"))));
			order.setOrderIsValid(Byte.valueOf(StringUtil.ValueOf(list.get(0).get("ORDER_IS_VALID"))));
			order.setOrderTotalPrice((BigDecimal.valueOf(Double.valueOf(StringUtil.ValueOf(list.get(0).get("ORDER_TOTAL_PRICE"))))));
			order.setOrderStatus(Byte.valueOf(StringUtil.ValueOf(list.get(0).get("ORDER_STATUS"))));
			order.setOrderComment(StringUtil.ValueOf(list.get(0).get("ORDER_COMMENT")));
		}
		return order;
	}
	/**
	 *根据订单ID查询详情
	 * @param detailId
	 * @return
	 */
	public Detail QueryDetailByOrderId(String orderid) {
		String sql = "select * from order_detail where DETAIL_ORDER_ID=?";
		List<Map<String,Object>> list= DbUtil.query(sql, orderid);
		Detail detail =new Detail();
		JsonResult result = null;
		if(list!=null) {
			detail.setDetailProductId(StringUtil.ValueOf(list.get(0).get("DETAIL_PRODUCT_ID")));
			String sql2 = "select * from product where PRODUCT_ID =?";
			List<Map<String,Object>> list2 = DbUtil.query(sql2, detail.getDetailProductId());
			Product product = new Product();
			product.setProductId(StringUtil.ValueOf(list2.get(0).get("DETAIL_PRODUCT_ID")));
			product.setProductId(StringUtil.ValueOf(list2.get(0).get("PRODUCT_ID")));
			product.setProductCode(StringUtil.ValueOf(list2.get(0).get("PRODUCT_CODE")));
			product.setProductName(StringUtil.ValueOf(list2.get(0).get("PRODUCT_NAME")));
			product.setProductStandard(StringUtil.ValueOf(list2.get(0).get("PRODUCT_STANDARD")));
			product.setProductSmallUnit(StringUtil.ValueOf(list2.get(0).get("PRODUCT_SMALL_UNIT")));
			product.setProductSmallPrice((BigDecimal) list2.get(0).get("PRODUCT_SMALL_PRICE")==null?null:(BigDecimal) list2.get(0).get("PRODUCT_SMALL_PRICE"));
			product.setProductLargerUnit(StringUtil.ValueOf(list2.get(0).get("PRODUCT_LARGER_UNIT")));
			product.setProductCategoryId(StringUtil.ValueOf(list2.get(0).get("PRODUCT_CATEGORY_ID")));
			product.setProductBrandId(StringUtil.ValueOf(list2.get(0).get("PRODUCT_BRAND_ID")));
			product.setProductPhoto(StringUtil.ValueOf(list2.get(0).get("PRODUCT_PHOTO")));
			product.setProductIsSale(Byte.valueOf(StringUtil.ValueOf(list2.get(0).get("PRODUCT_IS_SALE"))));
			product.setProductIsLack(Byte.valueOf(StringUtil.ValueOf(list2.get(0).get("PRODUCT_IS_LACK"))));
			product.setProductStatus(Byte.valueOf(StringUtil.ValueOf(list2.get(0).get("PRODUCT_STATUS"))));
			product.setProductOrder(Integer.valueOf(StringUtil.ValueOf(list2.get(0).get("PRODUCT_ORDER"))));
			product.setProductDateTime(StringUtil.ValueOf(list2.get(0).get("ORDER_DETE_TIME")));
			product.setProductLargerStandard(StringUtil.ValueOf(list2.get(0).get("PRODUCT_LARGER_STANDARD")));
			product.setProductSuggestPrice(BigDecimal.valueOf(Double.valueOf(StringUtil.ValueOf(list2.get(0).get("PRODUCT_SUGGEST_PRICE")))));
			detail.setProduct(product);
			detail.setDetailId(StringUtil.ValueOf(list.get(0).get("DETAIL_ID")));
			detail.setDetailProductCount(Integer.valueOf(StringUtil.ValueOf(list.get(0).get("DETAIL_PRODUCT_COUNT"))));
			detail.setDetailProductUnit(StringUtil.ValueOf(list.get(0).get("DETAIL_PRODUCT_UNIT")));
			detail.setDetailProductPrice(BigDecimal.valueOf(Double.valueOf(StringUtil.ValueOf(list.get(0).get("DETAIL_PRODUCT_PRICE")))));
			detail.setDetailTotalPrice(BigDecimal.valueOf(Double.valueOf(StringUtil.ValueOf(list.get(0).get("DETAIL_TOTAL_PRICE")))));
			detail.setDetailComment(StringUtil.ValueOf(list.get(0).get("DETAIL_COMMENT")));
			detail.setDetailStatus(Byte.valueOf(StringUtil.ValueOf(list.get(0).get("DETAIL_STATUS"))));
			detail.setDetailOrderId(StringUtil.ValueOf(list.get(0).get("DETAIL_ORDER_ID")));
			detail.setDetailUserId(StringUtil.ValueOf(list.get(0).get("DETAIL_USER_ID")));
			detail.setDetailDateTime(StringUtil.ValueOf(list.get(0).get("DETAIL_DETE_TIME")));
		} 
		return detail;
	}
	/**
	 * 发货
	 * @param orderid
	 * @return
	 */
	public Boolean OrderSend(String orderid) {
		Boolean bool =null;
		String sql = "UPDATE order_list SET ORDER_IS_SEND='1' WHERE ORDER_ID=?";
		int i =DbUtil.update(sql, orderid);
		if(i==1) {
			bool = true;
		}else {
			bool = false;
		}
		return bool;
	}

	/**
	 * 订单失效
	 * @param orderid
	 * @return
	 */
	public Boolean orderInvalid(String orderid) {
		Boolean bool = null;
		String sql = "UPDATE order_list SET ORDER_IS_VALID='0' WHERE ORDER_ID=?";
		int i = DbUtil.update(sql, orderid);
		if(i==1) {
			bool = true;
		}else {
			bool = false;
		}
		return bool;
	}

	public Boolean commitOrderDaoImpl(){
		String sql = "select DETAIL_PRODUCT_PRICE from order_detail where DETAIL_USER_ID=?";
		return null;
	}
}
