package lanqiao.servlet;

import lanqiao.service.CarServiceImpl;
import lanqiao.vo.JsonResult;
import lanqiao.vo.JsonWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;

@WebServlet("/api/Car/add")
public class AddCarServletImpl extends HttpServlet{
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String detailProductId =req.getParameter("detailProductId");
        Integer detailProductCount =Integer.valueOf(req.getParameter("detailProductCount"));
        String detailProductUnit =req.getParameter("detailProductUnit");
        BigDecimal detailProductPrice =BigDecimal.valueOf(Double.valueOf(req.getParameter("detailProductPrice")));
        String detailComment =req.getParameter("detailComment");
        String detailUserId =req.getParameter("detailUserId");
        CarServiceImpl impl = new CarServiceImpl();
        JsonResult result = null;
        Boolean bool = null;
        try {
            bool = impl.addCar(detailProductId,
                    detailProductCount,
                    detailProductUnit,
                    detailProductPrice,
                    detailComment,
                    detailUserId);
            if (bool==false){
                result = new JsonResult("加入失败","500","null");
            }else{
                result = new JsonResult("加入成功","200","detailUserId");
            }
        }catch (Exception e){
            e.printStackTrace();
            result = new JsonResult("系统异常","404","null");
        }
        JsonWriter.write(resp,result);
    }
}
