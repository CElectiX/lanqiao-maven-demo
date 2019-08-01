package lanqiao.dao;

import java.math.BigDecimal;
import java.time.DateTimeException;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import lanqiao.model.Detail;
import lanqiao.model.Product;
import lanqiao.util.DbUtil;
import lanqiao.util.IdUtil;
import lanqiao.util.StringUtil;

public class CarDaoImpl {
	/**
	 * 查询购物车
	 * @param uid
	 * @return
	 */
//	public List<Map<String,Object>> queryCartList(String uid) {
//		String sql = "select * from order_detail where DETAIL_USER_ID=?";
//		List<Map<String,Object>> list = DbUtil.query(sql, uid);
//		return list;
//	}
	public List<Detail> queryCartList(String uid) {
		String sql = "select * from order_detail where DETAIL_USER_ID=?";
		List<Map<String,Object>> list = DbUtil.query(sql, uid);
		List<Detail> detailList = null;
		if(list!=null) {
			detailList = new ArrayList<Detail>();
			for(Map<String,Object> o : list) {
				Detail detail = new Detail();
				Product product = new Product();
				detail.setDetailProductId(StringUtil.ValueOf(o.get("DETAIL_PRODUCT_ID")));
				String sql2 = "select * from product where PRODUCT_ID=?";
				List<Map<String,Object>> list2 = DbUtil.query(sql2, detail.getDetailProductId());
				product.setProductId(StringUtil.ValueOf(list2.get(0).get("PRODUCT_ID")));
				product.setProductCode(StringUtil.ValueOf(list2.get(0).get("PRODUCT_CODE")));
				product.setProductName(StringUtil.ValueOf(list2.get(0).get("PRODUCT_NAME")));
				product.setProductStandard(StringUtil.ValueOf(list2.get(0).get("PRODUCT_STANDARD")));
				product.setProductSmallUnit(StringUtil.ValueOf(list2.get(0).get("PRODUCT_SMALL_UNIT")));
				product.setProductSmallPrice(BigDecimal.valueOf(Double.valueOf(StringUtil.ValueOf(list2.get(0).get("PRODUCT_SMALL_PRICE")))));
				product.setProductLargerUnit(StringUtil.ValueOf(list2.get(0).get("PRODUCT_LARGER_UNIT")));
				product.setProductCategoryId(StringUtil.ValueOf(list2.get(0).get("PRODUCT_CATEGORY_ID")));
				product.setProductBrandId(StringUtil.ValueOf(list2.get(0).get("PRODUCT_BRAND_ID")));
				product.setProductPhoto(StringUtil.ValueOf(list2.get(0).get("PRODUCT_PHOTO")));
				product.setProductIsSale(Byte.valueOf(StringUtil.ValueOf(list2.get(0).get("PRODUCT_IS_SALE"))));
				product.setProductIsLack(Byte.valueOf(StringUtil.ValueOf(list2.get(0).get("PRODUCT_IS_LACK"))));
				product.setProductStatus(Byte.valueOf(StringUtil.ValueOf(list2.get(0).get("PRODUCT_STATUS"))));
				product.setProductOrder(Integer.valueOf(StringUtil.ValueOf(list2.get(0).get("PRODUCT_ORDER"))));
				product.setProductDateTime(StringUtil.ValueOf(list2.get(0).get("PRODUCT_DATE_TIME")));
				product.setProductLargerStandard(StringUtil.ValueOf(list2.get(0).get("PRODUCT_LARGER_STANDARD")));
				product.setProductSuggestPrice((BigDecimal) (list2.get(0).get("PRODUCT_SUGGEST_PRICE")));
				detail.setDetailId(StringUtil.ValueOf(o.get("DETAIL_ID")));
				detail.setDetailProductCount(Integer.valueOf(StringUtil.ValueOf(o.get("DETAIL_PRODUCT_COUNT"))));
				detail.setDetailProductUnit(StringUtil.ValueOf(o.get("DETAIL_PRODUCT_UNIT")));
				detail.setDetailProductPrice(BigDecimal.valueOf(Double.valueOf(StringUtil.ValueOf(o.get("DETAIL_PRODUCT_PRICE")))));
				detail.setDetailTotalPrice(BigDecimal.valueOf(Double.valueOf(StringUtil.ValueOf(o.get("DETAIL_TOTAL_PRICE")))));
				detail.setDetailComment(StringUtil.ValueOf(o.get("DETAIL_COMMENT"))==null?"null":StringUtil.ValueOf(o.get("DETAIL_COMMENT")));
				detail.setDetailStatus(Byte.valueOf(StringUtil.ValueOf(o.get("DETAIL_STATUS"))));
				detail.setDetailOrderId(StringUtil.ValueOf(o.get("DETAIL_ORDER_ID")));
				detail.setDetailUserId(StringUtil.ValueOf(o.get("DETAIL_USER_ID")));
				detail.setDetailDateTime(StringUtil.ValueOf(o.get("DETAIL_DATE_TIME")));
				detail.setProduct(product);
				detailList.add(detail);
			}
		}
		return detailList;
	}

	public Boolean addCar(String detailProductId,
						  Integer detailProductCount,
						  String detailProductUnit,
						  BigDecimal detailProductPrice,
						  String detailComment,
						  String detailUserId){
		String sql = "insert into order_detail values(?,?,?,?,?,?,?,?,?,?,?)";
		int i = DbUtil.update(sql,
				IdUtil.getUuid(),
				detailProductId,
				detailProductCount,
				detailProductUnit,
				detailProductPrice,
				BigDecimal.valueOf(Double.valueOf(detailProductCount)).multiply(detailProductPrice),
				detailComment,
				1,
				IdUtil.getDateId(),
				detailUserId,
				null);
				DateTimeFormatter.ofPattern(IdUtil.getLongTimeId());
		Boolean bool = null;
		if(i==1) {
			bool = true;
		}else {
			bool = false;
		}
		return bool;
	}
}
