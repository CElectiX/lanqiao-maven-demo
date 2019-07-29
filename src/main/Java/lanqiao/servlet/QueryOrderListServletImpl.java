package lanqiao.servlet;

import lanqiao.model.PageResult;
import lanqiao.service.OrderServiceImpl;
import lanqiao.vo.JsonResult;
import lanqiao.vo.JsonWriter;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet("/order/list")
public class QueryOrderListServletImpl extends HttpServlet{
	/**
	 * 分页查询订单列表
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		JsonResult result = null;
		try {
			int pageNum = Integer.parseInt(req.getParameter("pageNum"));
			int pageSize = Integer.parseInt(req.getParameter("pageSize"));
			OrderServiceImpl impl = new OrderServiceImpl();
			PageResult pgresult = impl.queryOrderList(pageNum, pageSize);
			result = new JsonResult("查询成功", "200", pgresult);
		} catch (Exception e) {
			e.printStackTrace();
			result = new JsonResult("查询失败", "500", e.getMessage());
		}
		JsonWriter.write(resp, result);
	}
}
