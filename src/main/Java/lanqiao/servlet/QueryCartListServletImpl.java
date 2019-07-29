package lanqiao.servlet;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lanqiao.model.Detail;
import lanqiao.service.CarServiceImpl;
import lanqiao.vo.JsonResult;
import lanqiao.vo.JsonWriter;

@WebServlet("/api/car/list")
public class QueryCartListServletImpl extends HttpServlet{
	/**
	 * 查询购物车
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uid = req.getParameter("uid");
		CarServiceImpl impl = new CarServiceImpl();
		JsonResult result = null;
		try {
			List<Detail> list = impl.queryCartList(uid);
			//List<Map<String,Object>> list = impl.queryCartList(uid);
			if(list!=null){
				result = new JsonResult("查询成功", "200", list);
			}else {
				result = new JsonResult("查询失败", "500", null);
			}
		} catch (Exception e) {
			e.printStackTrace();
			result = new JsonResult("系统异常", "404", null);
		}
		JsonWriter.write(resp, result);
	}
}
