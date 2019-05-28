package tw.nickchen.javaproject.getall;

import java.sql.SQLException;
import java.util.List;

public class AqiService {
	
	AqiDao dao = null;
	
	public AqiService() {
		dao = new AqiDao();
	}	

	public AqiBean select(String Aqi) {
		return dao.findByAQI(Aqi);
	}
	
	public List<AqiBean> getAllAqis() throws SQLException {
		return select();
	}

	public List<AqiBean> select() throws SQLException {
		return dao.getAll();
	}

	public AqiBean insertAqi(AqiBean bean) throws SQLException {
		return dao.insert(bean);
	}

	public int delete(String SO2_AVG) throws SQLException { 
		return dao.delete(SO2_AVG);
	}
}