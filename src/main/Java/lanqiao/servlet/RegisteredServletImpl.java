package lanqiao.servlet;

import lanqiao.model.User;
import lanqiao.service.UserServiceImpl;
import lanqiao.vo.JsonResult;
import lanqiao.vo.JsonWriter;

import java.io.IOException;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet("/api/registered")
public class RegisteredServletImpl extends HttpServlet{
	/**
	 * 用户注册
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	@Override
	public void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		User user = new User();
		user.setUserId(UUID.randomUUID().toString());
		user.setUserUserName(req.getParameter("userUserName"));
		user.setUserPassword(req.getParameter("userPassword"));
		user.setUserTelphone(req.getParameter("userTelphone"));
		user.setUserAddress(req.getParameter("userAddress"));
		user.setUserShopName(req.getParameter("userShopName"));
		user.setUserComment(req.getParameter("userComment"));
		user.setUserStatus("1");
		UserServiceImpl impl = new UserServiceImpl();
		JsonResult result = null;
		System.out.println(req.getParameter("userUserName"));
		System.out.println(user.toString());
		try {
			Boolean bool = impl.registered(user);
			result = new JsonResult("注册成功", "200", user);
		} catch (Exception e) {
			result = new JsonResult("注册失败", "500", null);
		}
		JsonWriter.write(resp, result);
	}
}
