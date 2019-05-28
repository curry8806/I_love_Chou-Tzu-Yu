package tw.nickchen.javaproject.getall;

import java.io.Serializable;

public class AqiBean implements Serializable {
	private static final long serialVersionUID = 1L;
	private String sitename;
	private String country;
	private String aqi;
	private String status;
	private double so2;
	private String so2_avg;
	
	public AqiBean(String sitename, String country, String aqi, String status, double so2, String so2_avg) {
		super();
		this.sitename = sitename;
		this.country = country;
		this.aqi = aqi;
		this.status = status;
		this.so2 = so2;
		this.so2_avg = so2_avg;
	}
	
	public AqiBean() {
	}

	public String toString() {
		return "["+sitename+","+country+","+aqi+","+status+","+so2+","+so2_avg+"]";
	}
	
	public String getSitename() {
		return sitename;
	}
	public void setSitename(String sitename) {
		this.sitename = sitename;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getAqi() {
		return aqi;
	}
	public void setAqi(String aqi) {
		this.aqi = aqi;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Double getSo2() {
		return so2;
	}
	public void setSo2(double so2) {
		this.so2 = so2;
	}
	public String getSo2_avg() {
		return so2_avg;
	}
	public void setSo2_avg(String so2_avg) {
		this.so2_avg = so2_avg;
	}
		
} // end of class AQIVO