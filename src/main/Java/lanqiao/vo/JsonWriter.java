package lanqiao.vo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

public class  JsonWriter {
	public static void write(HttpServletResponse response,JsonResult result) throws IOException {
		response.setContentType("application/json");
		PrintWriter pw =response.getWriter();
		Gson gs = new Gson();
		String json = gs.toJson(result);
		pw.write(json);
		pw.flush();
		pw.close();
	}
}
