package tw.nickchen.javaproject.getone;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



/**
 * Servlet implementation class GetOneServlet
 */
@WebServlet("/Getone/aqi.do")
public class GetOneServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		Collection<String> errorMessage = new ArrayList<String>();
		request.setAttribute("ErrorMsg", errorMessage);

		// 設定輸入資料的編碼
		request.setCharacterEncoding("UTF-8");
		
		HttpSession session = request.getSession();
		String aqi = request.getParameter("AQI");
		// 檢查使用者所輸入的資料
		
		System.out.println(aqi);
		if (aqi == null || aqi.trim().length() == 0) {
			errorMessage.add("空氣品質指標欄必須為數值");
		}
		if (!errorMessage.isEmpty()) {
			RequestDispatcher rd = request.getRequestDispatcher("/Getone/GetAqiError.jsp");
			rd.forward(request, response);
			return;
		}
		 AqiService service = new AqiService();
		 AqiBean AQI= service.select(aqi);
		 session.setAttribute("Aqi", AQI );

		 // 依照執行的結果挑選適當的view元件，送回相關訊息
		 // 產生 RequestDispatcher 物件 rd
		 RequestDispatcher rd = request.getRequestDispatcher("/Getone/GetAqiSuccess.jsp");
		 // 請容器代為呼叫下一棒程式
		 rd.forward(request, response);
		 return;		     
	}

}
