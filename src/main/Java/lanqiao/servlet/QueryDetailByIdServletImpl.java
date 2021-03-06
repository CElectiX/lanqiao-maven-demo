package lanqiao.servlet;

import lanqiao.model.Detail;
import lanqiao.service.OrderServiceImpl;
import lanqiao.vo.JsonResult;
import lanqiao.vo.JsonWriter;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/order/detail")
public class QueryDetailByIdServletImpl extends HttpServlet{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String orderid = req.getParameter("orderid");
		OrderServiceImpl impl = new OrderServiceImpl();
		JsonResult result =null;
		Detail detail = null;
		try {
			detail = impl.queryDetailById(orderid);
			if(detail==null) {
				result = new JsonResult("订单不存在", "500", null);
			}else {
				result = new JsonResult("查询成功", "200", detail);
			}
		} catch (Exception e) {
			e.printStackTrace();
			result = new JsonResult("系统异常", "404", null);
		}
		JsonWriter.write(resp, result);
	}
}
