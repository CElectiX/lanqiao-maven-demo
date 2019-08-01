package lanqiao.servlet;

import lanqiao.model.User;
import lanqiao.service.UserServiceImpl;
import lanqiao.vo.JsonResult;
import lanqiao.vo.JsonWriter;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/api/login")
public class loginServletImpl extends HttpServlet{
	/**
	 * 登陆
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String userUserName = req.getParameter("username");
		String userPassword = req.getParameter("password");
		UserServiceImpl impl = new UserServiceImpl();
		JsonResult result = null;
		try {
			User user = impl.login(userUserName, userPassword);
			if(user==null) {
				result = new JsonResult("用户名或密码错误", "404", null);
			}else if (userUserName==null&&userPassword==null){
				result = new JsonResult("请输入用户名密码", "500", user);
			}else{
				result = new JsonResult("登陆成功", "200", user);
			}
		} catch (Exception e) {
			e.printStackTrace();
			result = new JsonResult("登陆失败，请稍后再试", "500", e.getMessage());
		}
		JsonWriter.write(resp, result);
	}
}
