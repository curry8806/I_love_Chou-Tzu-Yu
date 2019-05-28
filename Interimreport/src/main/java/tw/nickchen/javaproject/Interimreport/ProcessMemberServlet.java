package tw.nickchen.javaproject.Interimreport;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Interimreport/aqi.do")
public class ProcessMemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 定義存放錯誤訊息的 Collection物件
		Collection<String> errorMessage = new ArrayList<String>();
		request.setAttribute("ErrorMsg", errorMessage);

		// 設定輸入資料的編碼
		request.setCharacterEncoding("UTF-8");
		// 讀取使用者所輸入，由瀏覽器送來的 mId 欄位內的資料，注意大小寫
		String de = request.getParameter("action");
	
		String name = request.getParameter("SiteName");
		// 檢查使用者所輸入的資料
		if (name == null || name.trim().length() == 0) {
			errorMessage.add("監測地點欄必須輸入");
		}
		// 讀取使用者所輸入，由瀏覽器送來的 pswd 欄位內的資料，注意大小寫
		String country = request.getParameter("country");
		// 檢查使用者所輸入的資料
		if (country == null || country.trim().length() == 0) {
			errorMessage.add("監測縣市欄必須輸入");
		}
		// 讀取使用者所輸入，由瀏覽器送來的 mName 欄位內的資料
		String AQI = request.getParameter("AQI");
		// 檢查使用者所輸入的資料
		if (AQI == null || AQI.trim().length() == 0) {
			errorMessage.add("空氣品質指標欄必須為數值");
		}
		// 讀取使用者所輸入，由瀏覽器送來的 mAddress 欄位內的資料
		String Status = request.getParameter("Status");
		// 檢查使用者所輸入的資料
		if (Status == null || Status.trim().length() == 0) {
			errorMessage.add("空氣品質狀態欄必須輸入");
		}
		// 讀取使用者所輸入，由瀏覽器送來的 mBirthday 欄位內的資料
//		String bday = request.getParameter("mBirthday");
//		// 檢核使用者的輸入資料
//		java.sql.Date date = null;
//
//		if (bday != null && bday.trim().length() > 0) {
//			try {
//				date = java.sql.Date.valueOf(bday);
//			} catch (IllegalArgumentException e) {
//				errorMessage.add("生日欄格式錯誤");
//			}
//		}

//		Timestamp ts = new Timestamp(System.currentTimeMillis());
		String so = request.getParameter("SO2");
		double dSo = -1;
		// 檢核使用者的輸入資料
		if (so != null && so.trim().length() > 0) {
			try {
				dSo = Double.parseDouble(so.trim());
			} catch (NumberFormatException e) {
				errorMessage.add("二氧化硫濃度欄必須為數值");
			}
		}
		// 讀取使用者所輸入，由瀏覽器送來的 mPhone 欄位內的資料
		String Savg = request.getParameter("SO2_AVG");
		if (Savg == null || Savg.trim().length() == 0) {
			errorMessage.add("二氧化硫平均濃度欄必須為數值");
			
		}
		// 如果有錯誤，呼叫view元件，送回錯誤訊息
		if (!errorMessage.isEmpty()) {
			RequestDispatcher rd = request.getRequestDispatcher("/Interimreport/InsertAqiError.jsp");
			rd.forward(request, response);
			return;
		}
		// MemberBean 扮演封裝輸入資料的角色
		AqiBean ab = new AqiBean(name, country, AQI, Status, dSo, Savg);
		try {
			AqiService service = new AqiService();
			if(de.equals("新增")) {
				service.insertAqi(ab);
				System.out.println(11111);
			}else if(de.equals("刪除")) {
				service.delete(name);
				System.out.println(22222);
			}else if(de.equals("修改")) {
				service.update(ab);
				System.out.println(33333);
			}else if(de.equals("查詢")) {
				service.select(name);
				System.out.println(44444);
			}
			
		    
			
			request.setAttribute("aqiBean", ab);
			// 依照執行的結果挑選適當的view元件，送回相關訊息
			// 產生 RequestDispatcher 物件 rd
			RequestDispatcher rd = request.getRequestDispatcher("/Interimreport/InsertAqiSuccess.jsp");
			// 請容器代為呼叫下一棒程式
			rd.forward(request, response);
			return;
		} catch (SQLException e) {
			if (e.getMessage().indexOf("重複的索引鍵") != -1 || e.getMessage().indexOf("Duplicate entry") != -1) {
				errorMessage.add("地點重複，請重新輸入地點");
			} else {
				errorMessage.add("資料庫存取錯誤:" + e.getMessage());
			}
			RequestDispatcher rd = request.getRequestDispatcher("/Interimreport/InsertAqiError.jsp");
			rd.forward(request, response);
			return;
		}
	}
}
