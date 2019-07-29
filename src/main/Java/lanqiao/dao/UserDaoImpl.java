package lanqiao.dao;


import lanqiao.model.User;
import lanqiao.util.DbUtil;
import lanqiao.util.StringUtil;

import java.util.List;
import java.util.Map;


public class UserDaoImpl {
	/**
	 * ��½
	 * @param userUserName
	 * @param userPassword
	 * @return
	 */
	public User login(String userUserName, String userPassword) {
		String sql = "select * from user where USER_USER_NAME=? and USER_PASSWORD=?";
		List<Map<String,Object>> list = DbUtil.query(sql, userUserName, userPassword);
		User user = new User();
		if(list.size()>0) {
			user.setUserId(StringUtil.ValueOf(list.get(0).get("USER_ID")));
			user.setUserUserName(StringUtil.ValueOf(list.get(0).get("USER_USER_NAME")));
			user.setUserTelphone(StringUtil.ValueOf(list.get(0).get("USER_TELPHONE")));
			user.setUserAddress(StringUtil.ValueOf(list.get(0).get("USER_ADDRESS")));
			user.setUserShopName(StringUtil.ValueOf(list.get(0).get("USER_SHOP_NAME")));
		}
		return user;	
	}
	
	public Boolean registered(User user) {
		String sql = "INSERT INTO user VALUES(?,?,?,?,?,?,?,?)";
		int i = DbUtil.update(sql,user.getUserId(),
				user.getUserUserName(),
				user.getUserPassword(),
				user.getUserShopName(),
				user.getUserTelphone(),
				user.getUserAddress(),
				user.getUserComment(),
				user.getUserStatus());
		Boolean bool =null;
		if(i==1) {
			bool = true;
		}else {
			bool = false;
		}
		return bool;
	}
}
