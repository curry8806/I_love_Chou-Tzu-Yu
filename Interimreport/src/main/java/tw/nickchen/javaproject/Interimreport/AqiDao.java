package tw.nickchen.javaproject.Interimreport;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class AqiDao {
//	private static final String INSERT_STMT = "INSERT INTO AQI VALUES (?, ?, ?, ?, ?, ?)";
//	private static final String UPDATE_STMT = "UPDATE AQI SET SiteName=?, Country=?, AQI=?, Status=?, SO2=?, SO2_AVG=? WHERE SiteName=?";
//	private static final String DELETE_STMT = "DELETE FROM AQI WHERE SiteName=?";
//	private static final String GET_ONE_STMT = "SELECT SiteName, Country, AQI, Status, SO2, SO2_AVG FROM AQI WHERE SiteName=?";
//	private static final String GET_ALL_STMT = "SELECT SiteName, Country, AQI, Status, SO2, SO2_AVG FROM AQI ORDER BY SiteName";

	DataSource ds = null;

	public AqiDao() {
		try {
			Context context = new InitialContext();
			ds = (DataSource) context.lookup("java:comp/env/jdbc/MemberDB");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

	private static final String INSERT_STMT = "INSERT INTO AQI(SiteName, Country, AQI, Status, SO2, SO2_AVG) VALUES (?, ?, ?, ?, ?, ?)";

	public AqiBean insert(AqiBean aqi) throws SQLException {
		AqiBean result = null;
		try (
			 Connection conn = ds.getConnection(); 
			 PreparedStatement pstmt = conn.prepareStatement(INSERT_STMT);
			) {
			pstmt.setString(1, aqi.getSitename());
			pstmt.setString(2, aqi.getCountry());
			pstmt.setString(3, aqi.getAqi());
			pstmt.setString(4, aqi.getStatus());
			pstmt.setDouble(5, aqi.getSo2());
			pstmt.setString(6, aqi.getSo2_avg());

			int i = pstmt.executeUpdate();
			if (i == 1) {
				result = this.findByAQI(aqi.getSitename());
			}
		}
		return result;
	}

	private static final String UPDATE_STMT = "UPDATE AQI SET SiteName=?, Country=?, AQI=?, Status=?, SO2=?, SO2_AVG=? WHERE SiteName=?";
	
	public int update(AqiBean aqi) throws SQLException {
		int result = 0;
		try(
			Connection conn = ds.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(UPDATE_STMT);
			) {
		        pstmt.setString(1, aqi.getSitename());
		        pstmt.setString(2, aqi.getCountry());
		        pstmt.setString(3, aqi.getAqi());
		        pstmt.setString(4, aqi.getStatus());
		        pstmt.setDouble(5, aqi.getSo2());
		        pstmt.setString(6, aqi.getSo2_avg());
		        pstmt.setString(7, aqi.getSitename());
		        System.out.println(pstmt);
		        result = pstmt.executeUpdate();
		        System.out.println("111111");
		}catch (SQLException e) {
			e.printStackTrace();
		}        
		return result;
	}

	private static final String DELETE_STMT = "DELETE FROM AQI WHERE Sitename=?";

	public int delete(String name) throws SQLException {
		int result = 0;
		try (
			 Connection conn = ds.getConnection(); 
			 PreparedStatement pstmt = conn.prepareStatement(DELETE_STMT);
			) {
			pstmt.setString(1, name);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	private static final String GET_ONE_STMT = "SELECT SiteName, Country, AQI, Status, SO2, SO2_AVG FROM AQI WHERE SiteName=? ";

	public AqiBean findByAQI(String sitename) {
		AqiBean aqi = null;
		try (
			 Connection conn = ds.getConnection(); 
			 PreparedStatement pstmt = conn.prepareStatement(GET_ONE_STMT);
			) {
			pstmt.setString(1, sitename);
			try (
				 ResultSet rs = pstmt.executeQuery();
			) {
				if (rs.next()) {
					aqi = new AqiBean();
					aqi.setSitename(rs.getString("Sitename"));
					aqi.setCountry(rs.getString("Country"));
					aqi.setAqi(rs.getString("Aqi"));
					aqi.setStatus(rs.getString("Status"));
					aqi.setSo2(rs.getDouble("So2"));
					aqi.setSo2_avg(rs.getString("So2_avg"));
 				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return aqi;
	}

	private static final String GET_ALL_STMT = "SELECT SiteName, Country, AQI, Status, SO2, SO2_AVG FROM AQI ORDER BY SiteName";

	public List<AqiBean> getAll() throws SQLException {
		AqiBean aqi = null;
		List<AqiBean> aqis = new Vector<AqiBean>();
		try (
			 Connection conn = ds.getConnection();
			 PreparedStatement pstmt = conn.prepareStatement(GET_ALL_STMT);
			 ResultSet rs = pstmt.executeQuery();
			) {
			while (rs.next()) {
				aqi = new AqiBean();
				aqi.setSitename(rs.getString("Sitename"));
				aqi.setCountry(rs.getString("Country"));
				aqi.setAqi(rs.getString("Aqi"));
				aqi.setStatus(rs.getString("Status"));
				aqi.setSo2(rs.getDouble("So2"));
				aqi.setSo2_avg(rs.getString("So2_avg"));
				aqis.add(aqi);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return aqis;
	}

} // end of class DAO