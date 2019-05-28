package tw.nickchen.javaproject.Interimreport;

import java.sql.SQLException;
import java.util.List;

public class AqiService {
	
	AqiDao dao = null;
	
	public AqiService() {
		dao = new AqiDao();
	}	

	public AqiBean select(String sitename) {
		return dao.findByAQI(sitename);
	}
	
	public List<AqiBean> select() throws SQLException {
		return dao.getAll();
	}

	public AqiBean insertAqi(AqiBean bean) throws SQLException {
		return dao.insert(bean);
	}

	public int delete(String name) throws SQLException { 
		return dao.delete(name);
	}
	public int update(AqiBean bean) throws SQLException {
		return dao.update(bean); 
		
	}

	public void update(String sa) {
		
	}

}