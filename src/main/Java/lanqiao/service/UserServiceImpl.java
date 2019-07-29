package lanqiao.service;


import lanqiao.dao.UserDaoImpl;
import lanqiao.model.User;

public class UserServiceImpl {
	 public User login(String userUserName, String userPassword) {
		UserDaoImpl impl = new UserDaoImpl();
		User user = impl.login(userUserName, userPassword);
		return user;
	 }
	 
	 public Boolean registered(User user) {
		 UserDaoImpl impl = new UserDaoImpl();
		 return impl.registered(user);
	 }
}
