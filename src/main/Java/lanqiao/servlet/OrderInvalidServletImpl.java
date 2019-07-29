package lanqiao.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lanqiao.service.OrderServiceImpl;
import lanqiao.vo.JsonResult;
import lanqiao.vo.JsonWriter;

@WebServlet("/order/invalid")
public class OrderInvalidServletImpl extends HttpServlet{
	/**
	 * 订单作废
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String orderid = req.getParameter("orderid");
		OrderServiceImpl impl = new OrderServiceImpl();
		JsonResult result = null;
		
		try {
			Boolean bool = impl.orderInvalid(orderid);
			if(bool==true) {
				result = new JsonResult("作废成功", "200", orderid);
			}else {
				result = new JsonResult("作废失败", "500", null);
			}
		} catch (Exception e) {
			e.printStackTrace();
			result = new JsonResult("系统异常", "404", null);
		}
		JsonWriter.write(resp, result);
	}
}
